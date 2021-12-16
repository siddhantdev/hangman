import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class HangmanPanel extends JPanel {
    private JLabel label;
    private JPanel cards;
    private JButton back;

    public HangmanPanel(JPanel c) {
        this.cards = c;
        back = new JButton("<--");
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                CardLayout cl = (CardLayout) cards.getLayout();
                cl.show(cards, "MAIN");
            }
        });

        add(back);

        label = new JLabel("Hangman Panel");
        add(label);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(1));

        int x = getWidth();
        int y = getHeight();

        int boxSize = Math.min(x, y);
        double border = boxSize * 0.5;
        double radius = boxSize - border;

        Ellipse2D.Double circle = new Ellipse2D.Double((x / 2) - (radius / 2), (y / 2) - (radius / 2), radius, radius);

        g2.draw(circle);
    }
}
