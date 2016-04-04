package laf;

import java.awt.Font;

import javax.swing.JLabel;

/**
 * This class is a modified label
 */
public class Label extends JLabel{

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -8686158911622810062L;
	
	String str;	//String of the label

	/**
	 * Constructor of the label
	 * @param str String of the label
	 */
	
	public Label(String str){
		super(str);
		
		this.str = str;
		this.setFont(new Font("Arial", Font.PLAIN, 16));
	}
	
}
