import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Espion implements MouseListener, KeyListener{

	@SuppressWarnings("unused")
	private SimpleFrame frame;
	private Robot robot;
	
	public Espion(SimpleFrame f) {
		super();
		this.frame = f;
		
		try{
			robot = new Robot();
		}catch(java.awt.AWTException e){
			// Nothing
		}
		
		for (int j = 0; j < f.getComponentCount(); j++){
			f.getComponent(j).addMouseListener(this);
			f.getComponent(j).addKeyListener(this);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// Simulation d’un click de souris.
		robot.mouseMove(30, 50);
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Pressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Released");
	}
	
}
