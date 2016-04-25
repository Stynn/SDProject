package ctrl;


/**
 * Interface of all remote connectivity services
 *
 */
public interface ConnectivityServices {
	
	/**
	 * Connect a client to the server
	 * @param client The name of the client to connect
	 */
	public void connectedClient(String client);
	
	/**
	 * Check if the client if always connected to the server
	 * @param name The name of the client to check
	 * @return True if the client is connected, False if the client isn't
	 */
	public Boolean amIConnected(String name);
}
