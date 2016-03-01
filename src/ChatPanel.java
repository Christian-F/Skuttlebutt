import java.awt.Font;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ChatPanel extends JPanel{
	
	private Socket socket;
	private String Username;
	
	
	public ChatPanel(){
		setLayout(null);
		
		JLabel lblChat = new JLabel("Chat");
		lblChat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChat.setBounds(10, 11, 48, 17);
		add(lblChat);
		
		JTextArea txtAChatLog = new JTextArea();
		txtAChatLog.setBounds(20, 39, 453, 368);
		add(txtAChatLog);
		
		JLabel lblSpeakYourPeace = new JLabel("Speak your piece");
		lblSpeakYourPeace.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSpeakYourPeace.setBounds(12, 418, 144, 17);
		add(lblSpeakYourPeace);
		
		JTextArea txtAInput = new JTextArea();
		txtAInput.setBounds(22, 446, 451, 101);
		add(txtAInput);
		
		JButton btnSend = new JButton("Send");
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSend.setBounds(20, 556, 89, 23);
		add(btnSend);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(416, 558, 57, 23);
		add(btnClear);
	}

	public void startChat() {
		try {
			Scanner chat = new Scanner(System.in);
			Scanner in = new Scanner(socket.getInputStream());
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			while(true){
				String input = chat.nextLine();
				out.println(input);
				out.flush();
				
				if(in.hasNext()){
					System.out.println(in.nextLine());
				}
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} 
	}
	
}
