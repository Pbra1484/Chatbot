package chat.view;

import javax.swing.JFrame;
import java.awt.Dimension;
import chat.controller.ChatController;

public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel appPanel;
	
	
	/**
	 * Initializes the controller and panel then calls the helper method setupFrame
	 * @param baseController
	 */
	public ChatFrame(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		this.appPanel = new ChatPanel(baseController);
		
		this.setupFrame();
	}
	
	/**
	 * Sets up the conditions of the frame
	 */
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("yep");
		this.setSize(new Dimension(450, 300));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
