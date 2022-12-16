import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transition_1 {

	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	
	private JLabel lblNewLabel;
	private JLabel lblWithTheirDoor;
	
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_1_1;
	
	private JLabel lblNewLabel_2;
	
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	
	private boolean contFlag;

	/**
	 * Create the application.
	 */
	public Transition_1(JFrame frame) {
		contFlag = false;
		initialize(frame);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frame) {
		
		panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 606, 431);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(true);
		
		lblNewLabel = new JLabel("Our hero awakens in their cell");
		lblNewLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 22));
		lblNewLabel.setBounds(86, 11, 438, 65);
		panel.add(lblNewLabel);
		lblNewLabel.setVisible(true);
		
		lblWithTheirDoor = new JLabel("with their door open.");
		lblWithTheirDoor.setFont(new Font("OCR A Extended", Font.PLAIN, 22));
		lblWithTheirDoor.setBounds(145, 67, 586, 65);
		panel.add(lblWithTheirDoor);
		lblWithTheirDoor.setVisible(true);
		
		btnNewButton = new JButton("Continue");
		btnNewButton.setVisible(true);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);
				lblNewLabel_1.setVisible(true);
				lblNewLabel_1_1.setVisible(true);
				lblNewLabel_1_1_1.setVisible(true);
				btnNewButton_1.setVisible(true);
				contFlag = true;
			}
		});
		btnNewButton.setBounds(257, 301, 89, 23);
		panel.add(btnNewButton);
		
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(0, 0, 606, 431);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		lblNewLabel_1 = new JLabel("A fire burns in our hero\u2019s eyes");
		lblNewLabel_1.setFont(new Font("OCR A Extended", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(86, 11, 438, 65);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_1_1 = new JLabel("as they realize they have a new chance ");
		lblNewLabel_1_1.setFont(new Font("OCR A Extended", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(37, 67, 586, 65);
		panel_1.add(lblNewLabel_1_1);
		
		lblNewLabel_1_1_1 = new JLabel("to defeat the despot Froseidon, ");
		lblNewLabel_1_1_1.setFont(new Font("OCR A Extended", Font.PLAIN, 22));
		lblNewLabel_1_1_1.setBounds(89, 121, 448, 77);
		panel_1.add(lblNewLabel_1_1_1);
		
		btnNewButton_1 = new JButton("Continue...");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_2.setVisible(true);
				lblNewLabel_2.setVisible(true);
				btnNewButton_2.setVisible(true);
				contFlag = true;
			}
		});
		btnNewButton_1.setBounds(257, 301, 89, 23);
		panel_1.add(btnNewButton_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlight);
		panel_2.setBounds(0, 0, 606, 431);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_2 = new JLabel("But first our hero must escape\u2026");
		lblNewLabel_2.setFont(new Font("OCR A Extended", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(86, 11, 438, 65);
		panel_2.add(lblNewLabel_2);
		
		btnNewButton_2 = new JButton("Escape!");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.setVisible(false);
				contFlag = true;
			}
		});
		btnNewButton_2.setBounds(257, 301, 89, 23);
		panel_2.add(btnNewButton_2);
	}
	
	public boolean getContFlag() {
		return contFlag;
	}
	public void setContFlag(boolean contFlag) {
		this.contFlag = contFlag;
	}
}
