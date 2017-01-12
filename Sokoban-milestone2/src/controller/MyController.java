package controller;

import java.util.Observable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import controller.commands.CommandsFactory;
import controller.commands.command;
import model.IModel;
import view.IView;

public class MyController implements IController {

	IView ui;
	IModel model;
	BlockingQueue<command> commandsQueue;
	
	public MyController() {
		// TODO Auto-generated constructor stub
	}
	
	public MyController(IView ui,IModel model) {
		this.ui=ui;
		this.model=model;
		this.commandsQueue=new PriorityBlockingQueue<>();
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		CommandsFactory factory=new CommandsFactory();
		factory.create(arg.toString());
		
		
		if(o.equals(this.ui)){
			
		}
	}

}
