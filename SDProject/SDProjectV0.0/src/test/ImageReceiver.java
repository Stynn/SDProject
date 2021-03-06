package test;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import ctrl.SupervisorServer;
import utils.ImageManipulator;

public class ImageReceiver extends Thread{

	private Socket sock;
	private ServerSocket socket;
	private SupervisorServer server;
	
	/**
	 * Constructor of the imageReceiver
	 * @param socket The socket of the server
	 * @param port The port of the server
	 * @param server The server
	 */
	public ImageReceiver(ServerSocket socket, int port, SupervisorServer server){
		this.socket = socket;
		this.server = server;
	}
	
	/**
	 * Run of the thread
	 */
	public void run(){
		while(true){
			//Waiting for the image
			try {
				sock = socket.accept();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			try {
				Transmitter.transmit(sock.getInputStream(), new FileOutputStream("tmpR.jpeg"), true);
				//TODO think about close the socket one day
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//We retrieve the image from the disk and we display it
			BufferedImage image = ImageManipulator.retrieveImageFromDisk();
			this.server.getViewer().displayer.updateDisplay(image, this.server.getViewer().displayer.getWidth(), this.server.getViewer().displayer.getHeight());
			
		}
	}
}
