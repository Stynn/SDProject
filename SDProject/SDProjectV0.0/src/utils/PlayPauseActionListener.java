package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vw.ViewerFrame;

/**
 * Modified ActionListener for the button play pause
 *
 */
public class PlayPauseActionListener implements ActionListener{

	public ViewerFrame parent;	//The parent of the button
	
	public PlayPauseActionListener(ViewerFrame parent){
		this.parent = parent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
