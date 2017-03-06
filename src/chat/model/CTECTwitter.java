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
	private List<Status> searchedTweets;
	private List<String> ignoredWords;
	
	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		twitterBot = TwitterFactory.getSingleton();
		ignoredWords = new ArrayList<String>();
		searchedTweets = new ArrayList<Status>();
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
