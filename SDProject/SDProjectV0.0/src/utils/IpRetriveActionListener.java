package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import laf.TextField;
import vw.ConfigIpDialog;

/**
 * Modified ActionListener for the ConfigIpDialog button 'ok'
 *
 */
public class IpRetriveActionListener implements ActionListener{
	
	private String url;				//The string of the url
	private ConfigIpDialog parent;	//The configIpDialog
	private TextField urlTxt;		//The textfield of the url enter
	private PrintWriter opf;		//Use to write into the good file
	
	/**
	 * Constructor of the ActionListener
	 * @param parent	 The configIpDialog
	 * @param urlTxt	 The textfield of the url enter
	 * @param outPutFile Use to write into the good file
	 */
	public IpRetriveActionListener(ConfigIpDialog parent, TextField urlTxt, PrintWriter outPutFile){
		super();
		this.setUrl(url);
		this.parent = parent;
		this.urlTxt = urlTxt;
		this.opf = outPutFile;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Retrieve the url and close the frame
		opf.println(this.urlTxt.getText());
		this.parent.dispose();
	}

	/**
	 * Getter of the url
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Setter of the url
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
