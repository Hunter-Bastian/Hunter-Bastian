import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.*;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class combat {

	private CombatController encounter;
	private int selectedEnemy;
	private int actionType;

	public JPanel panel;
	public JPanel targetPanel;
	
	JLabel TextBox;
	boolean contFlag;

	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;

	private String hero1;
	private String hero2;
	private String hero3;
	private String hero4;
	private String hero5;

	private String enemy1;
	private String enemy2;
	private String enemy3;
	private String enemy4;
	private String enemy5;

	private String[] imageAddresses;
	private JLabel Arrow_1;
	private JLabel Arrow_2;
	private JLabel Arrow_3;
	private JLabel Arrow_4;
	private JLabel Arrow_5;
	private JLabel Arrow_6;
	private JLabel Arrow_7;
	private JLabel Arrow_8;
	private JLabel Arrow_9;
	private JLabel Arrow_10;
	private JLabel Target_1;
	private JLabel Target_2;
	private JLabel Target_3;
	private JLabel Target_4;
	private JLabel Target_5;
	private JLabel Target_6;
	private JLabel Target_7;
	private JLabel Target_8;
	private JLabel Target_9;
	private JLabel Target_10;

	private JLabel[] arrows;
	private JLabel[] targets;
	private JLabel[] portraits;

	private ButtonGroup targetSelect;
	private ButtonGroup allySelect;
	private ButtonGroup abillitySelect;
	private JRadioButton[] buttonContainer;
	private JRadioButton[] buttonContainer2;
	private JRadioButton[] buttonContainer3;
	private JButton btnNewButton;

	private boolean confirm;
	private JButton btnNewButton_3;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JPanel TargetPane;

	private int abillityNum;
	private int currentTurn;
	
	private int heroTurn;
	private int enemyTurn;
	
	private actor[] actorList;
	
	private enemyClass[] enemiesList;
	
	private playerClass[] playerList;

	/**
	 * Create the application.
	 */
	public combat(enemyClass[] enemies, playerClass[] hero, JFrame frame, actor[] actors) {

		imageAddresses = new String[10];
		imageAddresses[0] = hero1;
		imageAddresses[1] = hero2;
		imageAddresses[2] = hero3;
		imageAddresses[3] = hero4;
		imageAddresses[4] = hero5;
		imageAddresses[5] = enemy1;
		imageAddresses[6] = enemy2;
		imageAddresses[7] = enemy3;
		imageAddresses[8] = enemy4;
		imageAddresses[9] = enemy5;

		// encounter = new CombatController(enemies, hero);

		contFlag = false;
		portraitFill(enemies, hero);
		System.out.println("portraitFill passed!");
		initialize(frame, enemies, hero);
		
		actorList = actors;
		enemiesList = enemies;
		playerList = hero;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame frame, enemyClass[] enemies, playerClass[] hero) {
		
		heroTurn = 0;
		enemyTurn = 0;
		
		panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 594, 396);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(true);
		
		TextBox = new JLabel("New label");
		TextBox.setForeground(SystemColor.activeCaptionBorder);
		TextBox.setFont(new Font("OCR A Extended", Font.PLAIN, 10));
		TextBox.setBackground(SystemColor.desktop);
		TextBox.setBounds(10, 0, 574, 48);
		TextBox.setOpaque(true);
		panel.add(TextBox);
		TextBox.setVisible(false);

		Arrow_10 = new JLabel("New label");
		Arrow_10.setIcon(new ImageIcon(combat.class.getResource("/Res/ActiveArrow.png")));
		Arrow_10.setBounds(489, 231, 105, 100);
		panel.add(Arrow_10);
		Arrow_10.setVisible(false);

		Arrow_9 = new JLabel("New label");
		Arrow_9.setIcon(new ImageIcon(combat.class.getResource("/Res/ActiveArrow.png")));
		Arrow_9.setBounds(451, 186, 105, 100);
		panel.add(Arrow_9);
		Arrow_9.setVisible(false);

		Arrow_8 = new JLabel("New label");
		Arrow_8.setIcon(new ImageIcon(combat.class.getResource("/Res/ActiveArrow.png")));
		Arrow_8.setBounds(402, 132, 105, 100);
		panel.add(Arrow_8);
		Arrow_8.setVisible(false);

		Arrow_7 = new JLabel("New label");
		Arrow_7.setIcon(new ImageIcon(combat.class.getResource("/Res/ActiveArrow.png")));
		Arrow_7.setBounds(378, 72, 105, 100);
		panel.add(Arrow_7);
		Arrow_7.setVisible(false);

		Arrow_6 = new JLabel("New label");
		Arrow_6.setIcon(new ImageIcon(combat.class.getResource("/Res/ActiveArrow.png")));
		Arrow_6.setBounds(349, 28, 105, 100);
		panel.add(Arrow_6);
		Arrow_6.setVisible(false);

		Arrow_5 = new JLabel("New label");
		Arrow_5.setIcon(new ImageIcon(combat.class.getResource("/Res/ActiveArrow.png")));
		Arrow_5.setBounds(121, 52, 105, 100);
		panel.add(Arrow_5);
		Arrow_5.setVisible(false);

		Arrow_4 = new JLabel("New label");
		Arrow_4.setIcon(new ImageIcon(combat.class.getResource("/Res/ActiveArrow.png")));
		Arrow_4.setBounds(162, 11, 105, 100);
		panel.add(Arrow_4);
		Arrow_4.setVisible(false);

		Arrow_3 = new JLabel("New label");
		Arrow_3.setIcon(new ImageIcon(combat.class.getResource("/Res/ActiveArrow.png")));
		Arrow_3.setBounds(85, 95, 105, 100);
		panel.add(Arrow_3);
		Arrow_3.setVisible(false);

		Arrow_2 = new JLabel("New label");
		Arrow_2.setIcon(new ImageIcon(combat.class.getResource("/Res/ActiveArrow.png")));
		Arrow_2.setBounds(39, 149, 105, 100);
		panel.add(Arrow_2);
		Arrow_2.setVisible(false);

		Arrow_1 = new JLabel("New label");
		Arrow_1.setIcon(new ImageIcon(combat.class.getResource("/Res/ActiveArrow.png")));
		Arrow_1.setBounds(0, 186, 105, 100);
		panel.add(Arrow_1);
		Arrow_1.setVisible(false);

		Target_1 = new JLabel("New label");
		Target_1.setIcon(new ImageIcon(combat.class.getResource("/Res/Target.png")));
		Target_1.setBounds(0, 243, 105, 100);
		panel.add(Target_1);
		Target_1.setVisible(false);

		Target_2 = new JLabel("New label");
		Target_2.setIcon(new ImageIcon(combat.class.getResource("/Res/Target.png")));
		Target_2.setBounds(40, 206, 105, 100);
		panel.add(Target_2);
		Target_2.setVisible(false);

		Target_3 = new JLabel("New label");
		Target_3.setIcon(new ImageIcon(combat.class.getResource("/Res/Target.png")));
		Target_3.setBounds(84, 149, 105, 100);
		panel.add(Target_3);
		Target_3.setVisible(false);

		Target_4 = new JLabel("New label");
		Target_4.setIcon(new ImageIcon(combat.class.getResource("/Res/Target.png")));
		Target_4.setBounds(121, 106, 105, 100);
		panel.add(Target_4);
		Target_4.setVisible(false);

		Target_5 = new JLabel("New label");
		Target_5.setIcon(new ImageIcon(combat.class.getResource("/Res/Target.png")));
		Target_5.setBounds(162, 72, 105, 100);
		panel.add(Target_5);
		Target_5.setVisible(false);

		Target_6 = new JLabel("New label");
		Target_6.setIcon(new ImageIcon(combat.class.getResource("/Res/Target.png")));
		Target_6.setBounds(349, 95, 105, 100);
		panel.add(Target_6);
		Target_6.setVisible(false);

		Target_7 = new JLabel("New label");
		Target_7.setIcon(new ImageIcon(combat.class.getResource("/Res/Target.png")));
		Target_7.setBounds(378, 132, 105, 100);
		panel.add(Target_7);
		Target_7.setVisible(false);

		Target_8 = new JLabel("New label");
		Target_8.setIcon(new ImageIcon(combat.class.getResource("/Res/Target.png")));
		Target_8.setBounds(402, 183, 105, 100);
		panel.add(Target_8);
		Target_8.setVisible(false);

		Target_9 = new JLabel("New label");
		Target_9.setIcon(new ImageIcon(combat.class.getResource("/Res/Target.png")));
		Target_9.setBounds(433, 231, 105, 100);
		panel.add(Target_9);
		Target_9.setVisible(false);

		Target_10 = new JLabel("New label");
		Target_10.setIcon(new ImageIcon(combat.class.getResource("/Res/Target.png")));
		Target_10.setBounds(472, 271, 105, 100);
		panel.add(Target_10);
		Target_10.setVisible(false);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(combat.class.getResource(imageAddresses[0])));
		lblNewLabel.setBounds(20, 271, 92, 100);
		panel.add(lblNewLabel);
		lblNewLabel.setVisible(true);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(combat.class.getResource(imageAddresses[1])));
		lblNewLabel_1.setBounds(53, 217, 92, 100);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(true);

		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(combat.class.getResource(imageAddresses[2])));
		lblNewLabel_2.setBounds(84, 173, 92, 100);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(true);

		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(combat.class.getResource(imageAddresses[3])));
		lblNewLabel_3.setBounds(117, 132, 92, 100);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(true);

		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(combat.class.getResource(imageAddresses[4])));
		lblNewLabel_4.setBounds(148, 95, 92, 100);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setVisible(true);

		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(combat.class.getResource(imageAddresses[5])));
		lblNewLabel_5.setBounds(475, 271, 92, 100);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setVisible(true);

		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(combat.class.getResource(imageAddresses[6])));
		lblNewLabel_6.setBounds(435, 217, 92, 100);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setVisible(true);

		lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(combat.class.getResource(imageAddresses[7])));
		lblNewLabel_7.setBounds(402, 173, 92, 100);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setVisible(true);

		lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon(combat.class.getResource(imageAddresses[8])));
		lblNewLabel_8.setBounds(378, 132, 92, 100);
		panel.add(lblNewLabel_8);
		lblNewLabel_8.setVisible(true);

		lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon(combat.class.getResource(imageAddresses[9])));
		lblNewLabel_9.setBounds(340, 95, 92, 100);
		panel.add(lblNewLabel_9);
		lblNewLabel_9.setVisible(true);
		
		portraits = new JLabel[10];
		portraits[0] = lblNewLabel;
		portraits[1] = lblNewLabel_1;
		portraits[2] = lblNewLabel_2;
		portraits[3] = lblNewLabel_3;
		portraits[4] = lblNewLabel_4;
		portraits[5] = lblNewLabel_5;
		portraits[6] = lblNewLabel_6;
		portraits[7] = lblNewLabel_7;
		portraits[8] = lblNewLabel_8;
		portraits[9] = lblNewLabel_9;

		targets = new JLabel[10];
		targets[0] = Target_1;
		targets[1] = Target_2;
		targets[2] = Target_3;
		targets[3] = Target_4;
		targets[4] = Target_5;
		targets[5] = Target_6;
		targets[6] = Target_7;
		targets[7] = Target_8;
		targets[8] = Target_9;
		targets[9] = Target_10;

		arrows = new JLabel[10];
		arrows[0] = Arrow_1;
		arrows[1] = Arrow_2;
		arrows[2] = Arrow_3;
		arrows[3] = Arrow_4;
		arrows[4] = Arrow_5;
		arrows[5] = Arrow_6;
		arrows[6] = Arrow_7;
		arrows[7] = Arrow_8;
		arrows[8] = Arrow_9;
		arrows[9] = Arrow_10;

		targetSelect = new ButtonGroup();
		allySelect = new ButtonGroup();
		abillitySelect = new ButtonGroup();

		JRadioButton rdbtnNewRadioButton_2_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTargetImage(7);
			}
		});
		rdbtnNewRadioButton_2_1.setBounds(178, 263, 207, 23);
		panel.add(rdbtnNewRadioButton_2_1);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTargetImage(8);
			}
		});
		rdbtnNewRadioButton_1.setBounds(178, 297, 207, 23);
		panel.add(rdbtnNewRadioButton_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTargetImage(9);
			}
		});
		rdbtnNewRadioButton.setBounds(178, 333, 207, 23);
		panel.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTargetImage(6);
			}
		});
		rdbtnNewRadioButton_3.setBounds(179, 225, 207, 23);
		panel.add(rdbtnNewRadioButton_3);

		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTargetImage(5);
			}
		});
		rdbtnNewRadioButton_4.setBounds(178, 186, 207, 23);
		panel.add(rdbtnNewRadioButton_4);

		targetSelect.add(rdbtnNewRadioButton_2_1);
		targetSelect.add(rdbtnNewRadioButton_1);
		targetSelect.add(rdbtnNewRadioButton);
		targetSelect.add(rdbtnNewRadioButton_3);
		targetSelect.add(rdbtnNewRadioButton_4);

		buttonContainer = new JRadioButton[5];
		buttonContainer[0] = rdbtnNewRadioButton;
		buttonContainer[1] = rdbtnNewRadioButton_1;
		buttonContainer[2] = rdbtnNewRadioButton_2_1;
		buttonContainer[3] = rdbtnNewRadioButton_3;
		buttonContainer[4] = rdbtnNewRadioButton_4;

		for (int i = 0; i < buttonContainer.length; i++) {
			buttonContainer[i].setVisible(false);
		}

		// allies
		JRadioButton ally3 = new JRadioButton("New radio button");
		ally3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTargetImage(2);
			}
		});
		ally3.setBounds(178, 263, 207, 23);
		panel.add(ally3);

		JRadioButton ally2 = new JRadioButton("New radio button");
		ally2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTargetImage(3);
			}
		});
		ally2.setBounds(178, 297, 207, 23);
		panel.add(ally2);

		JRadioButton ally1 = new JRadioButton("New radio button");
		ally1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTargetImage(4);
			}
		});
		ally1.setBounds(178, 333, 207, 23);
		panel.add(ally1);

		JRadioButton ally4 = new JRadioButton("New radio button");
		ally4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTargetImage(1);
			}
		});
		ally4.setBounds(179, 225, 207, 23);
		panel.add(ally4);

		JRadioButton ally5 = new JRadioButton("New radio button");
		ally5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTargetImage(0);
			}
		});
		ally5.setBounds(178, 186, 207, 23);
		panel.add(ally5);

		allySelect.add(ally1);
		allySelect.add(ally2);
		allySelect.add(ally3);
		allySelect.add(ally4);
		allySelect.add(ally5);

		buttonContainer2 = new JRadioButton[5];
		buttonContainer2[0] = ally5;
		buttonContainer2[1] = ally4;
		buttonContainer2[2] = ally3;
		buttonContainer2[3] = ally2;
		buttonContainer2[4] = ally1;

		for (int i = 0; i < 5; i++) {
			buttonContainer2[i].setVisible(false);
		}

		// ability Menu
		JRadioButton abillity3 = new JRadioButton("New radio button");
		abillity3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAbilityNum(2);
			}
		});
		abillity3.setBounds(178, 263, 207, 23);
		panel.add(abillity3);

		JRadioButton abillity2 = new JRadioButton("New radio button");
		abillity2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAbilityNum(3);
			}
		});
		abillity2.setBounds(178, 297, 207, 23);
		panel.add(abillity2);

		JRadioButton abillity1 = new JRadioButton("New radio button");
		abillity1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAbilityNum(4);
			}
		});
		abillity1.setBounds(178, 333, 207, 23);
		panel.add(abillity1);

		JRadioButton abillity4 = new JRadioButton("New radio button");
		abillity4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAbilityNum(1);
			}
		});
		abillity4.setBounds(179, 225, 207, 23);
		panel.add(abillity4);

		JRadioButton abillity5 = new JRadioButton("New radio button");
		abillity5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateAbilityNum(0);
			}
		});
		abillity5.setBounds(178, 186, 207, 23);
		panel.add(abillity5);

		abillitySelect.add(abillity1);
		abillitySelect.add(abillity2);
		abillitySelect.add(abillity3);
		abillitySelect.add(abillity4);
		abillitySelect.add(abillity5);

		buttonContainer3 = new JRadioButton[5];
		buttonContainer3[0] = abillity5;
		buttonContainer3[1] = abillity4;
		buttonContainer3[2] = abillity3;
		buttonContainer3[3] = abillity2;
		buttonContainer3[4] = abillity1;

		for (int i = 0; i < 5; i++) {
			buttonContainer3[i].setVisible(false);
		}

		btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// set boolean to break loop then remove targeting visibility
				confirm = true;
				btnNewButton.setVisible(false);
				;
				for (int i = 0; i < buttonContainer.length; i++) {
					buttonContainer[i].setVisible(false);
				}
				for (int i = 0; i < buttonContainer2.length; i++) {
					buttonContainer2[i].setVisible(false);
				}
				for (int i = 0; i < buttonContainer3.length; i++) {
					buttonContainer3[i].setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(236, 149, 89, 23);
		panel.add(btnNewButton);
		btnNewButton.setVisible(false);

		btnNewButton_1 = new JButton("Fight");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionType = 0;
				btnNewButton_1.setVisible(false);
				btnNewButton_2.setVisible(false);
				updateTargets(enemies);
			}
		});
		btnNewButton_1.setBounds(236, 243, 89, 23);
		panel.add(btnNewButton_1);
		btnNewButton.setVisible(false);

		btnNewButton_2 = new JButton("Heal");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionType = 1;
				btnNewButton_1.setVisible(false);
				btnNewButton_2.setVisible(false);
				updateAllies(hero);
			}
		});
		btnNewButton_2.setBounds(236, 282, 89, 23);
		panel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Continue");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contFlag = true;
				btnNewButton_3.setVisible(false);
				TextBox.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(236, 129, 89, 23);
		panel.add(btnNewButton_3);
		btnNewButton_3.setVisible(false);

		btnNewButton_2.setVisible(false);

		// updateTargets(enemies);
	}

	public void portraitFill(enemyClass[] enemies, playerClass[] hero) {
		int addressCount = 0;
		// Set Hero portrait variables
		
		for (int i = 0; i < hero.length; i++) {
				if (hero[i].getJob() == "Archer") {
					imageAddresses[i] = "/Res/ArcherSmall.png";
					addressCount++;
				} else if (hero[i].getJob() == "Hacker") {
					imageAddresses[i] = "/Res/HackerSmall.png";
					addressCount++;
				} else if (hero[i].getJob() == "Mage") {
					imageAddresses[i] = "/Res/MageSmall.png";
					addressCount++;

				} else if (hero[i].getJob() == "Paladin") {
					imageAddresses[i] = "/Res/PaladinSmall.png";
					addressCount++;

				} else if (hero[i].getJob() == "Warrior") {
					imageAddresses[i] = "/Res/Warrior.png";
					addressCount++;
				} else if (hero[i].getJob() == "Rogue") {
					imageAddresses[i] = "/Res/RogueSmall.png";
					addressCount++;
				}
			}

		System.out.println("initial hero fill passed!");
		// fill remaining hero portraits
		while (addressCount < 5) {
			imageAddresses[addressCount] = "/Res/Empty.png";
			addressCount++;
		}

		// Set Enemy portrait variables;
		for (int i = 5; i < enemies.length + 5; i++) {
				if (enemies[i - 5].getName() == "Barber-a") {
					imageAddresses[i] = "/Res/BarberaSmall.png";
					addressCount++;
				} else if (enemies[i - 5].getName() == "Droplet") {
					imageAddresses[i] = "/Res/DropletSmall.png";
					addressCount++;
				} else if (enemies[i - 5].getName() == "Froseidon") {
					imageAddresses[i] = "/Res/FroseidonSmall.png";
					addressCount++;

				} else if (enemies[i - 5].getName() == "Hairizzle") {
					imageAddresses[i] = "/Res/HairizzleSmall.png";
					addressCount++;

				} else if (enemies[i - 5].getName() == "Bad Boyt") {
					imageAddresses[i] = "/Res/BadBoytSmall.png";
					addressCount++;
				} else if (enemies[i - 5].getName() == "Naughtilus") {
					imageAddresses[i] = "/Res/NaughtilusSmall.png";
					addressCount++;
				} else if (enemies[i - 5].getName() == "Shelldon") {
					imageAddresses[i] = "/Res/Sheldon.png";
					addressCount++;
				}
		}
		// fill remaining enemy portraits
		while (addressCount <= 9) {
			imageAddresses[addressCount] = "/Res/Empty.png";
			addressCount++;
		}
	}

	public void updatePortraits(enemyClass[] enemies, playerClass[] hero) {
		int portraitTracker = 0;
		for (int i = 0; i < hero.length; i++) {
			if(hero[i].isDead()) {
				portraits[i].setIcon(new ImageIcon(combat.class.getResource("/Res/Empty.png")));
			}
			portraitTracker++;
		}
		for (int i = 5; i < enemies.length+5; i ++) {
			if( enemies[i-5].isDead()) {
				portraits[i].setIcon(new ImageIcon(combat.class.getResource("/Res/Empty.png")));
			}
		}
		
	}
	public void updateArrow(int turn) {
		
		if ( actorList[turn].getPlayerFlag()) {
			turn = (actorList.length - enemiesList.length - turn -1);
		}
		else {
			turn = (10 - turn);
		}
		contFlag = false;
		confirm = false;
		for (int i = 0; i < arrows.length; i++) {
			arrows[i].setVisible(false);
		}
		arrows[turn].setVisible(true);
		currentTurn = turn;
	}

	public void updateTargets(enemyClass[] enemies) {
		btnNewButton.setVisible(true);
		;
		int targetCount = 0;
		for (int i = 0; i < 5; i++) {
			buttonContainer[i].setVisible(false);
		}
		for (int i = 0; i < enemies.length; i++) {
			if (!enemies[i].isDead()) {
				targetCount++;
				buttonContainer[i].setText("LVL " + enemies[i].getLevel() + " "
						+ enemies[i].getName() + " HP: "
						+ enemies[i].getRemainingHealth());
				buttonContainer[i].setFont((new Font("OCR A Extended", Font.PLAIN, 10)));
				buttonContainer[i].setVisible(true);
			}
//			else {
//				buttonContainer[targetCount].setVisible(targetCount);
//			}
		}
	}

	public void updateAllies(playerClass[] hero) {
		btnNewButton.setVisible(true);
		;
		int targetCount = 0;
		for (int i = 0; i < 5; i++) {
			buttonContainer2[i].setVisible(false);
		}
		for (int i = 0; i < hero.length; i++) {
			if (!hero[i].isDead()) {
				targetCount++;
				buttonContainer2[i].setText(
						"LVL " + hero[hero.length - 1 - i].getLevel() + " " + hero[hero.length - 1 - i].getName()
								+ " HP: " + hero[hero.length - 1 - i].getRemainingHealth());
				buttonContainer2[i].setFont((new Font("OCR A Extended", Font.PLAIN, 10)));
				buttonContainer2[i].setVisible(true);
			}
		}
	}

	public void updateTargetImage(int target) {
		for (int i = 0; i < targets.length; i++) {
			targets[i].setVisible(false);
		}
		targets[target].setVisible(true);

		if (target >= 5) {
			selectedEnemy = (9 - target);
		} else {
			selectedEnemy = target;
		}
	}

	public int targetEnemy(enemyClass[] enemies) {
		updateTargets(enemies);
		btnNewButton.setVisible(true);
		return selectedEnemy;
	}

	public void targetAlly() {

	}

	public void displayActions(playerClass[] hero, int currentHero) {
		confirm = false;
		btnNewButton.setVisible(true);

		for (int i = 0; i < 5; i++) {
			buttonContainer3[i].setVisible(false);
		}
		if (actionType == 0) {
			int abilityTracker = 0;
			hero[currentHero].assembleViolentActions();
			for (int i = 0; i < hero[currentHero].getNumViolentActions(); i++) {
				buttonContainer3[i].setText(hero[currentHero].getViolentActionName(i));
				buttonContainer3[i].setFont((new Font("OCR A Extended", Font.PLAIN, 10)));
				buttonContainer3[i].setVisible(true);
				if (hero[currentHero].getViolentAbilityType(i) == 0) {
					buttonContainer3[i].setText(hero[currentHero].getViolentActionName(i) + "x"
							+ (hero[currentHero].getNumViolentActions() - abilityTracker));
					break;
				}
				abilityTracker++;
			}
		}

		else {
			hero[currentHero].assembleFriendlyActions();
			int abilityTracker = 0;
			for (int i = 0; i < hero[currentHero].getNumFriendlyActions(); i++) {
				buttonContainer3[i].setText(hero[currentHero].getFriendlyActionName(i));
				buttonContainer3[i].setFont((new Font("OCR A Extended", Font.PLAIN, 10)));
				buttonContainer3[i].setVisible(true);
				if (hero[currentHero].getFriendlyAbilityType(i) == 0) {
					buttonContainer3[i].setText(hero[currentHero].getFriendlyActionName(i) + "x"
							+ (hero[currentHero].getNumFriendlyActions() - abilityTracker));
					break;
				}
				abilityTracker++;
			}
		}

	}
	
	public void updateText(String text) {
		TextBox.setVisible(true);
		btnNewButton_3.setVisible(true);
		TextBox.setText(text);
	}

	public int getActionType() {
		return actionType;
	}

	public void displayFight() {
		// TargetPane.setVisible(true);
		btnNewButton_1.setVisible(true);
	}

	public void displayHeal() {
		btnNewButton_2.setVisible(true);
	}

	public int getEnemySelected() {
		return selectedEnemy;
	}

	public boolean getConfirm() {
		return confirm;
	}

	public void updateAbilityNum(int abillityNum) {
		this.abillityNum = abillityNum;
	}

	public int getAbillityNum() {
		return abillityNum;
	}
	public boolean getContFlag() {
		return contFlag;
	}
}
