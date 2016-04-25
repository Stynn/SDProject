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
	 * Constrcutor of the listener
	 * @param parent The ShowDialog
	 */
	public ShowDialogActionListener(ShowDialog parent){
		super();
		this.parent = parent;
	}

	/**
	 * I do not remember what is this function
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.parent.dispose();
	}

}
