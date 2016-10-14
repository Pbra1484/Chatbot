package chat.view;

import javax.swing.JOptionPane;

public class ChatViewer
{

	public void displayMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message);
	}
	
	public String collectResponse(String question)
	{
		String response = "";
		response = JOptionPane.showInputDialog(null, question);
		return response;
	}
}
