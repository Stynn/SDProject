package vw;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ctrl.AddressIPGetter;
import ctrl.SupervisorServer;
import laf.Button;
import laf.ComboBox;
import laf.ShowDialog;
import utils.CFrameAdapter;
import utils.DiscoHostActionListener;

/**
 * The frame use by the supervisor
 */
public class ViewerFrame extends JFrame{

	public Displayer displayer;	//The displayer of image from the supervised
	private ComboBox<String> hostCbx = null;
	private SupervisorServer server = null;
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1962228857416521894L;

	/**
	 * Constructor of the frame
	 */
	public ViewerFrame(int port, SupervisorServer server){
		/**** Attributes ****/
		this.server = server;
		
		//Ip
		String ip = "A.B.C.D";
		
		//Panels
		JPanel mainPanel = null;
		JPanel subPanel1 = null;
		
		//Layout manager for the first sub panel and the second sub panel
		GroupLayout subLayout1;
		
		
		//Buttons
		Button disconnectHostBtn;
		Button disconnectHostsBtn;
		
		/**** Actions ****/
		
		this.addComponentListener(new CFrameAdapter(this) {
			public void componentResized(ComponentEvent e) {
				//Update the image displayed
				this.parent.displayer.updateDisplay(null, this.parent.displayer.getWidth(), this.parent.displayer.getHeight());
		    }
		});
		
		
		/**** Construction ****/
		//Main panel
		mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		subPanel1 = new JPanel();
		try {
			displayer = new Displayer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//Combobox default
		hostCbx = new ComboBox<String>();
		hostCbx.addItem(new String("None"));
		
		//Buttons
		disconnectHostBtn = new Button("Disconnect this host");
		disconnectHostsBtn = new Button("Disconnect all hosts");
		
		//Organization of the group layout
		
		subLayout1 = new GroupLayout(subPanel1);
		
		subLayout1.setAutoCreateGaps(true);
		subLayout1.setAutoCreateContainerGaps(true);
		
		subPanel1.setLayout(subLayout1);
		
		subLayout1.setHorizontalGroup(
			subLayout1.createSequentialGroup()
				.addComponent(hostCbx)
				.addComponent(disconnectHostBtn)
				.addComponent(disconnectHostsBtn)
		);
		subLayout1.setVerticalGroup(
			subLayout1.createSequentialGroup()
				.addGroup(subLayout1.createParallelGroup()
						   .addComponent(hostCbx)
						   .addComponent(disconnectHostBtn)
						   .addComponent(disconnectHostsBtn))
		);
		
		//The main panel
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(subPanel1);
		mainPanel.add(displayer);
		
		this.add(mainPanel);
		this.setTitle("Viewer - "+ip+" : "+port);
		this.setSize(new Dimension(1200,900));
		this.setVisible(true);
		
		ip = AddressIPGetter.getIp();
		this.setTitle("Viewer - "+ip+" : "+port);
		
		@SuppressWarnings("unused")
		ShowDialog s = new ShowDialog("Successful launch of the server !");
		
		
		/** Actions **/
		disconnectHostsBtn.addActionListener(new DiscoHostActionListener(this){
			@Override
			public void actionPerformed(ActionEvent e) {
				this.parent.discoHosts();
			}
		});
		
		disconnectHostBtn.addActionListener(new DiscoHostActionListener(this){
			@Override
			public void actionPerformed(ActionEvent e) {
				this.parent.discoHost();
			}
		});
		
		
	}
	
	/**
	 * Methode use to update the combobox of clients
	 */
	public void addClient(String name){
		if(this.hostCbx.getItemAt(0).toString().equalsIgnoreCase("None"))
			this.hostCbx.removeAllItems();
		this.hostCbx.addItem(name);
	}
	
	/**
	 * Method use to disconnect all hosts
	 */
	public void discoHosts(){
		this.server.suppressAllClient();
		this.hostCbx.removeAllItems();
		this.hostCbx.addItem("None");
	}
	
	/**
	 * Method use to disconnect the host selected on 
	 */
	public void discoHost(){
		int index = this.hostCbx.getSelectedIndex();
		this.server.suppressClient((String)this.hostCbx.getSelectedItem());
		this.hostCbx.removeItemAt(index);
		if (this.hostCbx.getItemCount() == 0)
			this.hostCbx.addItem("None");
	}
}
