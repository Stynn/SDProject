package SocketSending;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) { 
        Socket sock;
		try {
			System.out.println("Waiting ...");
			sock = new ServerSocket(5001).accept();
			Commun.transfert(
	                sock.getInputStream(),
	                new FileOutputStream("test2.jpg"),
	                true);
	        
	        sock.close();
	        System.out.println("finish");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
    } 

}
