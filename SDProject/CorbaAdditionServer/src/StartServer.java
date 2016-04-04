/**
 *
 * @author imed
 */
import AdditionApp.*;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import java.util.Properties;

public class StartServer {

	public static void main(String args[]) {
		if (args.length != 2){
			System.out.println("Usage : java -jar corbaServer.jar <port> <ip>");
			System.exit(0);
		}
		try {
			String as[] = new String[4];
			as[0] = "-ORBInitialPort";
			as[1] = args[0];
			as[2] = "-ORBInitialHost";
			as[3] = args[1];
			
			// create and initialize the ORB //// get reference to rootpoa &amp; activate the POAManager    
			ORB orb = ORB.init(as, null);
			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate();

			// create servant and register it with the ORB
			AdditionObj addobj = new AdditionObj();
			addobj.setORB(orb); 

			// get object reference from the servant
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(addobj);
			Addition href = AdditionHelper.narrow(ref);

			org.omg.CORBA.Object objRef =  orb.resolve_initial_references("NameService");
			NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

			NameComponent path[] = ncRef.to_name( "ABC" );
			ncRef.rebind(path, href);

			System.out.println("Addition Server ready and waiting ...");

			// wait for invocations from clients
			for (;;){
				orb.run();
			}
		} 

		catch (Exception e) {
			System.err.println("ERROR: " + e);
			e.printStackTrace(System.out);
		}

		System.out.println("HelloServer Exiting ...");

	}
}