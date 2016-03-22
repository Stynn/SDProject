import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleFrame extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SimpleFrame(){
		Label l = new Label("Press key for click simulation");
		Button b1 = new Button ("Exit");
		Button b2 = new Button ("Other");
		
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		this.setLayout(new GridLayout(0, 1));
		this.add(l);
		this.add(b1);
		this.add(b2);
	}
	
}
