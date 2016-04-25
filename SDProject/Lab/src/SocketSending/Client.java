package SocketSending;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

	public static void main(String[] args) { 
        try {
        	Socket sock = new Socket("77.130.5.124",5001);
			Commun.transfert(
			        new FileInputStream("test.jpg"),
			        sock.getOutputStream(),
			        true);
			
			sock.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}