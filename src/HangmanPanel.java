import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class HangmanPanel extends JPanel {
    private JLabel label;
    private JPanel cards;
    private JButton back;
    private int gRemaining;

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

        gRemaining = 6;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(2));

        int x = getWidth();
        int y = getHeight();

        g2.drawLine((int) (x * 0.2), (int) (y * 0.8), (int) (x * 0.8), (int) (y * 0.8));
        g2.drawRect((int) (x / 2 - x * 0.2), (int) (y * 0.8 - y * 0.075),(int) (x * 0.4),(int) (y * 0.075));
        g2.drawLine((int)(x / 2 + x * 0.2 - x * 0.035), (int) (y * 0.8 - y * 0.075), 
                (int) (x / 2 + x * 0.2 - x * 0.035), (int) (y * 0.3));
        g2.drawLine((int) (x / 2 + x * 0.2 - x * 0.035), (int) (y * 0.3), (int) (x / 2), (int) (y * 0.3));
        g2.drawLine((int) (x / 2), (int) (y * 0.3), (int) (x / 2),(int) (y * 0.3 + y * 0.05));

        // int boxSize = Math.min(x, y);
        // double border = boxSize * 0.5;
        // double radius = boxSize - border;


        // Ellipse2D.Double circle = new Ellipse2D.Double((x / 2) - (radius / 2), (y / 2) - (radius / 2), radius, radius);
        // g2.draw(circle);
    }
}
