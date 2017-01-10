package commands;

import java.io.IOException;

/**
 * <h1>Display Level Command</h1>
 * activate the Displayer receiver
 */

import displayer.Display2D;
import displayer.display;
import level.Level;

public class DisplayLevelCommand implements command {

	display displayer;
	Level level;
	
	public DisplayLevelCommand() {
		this.displayer=null;
		this.level=null;
	}
	
	/**
	 * activate the suitable method in the Displayer
	 */
	@Override
	public void exceute() {
		try {
			this.displayer.displayLevel(level, System.out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Initialize the parameters necessary for the receiver
	 * @param level display this level
	 */
	public void init (Level level){
		this.displayer= new Display2D();
		this.level= level;
		
		
	}

}
