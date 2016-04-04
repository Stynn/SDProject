package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import laf.ShowDialog;

/**
 * Listener of the ok button of ShowDialogs
 *
 */
public class ShowDialogActionListener implements ActionListener{
	
	private ShowDialog parent;	//The ShowDialog
	
	/**
	 * COnstrcutor of the listener
	 * @param parent The ShowDialog
	 */
	public ShowDialogActionListener(ShowDialog parent){
		super();
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.parent.dispose();
	}

}
