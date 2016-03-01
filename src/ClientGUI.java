import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClientGUI {
	
	// Panels
	static JPanel setupPanel = new SetupPanel();
	//static JPanel chat = new ChatPanel();
	
	static JFrame frame = new JFrame("Skuttlebutt Client");
	
	
	public static void createAndShowGUI(){

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 600);
		frame.setVisible(true);
		frame.add(setupPanel);
	}
	
	public static void removePanel(JPanel toRemove){
		frame.remove(toRemove);
		frame.validate();
		frame.repaint();
	}
	
	public static void changePanel(JPanel toAdd, JPanel toClose){
		frame.remove(toClose);
		frame.add(toAdd);
		frame.repaint();
		frame.revalidate();
	}
	
	public static void startChat(){
		frame.remove(setupPanel);
		//frame.add();
	}
	
}
