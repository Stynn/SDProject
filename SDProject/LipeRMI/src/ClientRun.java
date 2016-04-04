import java.io.IOException;

import lipermi.handler.CallHandler;
import lipermi.net.Client;

public class ClientRun {
	public static void main(String[] args) {
		if (args.length != 2){
			System.out.println("Usage : java -jar lipeClient.jar <adresse> <port>");
			System.exit(0);
		}
		String adresse = args[0]; 
		int port = Integer.valueOf(args[1]);
		System.out.println("Lancement du client ...");
		System.out.println("	Création du callHandler ...");
		// it always need a CallHandler!
		CallHandler callHandler = new CallHandler();

		System.out.println("	Binding du client ...");
		// first we need to connect..
		Client client = null;
		try {
			client = new Client(adresse, port, callHandler);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("	Récupération du service ...");
		// then we can get the remote reference
		ExampleService myServiceRemote;
		myServiceRemote = (ExampleService) client.getGlobal(ExampleService.class);

		System.out.println("	Utilisation du service :");
		myServiceRemote.someMethod();
		System.out.println("Fin du client");
	}
}