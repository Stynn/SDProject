package ctrl;

import lipermi.handler.CallHandler;
import lipermi.net.Client;

/**
 * Class which represent the client
 */
public class SupervisedClient {

	private Client client = null; 	//The client
	private String name = "";		//His name
	
	/**
	 * Constructor of the client
	 * @param ip	The remote ip
	 * @param port	The remote port
	 * @param name	The name of the client
	 */
	public SupervisedClient(String ip, int port, String name){
		
		this.name = name;
		
		System.out.println("										CLIENT<"+this.name+"> : Begin");
		
		System.out.println("										CLIENT<"+this.name+"> :	Binding ...");
		
		CallHandler callHandler = new CallHandler();

		try{
			this.client = new Client(ip, port, callHandler);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("										CLIENT<"+this.name+"> :	Binding ok");
		
		System.out.println("										CLIENT<"+this.name+"> : 	Test connection ...");
		
		ConnectivityServices connecivityServicesRemote;
		connecivityServicesRemote = (ConnectivityServices) this.client.getGlobal(ConnectivityServices.class);
		
		connecivityServicesRemote.connectedClient(name);
		
		
		
		System.out.println("										CLIENT<"+this.name+"> : 	Test connection ok");
		
		
		
		System.out.println("										CLIENT<"+this.name+"> : Connected");
		
		ClientSuperRoutine routinelvl0 = new ClientSuperRoutine(this.client, name, ip, port);
		routinelvl0.start();
	}
}
