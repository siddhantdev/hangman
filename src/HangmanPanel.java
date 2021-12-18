import java.awt.*;
import java.awt.event.*;
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

        gRemaining = 0;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(2));

        int x = getWidth();
        int y = getHeight();

        int boxSize = Math.min(x, y);
        int border = (int) (boxSize * 0.97);
        int radius = boxSize - border;

        int cCenterY = (int) (y * 0.3 + y * 0.05) + radius;
        int cCenterX = (int) (x / 2);

        g2.drawLine((int) (x * 0.2), (int) (y * 0.8), (int) (x * 0.8), (int) (y * 0.8));
        g2.drawRect((int) (x / 2 - x * 0.2), (int) (y * 0.8 - y * 0.075),(int) (x * 0.4),(int) (y * 0.075));
        g2.drawLine((int)(x / 2 + x * 0.2 - x * 0.035), (int) (y * 0.8 - y * 0.075), 
                (int) (x / 2 + x * 0.2 - x * 0.035), (int) (y * 0.3));
        g2.drawLine((int) (x / 2 + x * 0.2 - x * 0.035), (int) (y * 0.3), (int) (x / 2), (int) (y * 0.3));
        g2.drawLine((int) (x / 2), (int) (y * 0.3), (int) (x / 2),(int) (y * 0.3 + y * 0.05));

        if(gRemaining <= 5)
            g2.drawOval(cCenterX - radius, cCenterY - radius, radius * 2, radius * 2);

        if(gRemaining <= 4) 
            g2.drawLine(cCenterX, cCenterY + radius, cCenterX,(int) (cCenterY + y * 0.19));

        if(gRemaining <= 3)
            g2.drawLine(cCenterX, cCenterY + radius + (int) (y * 0.19 * 0.07),(int) (cCenterX - x * 0.05), 
                    cCenterY + radius + (int) (y * 0.19 * 0.23));

        if(gRemaining <= 2)
            g2.drawLine(cCenterX, cCenterY + radius + (int) (y * 0.19 * 0.07),(int) (cCenterX + x * 0.05), 
                    cCenterY + radius + (int) (y * 0.19 * 0.23));
        
        if(gRemaining <= 1)
            g2.drawLine(cCenterX, (int) (cCenterY + y * 0.19 - y * 0.19 * 0.005), (int) (cCenterX - x * 0.05), 
                    (int) (cCenterY + radius + y * 0.19 + y * 0.19 * 0.23));

        if(gRemaining == 0)
            g2.drawLine(cCenterX, (int) (cCenterY + y * 0.19 - y * 0.19 * 0.005), (int) (cCenterX + x * 0.05), 
                    (int) (cCenterY + radius + y * 0.19 + y * 0.19 * 0.23));
    }
}
