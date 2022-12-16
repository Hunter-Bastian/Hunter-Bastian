import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.BevelBorder;

public class Title {
	public boolean newGame;
	public JFrame frame;
	public JPanel panel;
	public JLabel label;

	public Title() {
		newGame = false;
		initialize();
	}
//	EventQueue.invokeLater(new Runnable() {
//		public void run() {
//			try {
//				Title window = new Title();
//				window.frame.setVisible(true);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	});

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 606, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(127, 352, 310, 33);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, null, Color.BLACK, null));
		panel.setBackground(Color.BLUE);
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNewGame(true);
				JOptionPane.showConfirmDialog(btnNewButton, "Are you prepared to begin your afro journey?");
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new exitButtonActionListener());
		panel.add(btnNewButton_1);
		
		label = new JLabel("New label");
		label.setIcon(new ImageIcon(Title.class.getResource("/Res/Title.png")));
		label.setBounds(0, 0, 594, 396);
		frame.getContentPane().add(label);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public boolean getNewGame() {
		return newGame;
	}
	public void setNewGame(boolean newGame) {
		this.newGame = newGame;
	}
}