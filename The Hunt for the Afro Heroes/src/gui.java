import java.awt.EventQueue;

import javax.swing.*;



public class GUI {
	
	private Title title;
	private JFrame Frame;
	
	
	public GUI() {
		title = new Title();
		Frame = title.getFrame();

	}

	public void exitButtonPress() {
	System.exit(0);
}
	
	public void newGameButtonPress() {
		
	}
}

