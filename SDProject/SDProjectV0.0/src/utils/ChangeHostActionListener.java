package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vw.ViewerFrame;

/**
 * Modified actionListener use to know parent
 *
 */
public class ChangeHostActionListener implements ActionListener
{

	public ViewerFrame parent;
	
	/**
	 * Constructor of the action listener
	 * @param parent The parent
	 */
	public ChangeHostActionListener(ViewerFrame parent) {
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Override in the class which use this class
	}

}
