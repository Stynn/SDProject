package ctrl;

import laf.ShowDialog;
import lipermi.net.Client;

/**
 * Class which represent the checker of connection of the client
 */
public class ClientConnectionChecker extends Thread {
	
	private String clientName = "";	//Client name of the routine
	private Client client = null;
	
	/**
	 * Constructor of the Thread
	 * @param name Client name of the routine
	 */
	public ClientConnectionChecker(Client client, String name){
		this.client = client;
		this.clientName = name;
	}
	
	/**
	 * Routine
	 */
	public void run() {
		Boolean isConnected = true;
		while (isConnected){
			//Every 2s checking the connection
			//System.out.println("										CLIENT<"+this.clientName+"> : Server listenning ...");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//Check if we are always into the server list
			ConnectivityServices connecivityServicesRemote;
			connecivityServicesRemote = (ConnectivityServices) this.client.getGlobal(ConnectivityServices.class);
			if (!connecivityServicesRemote.amIConnected(this.clientName)){
				isConnected = false;
			}
		}
		
		System.out.println("										CLIENT<"+this.clientName+"> : End");
		@SuppressWarnings("unused")
		ShowDialog s = new ShowDialog("Service stoped by the supervisor");
		
	}
}
