package ctrl;


import java.io.IOException;
import java.util.ArrayList;

import lipermi.exception.LipeRMIException;
import lipermi.handler.CallHandler;
import lipermi.net.Server;
import tests.TestServices;
import tests.TestServicesImpl;
import vw.ViewerFrame;

/**
 * This is the server of the application
 */
public class SupervisorServer {

	private Server server;						//Server into the server
	private int port;							//Port of the server
	private ViewerFrame viewer;					//Viewer associate to the server
	private ArrayList<String> clients;			//List of clients supervised
	private CallHandler cH;						//The callhandler of the server
	
	/**
	 * Constructor of the server
	 */
	public SupervisorServer(){
		
		clients = new ArrayList<String>();
		
		System.out.println("SERVER : Begin");
		
		
		System.out.println("SERVER :	Binding ...");
		this.server = new Server();
		
		System.out.println("SERVER :		Listing services ...");
		ConnectivityServicesImpl connectivityServices = new ConnectivityServicesImpl(this);
		
		cH = new CallHandler();
		try{
			cH.registerGlobal(ConnectivityServices.class, connectivityServices);
		}catch(LipeRMIException e){
			e.printStackTrace();
		}
		System.out.println("SERVER :		Services ok");
		
		System.out.println("SERVER :		Searching port ...");
		this.port = 5000;
		Boolean portOk = false;
		
		while (!portOk){
			try{
				server.bind(this.port, cH);
				portOk = true;
			}catch(IOException e){
				this.port++;
			}
		}
		
		System.out.println("SERVER :		Port ok");
		System.out.println("SERVER :	Binding ok");
		
		
		
		System.out.println("SERVER : Listening on port : "+this.port);
	}
	
	/**
	 * Method use to add the service in liaison with the viewer
	 */
	public void addVieverServices(){
		TestServicesImpl testServices = new TestServicesImpl(this.viewer);	//TODO for test
		try{
			cH.registerGlobal(TestServices.class, testServices);
		}catch(LipeRMIException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Method use to know the port which the server running on
	 * @return The port of the server
	 */
	public int getPort(){
		return this.port;
	}
	
	/**
	 * Référence to the frame of the server
	 * @param wf
	 */
	public void setViewer(ViewerFrame wf){
		this.viewer = wf;
	}
	
	/**
	 * Method use to add a client into the server and to refresh the frame
	 * @param name
	 */
	public void addClient(String name){
		this.clients.add(name);
		this.viewer.addClient(name);
	}
	
	/**
	 * Method to suppress all client
	 */
	public void suppressAllClient(){
		this.clients = new ArrayList<String>();
	}
	
	/**
	 * Method use to suppress one host
	 */
	public void suppressClient(String name){
		int i = 0;
		for(String currentName : this.clients){
			if (currentName.equalsIgnoreCase(name))
				break;
			i++;
		}
		this.clients.remove(i);
	}
	
	/**
	 * 
	 */
	public ArrayList<String> getClients(){
		return this.clients;
	}
}
