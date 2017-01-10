package commands;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import level.LevelSaver;
import level.LevelSaverFactory;

/**
 * <h1>Save Level Command<h1>
 * activate the suitable method in the LevelSaver
 */
public class SaveLevelCommand implements command {

	LevelSaver levelSaver;
	OutputStream output;
	CLI cli;
	LevelSaverFactory factory;
	
	public SaveLevelCommand() {
		this.levelSaver=null;
		this.output=null;
		this.cli=null;
		this.factory=new LevelSaverFactory();
	}
	/**
	 * activate the suitable method in the LevelSaver
	 */
	@Override
	public void exceute() {
		
		try {
			this.levelSaver.saveLevel(this.cli.getLevel(), this.output);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Initialize the parameters necessary for the receiver
	 * @param args The file path
	 * @param cli The cli that invoke that command
	 * @throws IOException On input error
	 */
	//Initialize the parameters necessary for the receiver
	public void init(String args,CLI cli) throws IOException{
		 
		this.levelSaver=factory.create(args.substring(args.length()-3).toLowerCase());
		this.cli=cli;
		//saveLevel didn't created
		if (this.levelSaver==null)
			throw new IOException("Invalid command");
		
		this.output=new FileOutputStream(new File(args));
	}
		
}
