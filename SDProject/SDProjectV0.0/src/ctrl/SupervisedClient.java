package ctrl;

import lipermi.handler.CallHandler;
import lipermi.net.Client;
import tests.TestFrame;

/**
 * Class which represent the client
 */
public class SupervisedClient {

	//The client
	private Client client = null;
	private String name = "";		//His name
	
	/**
	 * Constructor of the client
	 * @param ip	The remote ip
	 * @param port	The remote port
	 * @param name	The name of the client
	 */
	public SupervisedClient(String ip, int port, String name){
		
		this.name = name;
		
		System.out.println("										CLIENT : Begin");
		
		System.out.println("										CLIENT :	Binding ...");
		
		CallHandler callHandler = new CallHandler();

		try{
			this.client = new Client(ip, port, callHandler);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("										CLIENT :	Binding ok");
		
		System.out.println("										CLIENT : 	Test connection ...");
		
		ConnectivityServices connecivityServicesRemote;
		connecivityServicesRemote = (ConnectivityServices) this.client.getGlobal(ConnectivityServices.class);
		
		connecivityServicesRemote.connectedClient(name);
		
		
		System.out.println("										CLIENT : 	Test connection ok");
		
		System.out.println("										CLIENT : Connected");
		
		ClientConnectionChecker routine = new ClientConnectionChecker(this.client, name);
		routine.start();
		
		//TODO TESTER
		@SuppressWarnings("unused")
		TestFrame tester = new TestFrame(this.client);
		
	}
	
	/**
	 * Method which is used to knwo the name of this client
	 * @return
	 */
	public String getName(){
		return this.name;
	}
}
