package commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import level.LevelLoader;
import level.LevelLoaderFactory;
/**
 * <h1>LoadLevelCommand</h1>
 *activate the LoadLevel receiver
 */
public class LoadLevelCommand implements command {

	LevelLoader levelLoader;
	InputStream input;
	CLI cli;
	LevelLoaderFactory factory;

	public LoadLevelCommand() {
		this.levelLoader=null;
		this.input=null;
		this.cli=null;
		this.factory= new LevelLoaderFactory();
	}
	
	/**
	 * activate the suitable method in the LevelLoader
	 */
	
	@Override
	public void exceute(){

		try {
			this.cli.setLevel(this.levelLoader.loadLevel(this.input));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public void init(String args,CLI cli) throws IOException{
		 
		this.cli=cli;
		this.levelLoader= this.factory.create(args.substring(args.length()-3).toLowerCase());
		
		//levelLoader didn't created
		if (this.levelLoader==null)
			throw new IOException("Invalid Input, Try Again");
		
		
		this.input=new FileInputStream(new File(args));
	}
		
}
