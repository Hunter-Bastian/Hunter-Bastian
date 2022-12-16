import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class exitButtonActionListener implements ActionListener{
	
	exitButtonActionListener(){
		
	}
	@Override
	   public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
