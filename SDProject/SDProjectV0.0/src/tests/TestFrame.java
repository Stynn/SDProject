package tests;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import laf.Button;
import lipermi.net.Client;


public class TestFrame extends JFrame{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -372595299695958905L;

	private Client client;
	
	public TestFrame(Client client){
		this.client = client;
		
		/**** Attributes ****/
		//The main layout manager
		GroupLayout layout;
		
		//Main panel of the frame
		JPanel mainPanel = null;
		
		//Buttons
		Button sendImprEcr = new Button("Send img !");
		
		
		/**** Actions ****/
		
		sendImprEcr.addActionListener(new SendImgActionListener(this){
			@Override
			public void actionPerformed(ActionEvent e) {
				TestServices testServices;
				testServices = (TestServices) this.parent.client.getGlobal(TestServices.class);
				
				
				Rectangle screenRect = new Rectangle(0,0,10,10);
				Robot robot = null;
				try {
					robot = new Robot();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				BufferedImage img = robot.createScreenCapture(screenRect);
				
				testServices.getImage(img);
			}
		});
		
		/**** Construction ****/
		
		//Panel and layout construction
		mainPanel = new JPanel();
		
		
		layout = new GroupLayout(mainPanel);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		mainPanel.setLayout(layout);
		
		layout.setHorizontalGroup(
		   layout.createSequentialGroup()
		   .addGroup(layout.createParallelGroup()
				   .addComponent(sendImprEcr))
			   
		);
		layout.setVerticalGroup(
		   layout.createSequentialGroup()
		   .addComponent(sendImprEcr)
		);
		
		
		//Frame construction
		this.add(mainPanel);
		this.pack();
		this.setTitle("TESTER");
		this.setResizable(false);
		this.setVisible(true);
	}
	
}
