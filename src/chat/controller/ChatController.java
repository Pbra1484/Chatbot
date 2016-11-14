package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatViewer;
import chat.view.ChatFrame;

public class ChatController
{
	private Chatbot stupidBot;
	private ChatViewer chatView;
	private ChatFrame appFrame;
	
	public ChatController()
	{
		stupidBot = new Chatbot("yep");
		chatView = new ChatViewer();
		this.appFrame = new ChatFrame(this);
	}
	
	
	public void start()
	{
//		String response = "Hello";
//		
//		while(stupidBot.lengthChecker(response))
//		{
//			chatView.displayMessage(useChatbotCheckers(response));
//			response = chatView.collectResponse("What to talk about today?");
//			
//		}
		
	}
	
	private String useChatbotCheckers(String input)
	{
		String answer = "";
		
		if(stupidBot.contentChecker(input))
		{
			answer += "\nSpecal Secret\n";
		}
		if(stupidBot.memeChecker(input))
		{
			answer += "\nMemes\n";
		}
		if(answer.length() == 0)
		{
			answer += "Sorry, I don't understand " + input;
		}
		
		return answer;
	}


}
