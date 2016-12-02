package chat.view;

import chat.controller.ChatController;
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
	private JButton tempButton;
	
	/**
	 * Constructs the GUI components and starts the helper methods
	 * @param baseController
	 */
	public ChatPanel(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatDisplay = new JTextArea(5, 25);
		chatField = new JTextField(25);
		chatButton = new JButton("Chat with the bot");
		tempButton = new JButton("temp");
		
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
	}
	
	/**
	 * Sets up the panel and adds the components to the panel
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		this.add(chatDisplay);
		this.add(chatButton);
		this.add(chatField);
		this.add(tempButton);
	}
	/**
	 * Sets up the layout of the panel components with auto generated code
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, chatDisplay, 75, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatDisplay, -34, SpringLayout.NORTH, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 68, SpringLayout.WEST, this);	
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 238, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatField, -29, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 148, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.WEST, tempButton, 187, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, tempButton, -6, SpringLayout.NORTH, chatDisplay);
		
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
				
				chatDisplay.setText("You: " + userWords +"\n" + "Chatbot: " + botResponse);
				chatField.setText("");
			}
		});
	}
}
