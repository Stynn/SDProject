import java.io.IOException;

import lipermi.exception.LipeRMIException;
import lipermi.handler.CallHandler;
import lipermi.net.Server;

public class ServerRun {

	public static void main(String[] args) {
		if (args.length != 1){
			System.out.println("Usage : java -jar lipeServer.jar <port>");
			System.exit(0);
		}
		int port = Integer.valueOf(args[0]);
		System.out.println("Lancement du serveur ...");
		System.out.println("	Création du service ...");
		ExampleServiceImpl myService = new ExampleServiceImpl();

		System.out.println("	Création du callHandler ...");
		// it always need a CallHandler!
		CallHandler callHandler = new CallHandler();
		try {
			callHandler.registerGlobal(ExampleService.class, myService);
		} catch (LipeRMIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("	Binding du serveur ...");
		Server server = new Server();
		int thePortIWantToBind = port;
		try {
			server.bind(thePortIWantToBind, callHandler);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Serveur lancé !");
	}
}