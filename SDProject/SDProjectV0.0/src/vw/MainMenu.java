package vw;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ctrl.SupervisorServer;
import laf.Button;

/**
 * Main menu of the application
 */
public class MainMenu extends JFrame{

	/**
	 * Serial version number
	 */
	private static final long serialVersionUID = 5734930512008478971L;

	/**
	 * Constructor of the main menu
	 */
	public MainMenu(){
		/**** Attributes ****/
		
		//The main layout manager
		GroupLayout layout;
		
		//Main panel of the frame
		JPanel mainPanel = null;
		
		//Button 'supervisor' and 'supervised'
		JButton supervisorBtn = new Button("Supervisor");
		JButton supervisBtn = new Button("Supervised");
		
		/**** Actions ****/
		//To close properly the frame
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		
		supervisorBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lauchSupervisor();
				
			}
		});
		
		supervisBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ConnectForm connect = new ConnectForm();
				connect.setVisible(true);
			}
			
		});
		
		/**** Construction ****/
		//btn 'superviseur'
		supervisorBtn.setMinimumSize(new Dimension(200, 40));
		
		
		//btn 'supervisé'
		supervisBtn.setMinimumSize(new Dimension(200, 40));
		
		//panel and layout construction
		mainPanel = new JPanel();
		
		layout = new GroupLayout(mainPanel);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		mainPanel.setLayout(layout);
		
		layout.setHorizontalGroup(
		   layout.createSequentialGroup()
		   .addGroup(layout.createParallelGroup()
				   .addComponent(supervisorBtn)
				   .addComponent(supervisBtn))
		);
		layout.setVerticalGroup(
		   layout.createSequentialGroup()
	           .addComponent(supervisorBtn)
	           .addComponent(supervisBtn)
		);

		//Frame construction
		this.add(mainPanel);
		this.setLocationRelativeTo(null);
		this.setTitle("Viewer : Menu");
		this.setResizable(false);
		this.pack();
	}
	
	/**
	 * Method use when the button 'supervisor' is used
	 */
	private void lauchSupervisor(){
		//Instanciation of the server lipeRMI
		SupervisorServer sServer = new SupervisorServer();
		
		int port = sServer.getPort();
		//Creation of the frame of the supervisor
		ViewerFrame wf = new ViewerFrame(port, sServer);
		sServer.setViewer(wf);
		sServer.addVieverServices();
		wf.setVisible(true);
	}
	
}
