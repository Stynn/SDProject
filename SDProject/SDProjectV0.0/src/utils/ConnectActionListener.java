package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * Modified ActionListener for the frame of connection button 'connect'
 */
public class ConnectActionListener implements ActionListener{

	JFrame parent;
	
	public ConnectActionListener(JFrame parent){
		super();
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
