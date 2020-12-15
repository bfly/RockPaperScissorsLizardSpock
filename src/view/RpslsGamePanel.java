package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import model.RpslsModel;

import java.awt.*;
import java.time.Instant;
import java.util.Random;

public class RpslsGamePanel extends JPanel {

	private final static int ROCK = 0;
	private final static int PAPER = 1;
	private final static int SCISSORS = 2;
	private final static int LIZARD = 3;
	private final static int SPOCK = 4;
	
	private final static int WIDTH = 200;

	private static Random random;

	private final JLabel userImage = new JLabel();
	private final JLabel compImage = new JLabel();
	private final JTextArea result = new JTextArea();

	private final ImageIcon[] images = 
		new ImageIcon[] {
		new ImageIcon("rock.png"),
		new ImageIcon("paper.png"),
		new ImageIcon("scissors.png"),
		new ImageIcon("lizard.jpeg"),
		new ImageIcon("spock.jpeg")
	};

	public RpslsGamePanel() {
		random = new Random(Instant.now().getNano());

		setLayout(new BorderLayout(10, 10));
		setBorder(new EmptyBorder(5,5,5,5));
		setBackground(Color.WHITE);

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BorderLayout());
		northPanel.setBackground(Color.WHITE);

		JLabel userLabel = new JLabel();
		userLabel.setFont(new Font("Serif", Font.BOLD, 18));
		userLabel.setText("Your Choice");
		northPanel.add(userLabel, BorderLayout.WEST);

		JLabel compLabel = new JLabel();
		compLabel.setFont(new Font("Serif", Font.BOLD, 18));
		compLabel.setText("Computer");
		northPanel.add(compLabel, BorderLayout.EAST);

		JPanel westPanel = new JPanel();
		westPanel.setBackground(Color.WHITE);
		westPanel.setSize(100, 200);
		westPanel.add(userImage);

		JPanel eastPanel = new JPanel();
		eastPanel.setBackground(Color.WHITE);
		eastPanel.setSize(100, 200);
		eastPanel.add(compImage);

		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.WHITE);
		centerPanel.setPreferredSize(new Dimension(WIDTH, WIDTH));
		result.setFont(new Font("Serif", Font.BOLD, 18));
		result.setText(RpslsModel.center("Click a button to start.", 200));
		centerPanel.add(result);

		JButton rockButton = new JButton("Rock");
		rockButton.addActionListener(e -> getResult(ROCK));

		JButton paperButton = new JButton("Paper");
		paperButton.addActionListener(e -> getResult(PAPER));

		JButton scissorsButton = new JButton("Scissors");
		scissorsButton.addActionListener(e -> getResult(SCISSORS));

		JButton lizardButton = new JButton("Lizard");
		lizardButton.addActionListener(e -> getResult(LIZARD));

		JButton spockButton = new JButton("Spock");
		spockButton.addActionListener(e -> getResult(SPOCK));
		
		JPanel southPanel = new JPanel();
		southPanel.add(rockButton);
		southPanel.add(paperButton);
		southPanel.add(scissorsButton);
		southPanel.add(lizardButton);
		southPanel.add(spockButton);

		add(northPanel,  BorderLayout.NORTH);
		add(westPanel,   BorderLayout.WEST);
		add(eastPanel,   BorderLayout.EAST);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel,  BorderLayout.SOUTH);
		setVisible(true);
	}

	private void getResult(int user) {
		int computer = random.nextInt(images.length);
		userImage.setIcon(images[user]);
		compImage.setIcon(images[computer]);
		result.setText(RpslsModel.determineWinner(user, computer, WIDTH));
	}

}
