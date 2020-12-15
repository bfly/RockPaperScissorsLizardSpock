package view;

import javax.swing.*;
import java.awt.*;

public class RpslsInitialPanel extends JPanel {

    private final ImageIcon[] images =
        new ImageIcon[] {
            new ImageIcon("rock.png"),
            new ImageIcon("paper.png"),
            new ImageIcon("scissors.png"),
            new ImageIcon("lizard.jpeg"),
            new ImageIcon("spock.jpeg")
        };

    public RpslsInitialPanel() {
        setSize(420, 150);
        setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        setBackground(Color.WHITE);

        JLabel image1 = getImage(0);
        JLabel image2 = getImage(1);
        JLabel image3 = getImage(2);
        JLabel image4 = getImage(3);
        JLabel image5 = getImage(4);
        JLabel label1 = getLabel("Rock");
        JLabel label2 = getLabel("Paper");
        JLabel label3 = getLabel("Scissors");
        JLabel label4 = getLabel("Lizard");
        JLabel label5 = getLabel("Spock");

        add(image1);
        add(image2);
        add(image3);
        add(image4);
        add(image5);
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        setVisible(true);
    }

    private JLabel getImage( int i ) {
        JLabel image = new JLabel(images[i]);
        image.setSize(64, 64);
        return image;
    }

    private JLabel getLabel(String text) {
        JLabel label = new JLabel();
        label.setSize(96, 10);
        label.setFont(new Font("Serif", Font.BOLD, 24));
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setText(text);
        return label;
    }
}
