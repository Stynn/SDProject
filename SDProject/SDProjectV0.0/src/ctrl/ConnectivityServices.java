package ctrl;

/**
 * Interface of all remote connectivity services
 *
 */
public interface ConnectivityServices {
	
	public void connectedClient(String client);
	
	public Boolean amIConnected(String name);
}
