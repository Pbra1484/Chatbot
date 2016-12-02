package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class ChatViewer
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	/**
	 * Creates the popup window mesage and icon
	 */
	public ChatViewer()
	{
		windowMessage = "yep";
		chatIcon = new ImageIcon(getClass().getResource("images/square-icon.png"));
	}

	/**
	 * Displays a message as a popup
	 * @param message
	 */
	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon);
	}
	
	/**
	 * Asks a question and get a string response as a popup
	 * @param question
	 * @return String response
	 */
	public String collectResponse(String question)
	{
		String response = "";
		response = JOptionPane.showInputDialog(null, question, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon, null, "Tyepe Here").toString();
		return response;
	}
	
	
	/**
	 * Asks a question and  gets a number response
	 * @param question
	 * @return int response
	 */
	public int collectUserOption(String question)
		{
			int response = 0;
			response = JOptionPane.showConfirmDialog(null, question);
			return response;
		}
}
