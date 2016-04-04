package tests;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

import vw.ViewerFrame;

public class TestServicesImpl implements TestServices{

	private ViewerFrame viewer;
	
	public TestServicesImpl(ViewerFrame viewer) {
		this.viewer = viewer;
	}
	
	@Override
	public void test1() {
		System.out.println("coucou");
	}

	@Override
	public void getImage(BufferedImage img) {
		this.viewer.getAlignmentX();
		System.out.println("TEST -> viever ok !");
		
		this.viewer.displayer.updateDisplay(img, this.viewer.displayer.getWidth(), this.viewer.displayer.getHeight());
	}

}
