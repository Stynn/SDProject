package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vw.ViewerFrame;

/**
 * 
 * Modified action listener to know the parent
 *
 */
public class DiscoHostActionListener implements ActionListener{

	public ViewerFrame parent;	//The parent
	
	/**
	 * Constructor of the action listener
	 * @param parent The parent
	 */
	public DiscoHostActionListener(ViewerFrame parent) {
		super();
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Override in the class which use this class
	}
}
