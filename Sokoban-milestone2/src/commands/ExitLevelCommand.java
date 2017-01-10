package commands;

import java.io.IOException;
/**
 *<h1>Exit Level Command</h1> 
 *close all the files, release resources
 */
public class ExitLevelCommand implements command {

	CLI cli;
	
	public ExitLevelCommand() {
		this.cli=null;
	}
	
	
	/**
	 * close all the files, release resources
	 */
	@Override
	public void exceute() {
		
		this.cli.setFlag(false);
		
		System.out.close();
		try {
			System.in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Initialize the parameters necessary for the receiver
	 * @param cli
	 */
	public void init (CLI cli) {
		
		this.cli= cli;
	}
	


	
}
