

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.registry.Registry;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Main menu of the application
 */
public class MainMenu extends JFrame{

	/**
	 * Serial version number
	 */
	private static final long serialVersionUID = 5734930512008478971L;

	private Registry r = null;
	
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
		JButton supervisorBtn = new Button("Lauch Server");
		JButton supervisBtn = new Button("Lauch Client");
		
		/**** Actions ****/
		//To close properly the frame
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				//UnicastRemoteObject.unexportObject(r, true); //IDEE pour supprimer le registry
				System.exit(0);
				
			}
		});
		
		
		supervisorBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StartServer s = new StartServer();
				//this.r = s.r; //IDEE pour supprimer le registry
			}
		});
		
		supervisBtn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ChatUI.lauch();
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
		this.setTitle("GroupChat");
		this.setResizable(false);
		this.pack();
	}
	
}
