package laf;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;

import utils.ShowDialogActionListener;

/**
 * This modal dialog allow us to show message to the user
 *
 */
public class ShowDialog extends JDialog{

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -148048264824501518L;

	public ShowDialog(String msg){
		/**** Attributes ****/
		//The main layout manager
		GroupLayout layout;
		
		//Main panel of the frame
		JPanel mainPanel = null;
		
		//The panel of the button
		JPanel subPanel = null;
		
		//Labels of the frame 'IP Adress' 'Port'
		Label lbl;
		
		//Button 'connect'
		Button okButton = new Button("Ok");
		
		/**** Construction ****/
		//Labels
		lbl = new Label(msg);
		lbl.setMinimumSize(new Dimension(200, 33));
		
		//EditTexts
		
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
			   .addComponent(lbl)
			   .addComponent(subPanel))
			   
		);
		layout.setVerticalGroup(
		   layout.createSequentialGroup()
	           .addComponent(lbl)
	           .addComponent(subPanel)
		);
		
		
		//Frame construction
		this.add(mainPanel);
		this.pack();
		this.setTitle("Important");
		this.setResizable(false);
		this.setModal(true);
		
	
		/**** Actions ****/
		okButton.addActionListener(new ShowDialogActionListener(this));
		
		this.setVisible(true);
	}

}
