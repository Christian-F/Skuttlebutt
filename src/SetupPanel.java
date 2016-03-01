import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SetupPanel extends JPanel implements ActionListener{
	private JTextField fldHostIp;
	private JTextField fldUserName;
	private JTextField fldHostPort;
	
	private String Username;
	private String HostIP;
	private int HostPort = 0;
	
	public SetupPanel(){
		setLayout(null);
		
		JLabel lblHostIp = new JLabel("Host IP");
		lblHostIp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHostIp.setBounds(114, 158, 69, 20);
		add(lblHostIp);
		
		fldHostIp = new JTextField();
		fldHostIp.setBounds(114, 177, 115, 20);
		add(fldHostIp);
		fldHostIp.setColumns(15);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(174, 229, 84, 14);
		add(lblUsername);
		
		fldUserName = new JTextField();
		fldUserName.setBounds(174, 246, 115, 20);
		add(fldUserName);
		fldUserName.setColumns(4);
		
		JLabel lblConnectToServer = new JLabel("Connect to Server");
		lblConnectToServer.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblConnectToServer.setBounds(114, 11, 219, 28);
		add(lblConnectToServer);
		
		fldHostPort = new JTextField();
		fldHostPort.setBounds(271, 177, 54, 20);
		add(fldHostPort);
		fldHostPort.setColumns(4);
		
		JLabel lblNewLabel = new JLabel("Port");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(271, 158, 46, 20);
		add(lblNewLabel);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConnect.setBounds(188, 300, 89, 23);
		btnConnect.addActionListener(this);
		add(btnConnect);
	}
	
	public String getHostIP(){
		return HostIP;
	}
	public int getHostPort(){
		return HostPort;
	}
	public String getUsername(){
		return Username;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		tryToConnect();
	}
	
	public void tryToConnect(){
		boolean connected = false;
		try{
			HostIP = fldHostIp.getText();
			HostPort = Integer.parseInt(fldHostPort.getText());
			Username = fldUserName.getText();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		while(!connected){
			if(!(HostPort == 0) && !HostIP.equals(null)) {
				try {
					Socket s = new Socket(HostIP, HostPort);
					System.out.println("You connected to " + HostIP);
					
					connected = true;
					ChatPanel chat = new ChatPanel();
					//this.setVisible(false);
					ClientGUI.changePanel(chat, this);
					
					//Thread t = new Thread(client);
					//t.start();
					
				}catch (Exception noServer){
					System.out.println("The server isn't there, try again later");
				}
			}
		}
	}
}
