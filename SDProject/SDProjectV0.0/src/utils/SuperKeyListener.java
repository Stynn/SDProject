package utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import vw.Displayer;

public class SuperKeyListener implements KeyListener{

	private Displayer parent;
	
	public SuperKeyListener(Displayer parent){
		this.parent = parent;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		this.parent.server.getDataKey().addCode(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
