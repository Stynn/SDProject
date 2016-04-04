package utils;

import java.awt.event.ComponentAdapter;

import vw.ViewerFrame;

/**
 * Modified ComponentAdapter use to know the parent
 */
public class CFrameAdapter extends ComponentAdapter{

	public ViewerFrame parent;	//Parent of the component which use this adapter
	
	/**
	 * Constructor of the adapter
	 * @param p Parent
	 */
	public CFrameAdapter(ViewerFrame p){
		super();
		this.parent = p;
	}
	
}
