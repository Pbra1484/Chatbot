package chat.view;

import chat.controller.ChatController;
import chat.controller.FileController;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JTextArea chatDisplay;
	private JTextField chatField;
	private JButton chatButton;
	private JButton searchTwitter;
	private JButton sendTweet;
	private JButton save;
	private JButton load;
	private JScrollPane chatPane;
	
	/**
	 * Constructs the GUI components and starts the helper methods
	 * @param baseController
	 */
	public ChatPanel(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatField = new JTextField(25);
		chatDisplay = new JTextArea(5, 25);
		chatButton = new JButton("Chat with the bot");
		searchTwitter = new JButton("Search Twitter");
		sendTweet = new JButton("Send Tweet");
		save = new JButton("Save");
		load = new JButton("Load");
		chatPane = new JScrollPane();
		
		
		setupChatDisplay();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	/**
	 * Sets up the display that chatbot will respond in.
	 */
	private void setupChatDisplay()
	{
		chatDisplay.setEditable(false);
		chatDisplay.setEnabled(false);;
		chatDisplay.setLineWrap(true);
		chatDisplay.setWrapStyleWord(true);
		chatPane.setViewportView(chatDisplay);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	}
	
	/**
	 * Sets up the panel and adds the components to the panel
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		this.add(chatPane);
		this.add(chatButton);
		this.add(chatField);
		this.add(searchTwitter);
		this.add(sendTweet);
		this.add(save);
		this.add(load);
		
	}
	/**
	 * Sets up the layout of the panel components with auto generated code
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 238, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 148, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatDisplay, 35, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatDisplay, 75, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, searchTwitter, 0, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.EAST, searchTwitter, -6, SpringLayout.WEST, chatButton);
		baseLayout.putConstraint(SpringLayout.NORTH, sendTweet, 0, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.WEST, sendTweet, 6, SpringLayout.EAST, chatButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, save, -21, SpringLayout.NORTH, searchTwitter);
		baseLayout.putConstraint(SpringLayout.EAST, save, 0, SpringLayout.EAST, searchTwitter);
		baseLayout.putConstraint(SpringLayout.NORTH, load, 0, SpringLayout.NORTH, save);
		baseLayout.putConstraint(SpringLayout.WEST, load, 0, SpringLayout.WEST, sendTweet);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatField, -22, SpringLayout.NORTH, save);
		baseLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, load);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 73, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 20, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, -180, SpringLayout.SOUTH, this);
		
		
		
	}
	
	/**
	 * Adds and sets up the listeners for button components
	 */
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userWords = chatField.getText();
				String botResponse = baseController.useChatbotCheckers(userWords);
				String currentText = chatDisplay.getText();
				
				chatDisplay.setText(currentText + "\n" + "You: " + userWords +"\n" + "Chatbot: " + botResponse);
				chatDisplay.setCaretPosition(chatDisplay.getCaretPosition());
				chatField.setText("");
			}
		});
		
		searchTwitter.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
		sendTweet.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.useTwitter(chatField.getText());
			}
		});
		
		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String fileName = chatField.getText();
				
				FileController.saveFile(baseController,  fileName.trim(), chatDisplay.getText());
			}
		});
		
		load.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String fileName = chatField.getText() + ".txt";
				String saved = FileController.readFile(baseController, fileName);
				chatDisplay.setText(saved);
			}
		});
	}
}
