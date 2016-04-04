package laf;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;

/**
 * This class is a modified textField
 */
public class TextField extends JTextField{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 1787140727282393918L;

	/**
	 * COnstructor of the textField
	 */
	public TextField(){
		super();
		
		this.setFont(new Font("Arial", Font.PLAIN, 16));
		this.setMaximumSize(new Dimension(500, 33));
	}
	
}
