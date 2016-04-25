package ctrl;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import lipermi.net.Client;
import test.Transmitter;
import utils.ImageManipulator;

/**
 * This class is the routine lvl 1, send images (and parameters)
 */
public class ClientRoutineImage extends Thread{
	
	private String clientName = "";	//This is the name of the client
	private String ip;				//The ip of the server
	private int port;				//The port of the server
	private ClientSuperRoutine parent;
	
	/**
	 * Constructor of the routine
	 * @param client
	 * @param name
	 */
	public ClientRoutineImage(Client client, String name, String ip, int port, ClientSuperRoutine parent){
		this.clientName = name;
		this.ip = ip;
		this.port = port;
		this.parent = parent;
	}
	
	/**
	 * Routine
	 */
	public void run(){

		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width  = (int)dimension.getWidth();
		
		//Take a screeshot to send
		Rectangle screenRect = new Rectangle(0,0,width,height);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		
		Socket sock = null;
		while(this.parent.getSending()){
					
			//Open a socket towards the server
			try {
				sock = new Socket(this.ip, this.port+1);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println("										CLIENT<"+clientName+"> Sending frame ...");
			BufferedImage img = robot.createScreenCapture(screenRect);
			
			//Creation of the image on disk
			ImageManipulator.createImageOnDisk(img);
			
			//Sending sending image by socket
			try {
				Transmitter.transmit(new FileInputStream("tmpE.jpeg"), sock.getOutputStream(), true);
			} catch (FileNotFoundException e) {
				//e.printStackTrace();
			} catch (IOException e) {
				//e.printStackTrace();
			}
			
			//TODO Wainting ack from server
			
			//TODO here or somewhere else : Sending parameters to the server
		}
	}
}
