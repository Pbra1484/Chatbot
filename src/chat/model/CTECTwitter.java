package chat.model;

import chat.controller.ChatController;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterException;
import twitter4j.Status;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import twitter4j.GeoLocation;
import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;

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
	
	private String [] createIgnoredWordsArray()
	{
		String [] boringWords;
		int wordCount = 0;
		
		Scanner boringWordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		while(boringWordScanner.hasNextLine())
		{
			boringWordScanner.nextLine();
			wordCount++;
		}
		
		boringWordScanner.close();
		
		boringWords = new String [wordCount];
		
		boringWordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		
		for(int index = 0; index < boringWords.length; index++)
		{
			boringWords[index] = boringWordScanner.next();
		}
		boringWordScanner.close();
		
		return boringWords;
	}
	
	public String getMostCommonWord(String username)
	{
		gatherTheTweets(username);
		turnTweetsToWords();
		removeBoringWords();
		removeBlankWords();
		
		String information = "The tweetcount is " + allTheTweets.size() + " and the word count after removal is " + tweetedWords.size() + calculateTopWord();
		
		return information;
	}
	
	private void turnTweetsToWords()
	{
		for(Status currentTweet : allTheTweets)
		{
			String tweetText = currentTweet.getText();
			String [] tweetWords = tweetText.split(" ");
			for(String word : tweetWords)
			{
				tweetedWords.add(word);
			}
		}
	}
	
	private void gatherTheTweets(String user)
	{
		tweetedWords.clear();
		allTheTweets.clear();
		int pageCount = 1;
		Paging statusPage = new Paging(1, 200);
		
		while(pageCount <= 10)
		{
			try 
			{
				allTheTweets.addAll(twitterBot.getUserTimeline(user, statusPage));
			} 
			catch (TwitterException twitterError) 
			{
				baseController.handleErrors(twitterError);
			}
			pageCount++;
		}
	}
	
	public void removeBoringWords()
	{
		String [] boringWords = createIgnoredWordsArray();
		
		 for(int index = 0; index < tweetedWords.size(); index++)
		 {
			 for(int boringIndex = 0; boringIndex < boringWords.length; boringIndex++)
			 {
				 if(tweetedWords.get(index).equalsIgnoreCase(boringWords[boringIndex]))
				 {
					 tweetedWords.remove(index);
					 index--;
					 boringIndex = boringWords.length;
				 }
			 }
		 }
	}
	
	private void removeBlankWords()
	{
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			if(tweetedWords.get(index).trim().equals(""))
			{
				tweetedWords.remove(index);
				index--;
			}
		}
	}

	private String calculateTopWord()
	{
		String results = "";
		String topWord = "";
		int mostPopularIndex = 0;
		int popularCount = 0;
		
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			int currentPopularity = 0;
			for(int searched = index + 1; searched < tweetedWords.size(); searched++)
			{
				if(tweetedWords.get(index).equalsIgnoreCase(tweetedWords.get(searched)))
				{
					currentPopularity++;
				}
			}
			if(currentPopularity > popularCount)
			{
				popularCount = currentPopularity;
				mostPopularIndex = index;
				topWord = tweetedWords.get(mostPopularIndex);
			}
			currentPopularity = 0;
		}
		results += " the most pulular word was " + topWord + ", and it occured " + popularCount +" times." + "\n";
		results += "Thats a percetage of " + ((double)popularCount)/tweetedWords.size() * 100 + "%";
		
		return results;
	}
	
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,':;\"(){}[]<>-";
		
		String scrubbedString = "";
		for(int i = 0; i < currentString.length(); i++)
		{
			if(punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;

	}

	public String interigateTwitter()
	{
		String info = "";
		Query query = new Query("CCHS");
		query.setCount(100);
		query.setGeoCode(new GeoLocation(40.5196, -111.8702), 5000, Query.KILOMETERS);
		query.setSince("2017-03-10");
		try
		{
			QueryResult result = twitterBot.search(query);
			info += "Count: " + result.getTweets().size()  + "\n";
			for(Status tweet : result.getTweets())
			{
				info += "@" + tweet.getUser().getName() + ": " + tweet.getText() + "\n";
			}
		}
		catch(TwitterException error)
		{
			baseController.handleErrors(error);
		}
		return info;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
