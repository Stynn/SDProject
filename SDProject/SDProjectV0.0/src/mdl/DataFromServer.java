package mdl;

import java.util.ArrayList;

/**
 * Class of data
 */
public class DataFromServer {

	private ArrayList<String> clients;
	private String activeClient;
	private Boolean playStateServer = false;
	
	/**
	 * Constructor of the data structure
	 */
	public DataFromServer(){
		clients = new ArrayList<String>();
		activeClient = "";
	}

	/**
	 * Use to add a client
	 * @param name
	 */
	public void addClient(String name){
		this.clients.add(name);
	}
	
	/**
	 * Use to remove all client of the data structure
	 */
	public void removeAllClients(){
		this.clients = new ArrayList<String>();
	}
	
	/**
	 * Use to remove one host only
	 * @param name
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
	
	//GETTER AND SETTER
	
	
	public ArrayList<String> getClients() {
		return clients;
	}

	public void setClients(ArrayList<String> clients) {
		this.clients = clients;
	}

	public String getActiveClient() {
		return activeClient;
	}

	public void setActiveClient(String activeClient) {
		this.activeClient = activeClient;
	}
	
	public Boolean getPlayStateServer() {
		return playStateServer;
	}
	
	//Use to know if the server accept or not image from clients
	public void setPlay(){
		this.playStateServer = true;
	}
	
	public void setPause(){
		this.playStateServer = false;
	}
	
	
	
	
	
}
