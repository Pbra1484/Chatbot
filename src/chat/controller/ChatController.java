package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatView;


public class ChatController
{
	private Chatbot stupidBot;
	private ChatView chatView;
	
	public ChatController()
	{
		stupidBot = new Chatbot("yep");
		chatView = new ChatView();
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
