package vw;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ctrl.AddressIPGetter;
import ctrl.SupervisedClient;
import laf.Button;
import laf.Label;
import laf.ShowDialog;
import laf.TextField;

/**
 * Connection frame for the supervised
 */
public class ConnectForm extends JFrame{

	//TextEdits of the frame
	TextField ipTxt;
	TextField portTxt;
	TextField nameTxt;
	
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -1788127507858417887L;

	/**
	 * Constructor of the connection frame
	 */
	public ConnectForm(){
		/**** Attributes ****/
		//The main layout manager
		GroupLayout layout;
		
		//Main panel of the frame
		JPanel mainPanel = null;
		
		//The panel of the button
		JPanel subPanel = null;
		
		//Labels of the frame 'IP Adress' 'Port'
		Label ipLbl;
		Label portLbl;
		Label nameLbl;
		
		//Button 'connect'
		Button connect = new Button("Connect");
		
		/**** Actions ****/
		
		connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				connect();
			}
		});
		
		/**** Construction ****/
		//Labels
		ipLbl = new Label("IP Adress :");
		ipLbl.setMinimumSize(new Dimension(200, 33));
		portLbl = new Label("Port :");
		nameLbl = new Label("Name :");
		
		//EditTexts
		ipTxt = new TextField();
		portTxt = new TextField();
		nameTxt = new TextField();
		
		//Button
		connect.setMinimumSize(new Dimension(100,33));
		

		
		//Panel and layout construction
		mainPanel = new JPanel();
		subPanel = new JPanel(new GridBagLayout());
		subPanel.add(connect);
		
		layout = new GroupLayout(mainPanel);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		mainPanel.setLayout(layout);
		
		layout.setHorizontalGroup(
		   layout.createSequentialGroup()
		   .addGroup(layout.createParallelGroup()
			   .addComponent(ipLbl)
			   .addComponent(ipTxt)
			   .addComponent(portLbl)
			   .addComponent(portTxt)
			   .addComponent(nameLbl)
			   .addComponent(nameTxt)
			   .addComponent(subPanel))
			   
		);
		layout.setVerticalGroup(
		   layout.createSequentialGroup()
	           .addComponent(ipLbl)
	           .addComponent(ipTxt)
	           .addComponent(portLbl)
	           .addComponent(portTxt)
	           .addComponent(nameLbl)
	           .addComponent(nameTxt)
	           .addComponent(subPanel)
		);
		
		
		//Frame construction
		this.add(mainPanel);
		this.pack();
		this.setTitle("Viewer : connect");
		this.setResizable(false);
		this.setVisible(true);
	}
	
	/**
	 * Method of connection of the frame, called by clicking on the button 'connect'
	 */
	private void connect(){
		//Check fields enter by the client
		Boolean ok = true;
		
		//Check if the ip address is valid
		if (!AddressIPGetter.isValidIp(this.ipTxt.getText())){
			@SuppressWarnings("unused")
			ShowDialog s = new ShowDialog("Invalid ip address, please retry.");
			ok = false;
		}
		//Check if the port number is valid
		if (!AddressIPGetter.isValidPort(portTxt.getText())){
			@SuppressWarnings("unused")
			ShowDialog s = new ShowDialog("Invalid port, please retry.");
			ok = false;
		}
		
		if (ok){
			//Connexion
			@SuppressWarnings("unused")
			SupervisedClient sClient = new SupervisedClient(ipTxt.getText(), Integer.valueOf(portTxt.getText()), nameTxt.getText());
			this.dispose();
			@SuppressWarnings("unused")
			ShowDialog s = new ShowDialog("Connected to "+ipTxt.getText()+" : "+portTxt.getText()+" as "+nameTxt.getText());
		}
		
	}
	
}
