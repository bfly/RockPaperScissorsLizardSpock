package controller;
import javax.swing.*;

import view.RpslsInitialPanel;
import view.RpslsGamePanel;

import java.awt.*;

public class RpslsController extends JFrame {
    private JPanel gamePanel, initialPanel, buttonPanel;

    public RpslsController() {
        try { UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()); }
        catch (Exception e) { e.printStackTrace(); }
        setSize(new Dimension(420, 200));
        setLayout(new BorderLayout(10, 10));
        gamePanel = new RpslsGamePanel();
        initialPanel = new RpslsInitialPanel();
        buttonPanel = createButtonPanel();
        add(initialPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        setTitle("Rock Paper Scissors Lizard Spock");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createButtonPanel() {
    	JPanel panel = new JPanel();
    	setBackground(Color.WHITE);
        JButton letsPlay = new JButton();
        letsPlay.setSize(150,50);
        letsPlay.setFont(new Font("Serif", Font.BOLD, 24));
        letsPlay.setText("Let's Play!");
        letsPlay.addActionListener(e -> switchPanel());
    	panel.add(letsPlay);
    	panel.setVisible(true);
    	return panel;
    }
    
    private void switchPanel() {
        remove(initialPanel);
        remove(buttonPanel);
        add(gamePanel);
        setVisible(true);
        repaint();
    }
}
