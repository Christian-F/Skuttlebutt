import java.io.IOException;
import java.net.Socket;

public class Main {
	
	private static int Port = 0;
	private static String Host;
	
	public static void main(String[]args) throws IOException {
		
		ClientGUI.createAndShowGUI();
		
	}
	
	public void tryToConnect(){
		while(true){
			if(!(Port == 0) && !Host.equals(null)) {
				try {
					Socket s = new Socket(Host, Port);
					System.out.println("You connected to " + Host);
					
					ChatPanel chatPanel = new ChatPanel();
				}catch (Exception noServer){
					System.out.println("The server isn't there, try again later");
				}
			} else {
				System.out.println("Invalid Host or Port entered.");
			}
		}
	}
}
