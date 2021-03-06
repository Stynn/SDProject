package mdl;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Data from the mouse
 */
public class DataFromMouse implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -964341489497748188L;
	
	ArrayList<Integer> pressed;
	ArrayList<Integer> released;
	ArrayList<Integer> wheel;
	
	
	private Boolean enter;
	private Boolean exit;
	
	private int x;
	private int y;
	
	private int width;
	private int height;
	
	public DataFromMouse(){
		
		this.pressed = new ArrayList<Integer>();
		this.released = new ArrayList<Integer>();
		
		this.wheel = new ArrayList<Integer>();
		
		this.enter = false;
		this.exit = true;
		
		this.x = 0;
		this.y = 0;
		
		this.width = 0;
		this.height = 0;
	}
	
	//GETTER and SETTER

	public Boolean getEnter() {
		return enter;
	}

	public void setEnter(Boolean enter) {
		this.enter = enter;
	}

	public Boolean getExit() {
		return exit;
	}

	public void setExit(Boolean exit) {
		this.exit = exit;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void addPressed(int codePressed){
		this.pressed.add(codePressed);
	}
	
	public int getFirstPressed(){
		int res = -1;
		
		if (this.pressed.size() >= 1){
			res = this.pressed.get(0);
			this.pressed.remove(0);
		}
		
		return res;
	}
	
	public void addReleased(int codeReleased){
		this.released.add(codeReleased);
	}
	
	public int getFirstReleased(){
		int res = -1;
		
		if (this.released.size() >= 1){
			res = this.released.get(0);
			this.released.remove(0);
		}
		
		return res;
	}

	public void addWheel(int w){
		this.wheel.add(w);
	}
	
	public int getFirstWheel(){
		int res = 0;
		
		if (this.wheel.size() >= 1){
			res = this.wheel.get(0);
			this.wheel.remove(0);
		}
		
		return res;
	}
	
}
