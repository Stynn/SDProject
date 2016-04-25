package laf;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;

/**
 * This class is a modified combobox
 *
 * @param <T> Generic parameter
 */
public class ComboBox<T> extends JComboBox<Object>{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -4748021354113560958L;
	
	/**
	 * Constructor of the combobox
	 */
	public ComboBox(){
		super();
		
		this.setBackground(Color.white);
		this.setFont(new Font("Arial", Font.PLAIN, 16));
		this.setMaximumSize(new Dimension(350, 30));
	}
}
