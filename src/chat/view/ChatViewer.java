package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class ChatViewer
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatViewer()
	{
		windowMessage = "ChatBot";
		chatIcon = new ImageIcon(getClass().getResource("images/square-icon.png"));
	}

	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message);
	}
	
	public String collectResponse(String question)
	{
		String response = "";
		response = JOptionPane.showInputDialog(null, question, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon, null, "Tyepe Here").toString();
		return response;
	}
	public int collectUserOption(String question)
	{
		int response = 0;
		response = JOptionPane.showConfirmDialog(null, question);
		return response;
	}
}
