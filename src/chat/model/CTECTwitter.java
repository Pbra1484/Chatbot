package chat.model;

import chat.controller.ChatController;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;
import twitter4j.Status;
import java.util.List;
import java.util.ArrayList;

public class CTECTwitter 
{
	private ChatController baseController;
	private Twitter twitterBot;
	private ArrayList<Status> allTheTweets;
	private ArrayList<String> tweetedWords;
	
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		twitterBot = TwitterFactory.getSingleton();
		tweetedWords = new ArrayList<String>();
		allTheTweets = new ArrayList<Status>();
	}
	
	public void sendTweet(String textToTweet)
	{
		try
		{
			twitterBot.updateStatus(textToTweet + "@chatbotctec");
		}
		catch(TwitterException tweetError)
		{
			baseController.handleErrors(tweetError);
		}
		catch(Exception otherError)
		{
			baseController.handleErrors(otherError);
		}
	}
	
	private void createIgnoredWordList()
	{
		
	}
	
	private String getMostCommonWord()
	{
		return null;
	}
}
