package utils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import vw.Displayer;

public class SuperMotionListener implements MouseMotionListener{

	private Displayer parent;
	
	public SuperMotionListener(Displayer parent){
		this.parent = parent;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		this.parent.server.getDataMouse().setX(e.getX());
		this.parent.server.getDataMouse().setY(e.getY());
		this.setWidthHeight();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.parent.server.getDataMouse().setX(e.getX());
		this.parent.server.getDataMouse().setY(e.getY());
		this.setWidthHeight();
	}

	private void setWidthHeight(){
		this.parent.server.getDataMouse().setWidth(parent.getWidth());
		this.parent.server.getDataMouse().setHeight(parent.getHeight());
	}
	
}
