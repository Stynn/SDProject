package vw;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.io.PrintWriter;

import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;

import laf.Button;
import laf.Label;
import laf.TextField;
import utils.IpRetriveActionListener;


/**
 * Frame of configuration of the ip address
 *
 */
public class ConfigIpDialog extends JDialog{
	
	/**
	 * Serial version uid
	 */
	private static final long serialVersionUID = -3749868044133294393L;

	public ConfigIpDialog(String motif, PrintWriter outPutFile){
		
		/**** Attributes ****/
		//The main layout manager
		GroupLayout layout;
		
		//Main panel of the frame
		JPanel mainPanel = null;
		
		//The panel of the button
		JPanel subPanel = null;
		
		//Labels of the frame 'IP Adress' 'Port'
		Label urlLbl;
		
		//TextEdits of the frame
		TextField urlTxt = null;
		
		//Button 'connect'
		Button okButton = new Button("Ok");
		
		/**** Construction ****/
		//Labels
		urlLbl = new Label(motif);
		urlLbl.setMinimumSize(new Dimension(200, 33));
		
		//EditTexts
		urlTxt = new TextField();
		urlTxt.setMaximumSize(new Dimension(1200,33));
		
		//Button
		okButton.setMinimumSize(new Dimension(100,33));
		

		
		//Panel and layout construction
		mainPanel = new JPanel();
		subPanel = new JPanel(new GridBagLayout());
		subPanel.add(okButton);
		
		layout = new GroupLayout(mainPanel);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		mainPanel.setLayout(layout);
		
		layout.setHorizontalGroup(
		   layout.createSequentialGroup()
		   .addGroup(layout.createParallelGroup()
			   .addComponent(urlLbl)
			   .addComponent(urlTxt)
			   .addComponent(subPanel))
			   
		);
		layout.setVerticalGroup(
		   layout.createSequentialGroup()
	           .addComponent(urlLbl)
	           .addComponent(urlTxt)
	           .addComponent(subPanel)
		);
		
		
		//Frame construction
		this.add(mainPanel);
		this.pack();
		this.setTitle("Viewer : configure ip address");
		this.setResizable(false);
		this.setModal(true);
		
		/**** Actions ****/
		okButton.addActionListener(new IpRetriveActionListener(this, urlTxt, outPutFile));
		this.setVisible(true);
	}
}
