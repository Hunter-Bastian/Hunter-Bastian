import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Loading {

	public JPanel panel;
	public JPanel panel2;
	private boolean contFlag;

	/**
	 * Create the application.
	 */
	public Loading(JFrame frame) {
		contFlag = false;
		initialize(frame);
		panel.setVisible(true);
		secondPanel(frame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frame) {
		
		panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		panel.setBounds(0, 0, 594, 396);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(true);;
		
		JLabel lblNewLabel = new JLabel("LOADING\r\n");
		lblNewLabel.setForeground(SystemColor.menu);
		lblNewLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 36));
		lblNewLabel.setBounds(242, 129, 298, 84);
		panel.add(lblNewLabel);
		lblNewLabel.setVisible(true);
		
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBackground(SystemColor.desktop);
		lblNewLabel_1.setBounds(206, 242, 250, 143);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setVisible(true);
	}
	
	public void secondPanel(JFrame frame) {
		panel2 = new JPanel();
		panel2.setBackground(SystemColor.desktop);
		panel2.setBounds(0, 0, 594, 396);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);
		panel2.setVisible(true);;
		
		JButton btnNewButton = new JButton("Continue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contFlag = true;
				panel.setVisible(false);
				panel2.setVisible(false);
				
			}
		});
		btnNewButton.setBounds(278, 190, 89, 23);
		panel2.add(btnNewButton);
		btnNewButton.setVisible(true);
	
		JLabel lblNewLabel = new JLabel("LOADING\r\n");
		lblNewLabel.setForeground(SystemColor.menu);
		lblNewLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 36));
		lblNewLabel.setBounds(242, 129, 298, 84);
		panel2.add(lblNewLabel);
		lblNewLabel.setVisible(true);
		
		panel.setVisible(false);
	}
	
	public boolean getContFlag() {
		return contFlag;
	}
}
