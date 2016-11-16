package chat.view;

import javax.swing.JFrame;
import java.awt.Dimension;
import chat.controller.ChatController;

public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel appPanel;
	
	public ChatFrame(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		this.appPanel = new ChatPanel(baseController);
		
		this.setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setTitle("yep");
		this.setSize(new Dimension(600, 400));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
