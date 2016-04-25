package utils;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import vw.Displayer;

public class SuperWheelListener implements MouseWheelListener{

	private Displayer parent;
	
	public SuperWheelListener(Displayer parent){
		this.parent = parent;
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		this.parent.server.getDataMouse().addWheel(e.getWheelRotation());
	}

}
