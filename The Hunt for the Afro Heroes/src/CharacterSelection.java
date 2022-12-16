import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class CharacterSelection {

	//public JFrame frame;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_4;
	
	private int charSelectionBuffer;
	private String name;
	private boolean contFlag;
	private JTextField textField;
	
	

	/**
	 * Create the application.
	 */
	public CharacterSelection(JFrame frame) {
		contFlag = false;
		initialize(frame);
		
	}
	public int getCharSelectionBuffer() {
		return charSelectionBuffer;
	}
	public void setCharSelectionBuffer(int buffer) {
		this.charSelectionBuffer = buffer;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frame) {
		//frame = new JFrame();
		frame.setBounds(100, 100, 600, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//character selection panel
		panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 588, 363);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Paladin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(btnNewButton, "Do you wish to become a Paladin?");
				setCharSelectionBuffer(0);
				panel.setVisible(false);
				namePrompt();
			}
		});
		btnNewButton.setBounds(30, 100, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Mage");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(btnNewButton_1, "Do you wish to become a Mage?");
				setCharSelectionBuffer(1);
				panel.setVisible(false);
				namePrompt();
			}
		});
		btnNewButton_1.setBounds(253, 100, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Rogue");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(btnNewButton_2, "Do you wish to become a Rogue?");
				setCharSelectionBuffer(2);
				panel.setVisible(false);
				namePrompt();
			}
		});
		btnNewButton_2.setBounds(460, 100, 89, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setIcon(new ImageIcon(CharacterSelection.class.getResource("/Res/PaladinSmall.png")));
		lblNewLabel.setBounds(30, 134, 89, 104);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(CharacterSelection.class.getResource("/Res/MageSmall.png")));
		lblNewLabel_1.setBounds(242, 134, 100, 97);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(CharacterSelection.class.getResource("/Res/RogueSmall.png")));
		lblNewLabel_2.setBounds(460, 127, 89, 104);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Choose Your Champion of Hair!");
		lblNewLabel_3.setFont(new Font("OCR A Extended", Font.PLAIN, 32));
		lblNewLabel_3.setBounds(10, 11, 568, 47);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon(CharacterSelection.class.getResource("/Res/PaladinSmall.png")));
		lblNewLabel_1_1.setBounds(29, 134, 100, 97);
		panel.add(lblNewLabel_1_1);
		
		//name prompt panel
		panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(0, 0, 588, 363);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);
		
		lblNewLabel_4 = new JLabel("Name Your Champion!");
		lblNewLabel_4.setFont(new Font("OCR A Extended", Font.PLAIN, 32));
		lblNewLabel_4.setBounds(122, 40, 384, 42);
		panel_1.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = textField.getText();
				if(name.length() == 0) {
					name = " ";
					contFlag = true;
				}
				contFlag = true;
				panel_1.setVisible(false);
			}
		});
		textField.setBounds(75, 77, 435, 50);
		panel_1.add(textField);
		textField.setColumns(10);
		
	}
	
	public void namePrompt() {
		panel_1.setVisible(true);
		btnNewButton_3.setVisible(true);
		textField.setVisible(true);
		lblNewLabel_4.setVisible(true);
	}
	
	public String getName() {
		return name;
	}
	
	public boolean getContFlag() {
		return contFlag;
	}
}
