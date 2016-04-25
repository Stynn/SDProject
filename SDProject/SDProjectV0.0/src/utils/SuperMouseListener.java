package utils;

import java.awt.event.MouseEvent;

import vw.Displayer;

public class SuperMouseListener implements java.awt.event.MouseListener{

	private Displayer parent;
		
	public SuperMouseListener(Displayer parent) {
		this.parent = parent;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.parent.server.getDataMouse().setEnter(true);
		this.parent.server.getDataMouse().setExit(false);
		this.setWidthHeight();
		this.parent.setFocusable(true);
		this.parent.requestFocus();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.parent.server.getDataMouse().setEnter(false);
		this.parent.server.getDataMouse().setExit(true);
		this.setWidthHeight();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println("Press");
		this.parent.server.getDataMouse().addPressed(e.getButton());
		this.setWidthHeight();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//System.out.println("Release");
		this.parent.server.getDataMouse().addReleased(e.getButton());
		
		
		this.setWidthHeight();
	}
	
	private void setWidthHeight(){
		this.parent.server.getDataMouse().setWidth(parent.getWidth());
		this.parent.server.getDataMouse().setHeight(parent.getHeight());
	}
}
