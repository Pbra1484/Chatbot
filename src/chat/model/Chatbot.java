package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2016 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part * of the project. 
 * * @author Patrick Brashear
 *  * @version 1.0 10/14/16
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;

	/**
	 * * Creates an instance of the Chatbot with the supplied username. * @param
	 * userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.userName = userName;
		this.content = new String("Science");
		buildMemesList();
		buildPoliticalTopicsList();
		
	}

	/**
	 * * Builds the list of memes
	 */
	private void buildMemesList()
	{
		memesList.add("doge");
		memesList.add("cute animals");
		memesList.add("grumpy cat");
		memesList.add("dat boi");
		memesList.add("willy wonka");
		memesList.add("harambe");
		memesList.add("john cena");
		memesList.add("pawn stars");
		memesList.add("ken bone");
		memesList.add("michal phelps");
		memesList.add("sponge bob");
		memesList.add("pope");
		memesList.add("nep");
		memesList.add("nobodys perfect");
		memesList.add("meme");
		memesList.add("botom text");
		memesList.add("BYOB");
		memesList.add("should just drop dead");
		
		
		
	}

	/**
	 * * Builds the list of political topics
	 */
	private void buildPoliticalTopicsList()
	{
		politicalTopicList.add("Democrat");
		politicalTopicList.add("Republican");
		politicalTopicList.add("11/8/16");
		politicalTopicList.add("liberal");
		politicalTopicList.add("conservative");
		politicalTopicList.add("Clinton");
		politicalTopicList.add("Trump");
		politicalTopicList.add("Kaine");
		politicalTopicList.add("Pence");
		politicalTopicList.add("Stein");
		politicalTopicList.add("Johnson");
		politicalTopicList.add("election");
		politicalTopicList.add("Make America Great Again");
		politicalTopicList.add("Stronger Together");
		politicalTopicList.add("Democracy");
		politicalTopicList.add("polls");
		politicalTopicList.add("Washington");
		politicalTopicList.add("Hillary");
				
	}

	/**
	 * * Checks the length of the supplied string. Returns false if the supplied
	 * String is empty or null, otherwise returns true. * @param currentInput * @return
	 * A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		
		if(currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}
		
		return hasLength;
	}

	/**
	 * * Checks if the supplied String matches the content area for this Chatbot
	 * instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether it
	 *            matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		
		return hasContent;
	}

	/**
	 * * Checks if supplied String matches ANY of the topics in the
	 * politicalTopicsList. Returns true if it does find a match and false if it
	 * does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasPolitics = false;
		
		for(int index = 0; index < politicalTopicList.size(); index++)
		{
			if(currentInput.equals(politicalTopicList.get(index)))
			{
				hasPolitics = true;
			}
		}
		
		return hasPolitics;
	}

	/**
	 * * Checks to see that the supplied String value is in the current
	 * memesList variable.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;
		
		for(int index = 0; index < memesList.size(); index++)
		{
			
			if(currentInput.equalsIgnoreCase(memesList.get(index)))
			{
				hasMeme = true;
			}
		}
		
		return hasMeme;
	}

	/**
	 * * Returns the username of this Chatbot instance. * @return The username
	 * of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * * Returns the content area for this Chatbot instance. * @return The
	 * content area for this Chatbot instance.
	 */
	public String getContent()
	{
		
		return content;
	}

	/**
	 * * Getter method for the memesList object. * @return The reference to the
	 * meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}

	/**
	 * * Getter method for the politicalTopicList object. * @return The
	 * reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}

	/**
	 * * Updates the content area for this Chatbot instance. * @param content
	 * The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
	
	/**
	 * * Checks if keyboard mashing is inputed.
	 * @param currentInput
	 * @return boolean keyboardMash
	 */
	public boolean keyboardMashChecker(String currentInput)
	{
		boolean keyboardMash = false;
		
		if(currentInput.equals("sdf")){keyboardMash = true;}
		if(currentInput.equals("dfg")){keyboardMash = true;}
		if(currentInput.equals("cvb")){keyboardMash = true;}
		if(currentInput.equals(",./")){keyboardMash = true;}
		
		return keyboardMash;
	}
	
	/**
	 * * Checks if quit was inputed.
	 * @param currentInput
	 * @return boolean didQuit
	 */
	public boolean quitChecker(String currentInput)
	{
		boolean didQuit = false;
		
		if(currentInput.equals("quit")){didQuit = true;}
		
		return didQuit;
	}

	/**
	 * * Checks if the input was HTML code
	 * @param currentInput
	 * @return boolean hasHTML
	 */
	public boolean inputHTMLChecker(String currentInput)
	{
		boolean hasHTML = false;
		
		if(currentInput.contains("<P>"))
		{
			hasHTML = true;
		}	
		else if(currentInput.contains("<A HREF=\""))
		{
			int index = currentInput.indexOf("<A HREF=\"") + 9;
			String sub = currentInput.substring(index);
			
			if(sub.contains("\">"))
			{
				int index2 = sub.indexOf("\">");
				String sub2 = sub.substring(index2);
				
				if(sub2.contains(" </a>"))
				{
					hasHTML = true;
				}
			}
		}
		else if(currentInput.contains("<"))
		{
			String lower = currentInput.toLowerCase();
			int openIndex1 = lower.indexOf("<") + 1;
			String tag = "";
			if(lower.contains(">"))
			{
				int openIndex2 = lower.indexOf(">");
				tag = lower.substring(openIndex1, openIndex2);
				
				String sub = lower.substring(openIndex2 + 1);
				
				if(sub.contains("</" + tag + ">"))
				{
					hasHTML = true;
				}	
			}			
		}


		
		
//		else if(currentInput.contains("<I>"))
//		{
//			int index = currentInput.indexOf("<I>") + 3;
//			String sub = currentInput.substring(index);
//			
//			if(sub.contains("</i>"))
//			{
//				hasHTML = true;
//			}
//		}
		
		
		
		
//		if(currentInput.equals("<B>  </B>")){hasHTML = true;}
//		if(currentInput.equals("<I> sdadas </i>")){hasHTML = true;}
//		if(currentInput.equals("<P>")){hasHTML = true;}
//		if(currentInput.equals("<A HREF=\"sdfs.html\">")){hasHTML = false;}
		return hasHTML;
	}
	
	/**
	 * * Checks if the input has a twitter tag or user id
	 * @param currentInput
	 * @return boolean hasTwitter
	 */
	public boolean twitterChecker(String currentInput)
	{
		boolean hasTwitter = false;
		if(currentInput.contains("#"))
		{
			int index = currentInput.indexOf("#") + 1;
			String sub = currentInput.substring(index, index + 1);
			
			if(!sub.equals(" ") && !sub.equals(""))
			{
				hasTwitter = true;
			}
		}
		if(currentInput.contains("@"))
		{
			int index = currentInput.indexOf("#") + 1;
			String sub = currentInput.substring(index, index + 1);
			
			if(!sub.equals(" ") && !sub.equals(""))
			{
				hasTwitter = true;
			}
		}
		return hasTwitter;
	}
	
}