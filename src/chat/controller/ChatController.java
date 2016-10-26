package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatViewer;


public class ChatController
{
	private Chatbot stupidBot;
	private ChatViewer chatView;
	
	public ChatController()
	{
		stupidBot = new Chatbot("yep");
		chatView = new ChatViewer();
	}
	
	
	public void start()
	{
		String response = "talking";
		
		while(stupidBot.lengthChecker(response))
		{
			response = chatView.collectResponse("What to talk about today?");
			
		}
		
		
	}

}
