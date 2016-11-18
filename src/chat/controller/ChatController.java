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
	
	public String useChatbotCheckers(String input)
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
		if(!stupidBot.lengthChecker(answer))
		{
			answer += "Sorry, I don't understand " + input;
		}
		
		int canBeRandom = (int) (Math.random() * 7);
		if(canBeRandom % 2 == 0)
		{
			answer += randomTopicGeneration();
		}
		
		return answer;
	}
	
	private String randomTopicGeneration()
	{
		String randomTopic = "";
		int random = (int) (Math.random() * 7);
		
		switch(random)
		{
			case 0:
				randomTopic = "Random topic 1";
				break;
			case 1:
				randomTopic = "Random topic 2";
				break;
			case 2:
				randomTopic = "Random topic 3";
				break;
			case 3:
				randomTopic = "Random topic 4";
				break;
			case 4:
				randomTopic = "Random topic 5";
				break;
			case 5:
				randomTopic = "Random topic 6";
				break;
			case 6:
				randomTopic = "Random topic 7";
				break;
				
			default:
				randomTopic = "Error";
		}
		
		
		
		
		return randomTopic;
	}
	
	

}
