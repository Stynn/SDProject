package Espion;


public class RobotTest {

	public static void main(String[] args) {
		SimpleFrame f = new SimpleFrame();
		@SuppressWarnings("unused")
		Espion e = new Espion(f);
		
		f.pack();
		f.setSize(220+10, 80+29);
		f.setVisible(true);
	}

}
