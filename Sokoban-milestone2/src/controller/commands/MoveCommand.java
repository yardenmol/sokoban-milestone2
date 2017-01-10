package commands;
/**
 * <h1>MoveCommand</h1>
 * activate the MySokobanPlicy receiver
 */
import java.io.IOException;
import moveType.IMoveType;
import moveType.MoveTypeFactory;
import sokobanPolicy.MySokobanPolicy;

public class MoveCommand implements command {
	MySokobanPolicy policy;
	CLI cli;
	IMoveType moveType;
	MoveTypeFactory factory;
	
	
	public MoveCommand() {
		this.cli=null;
		this.policy=null;
		this.moveType=null;
		this.factory=new MoveTypeFactory();
	}
	/**
	 * activate the MySokobanPlicy receiver
	 */
	@Override
	public void exceute() {

		this.policy.checkPolicy(this.cli.getLevel().getListPlayer().get(0), this.moveType);
	}
	
	/**
	 * Initialize the parameters necessary for the receiver
	 * @param args This MoveType command
	 * @param cli The cli that invoke that command
	 * @throws IOException On input error
	 */
	public void init(String args,CLI cli) throws IOException{
	
		this.cli=cli;
		this.policy=new MySokobanPolicy(this.cli.getLevel());
		this.moveType=this.factory.create(args.toUpperCase());
		//moveType didn't created
		if (this.moveType==null)
			throw new IOException("Invalid command");
		
		
	}

}
