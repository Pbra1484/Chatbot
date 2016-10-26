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
		String response = chatView.collectResponse("What do you want to talk about today?");
				
		
		while(stupidBot.lengthChecker(response))
		{
			chatView.displayMessage(useChatbotCheckers(response));
			response = chatView.collectResponse("You are interested in " + response);
			
		}		
	}
	
	private String useChatbotCheckers(String input)
	{
		String answer = "";
		
		if(stupidBot.contentChecker(input))
		{
			answer += "\nYou know my specail secret\n";
		}
		if(stupidBot.memeChecker(input))
		{
			answer += "\nMemes\n";
		}
		
		if(answer.length() == 0)
		{
			answer += "Sorry. I don't know about " + input;
		}
		
		
		return answer;
	}
}
