

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

/**
 * This class is a modified button
 */
public class Button extends JButton{
	
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1954755374158353670L;
	
	@SuppressWarnings("unused")
	private String name;
	
	/**
	 * Constructor if the button
	 * @param name Name of the button
	 */
	public Button(String name){
		super(name);
		this.name = name;
		this.setBackground(Color.white);
		this.setFont(new Font("Arial", Font.PLAIN, 16));
	}
	
}
