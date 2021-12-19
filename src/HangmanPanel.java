import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.*;

public class HangmanPanel extends JPanel {
    private JPanel cards;
    private JButton back;
    private int gRemaining;
    private String guess;
    private String word;

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

        gRemaining = 0;

        word = "";
        try {
            int index = ((int) (Math.random() * 2750)) + 1;
            Scanner in = new Scanner(new File("words.txt"));
            for(int i = 1; i <= index; i++) {
                word = in.nextLine();
            }
        }
        catch (FileNotFoundException e) {
            word = "hangman";
        }

        word.toLowerCase();

        guess = "";
        for(int i = 0; i < word.length(); i++)
            guess += "_";
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(2));

        int x = getWidth();
        int y = getHeight();
        drawGuess(g2, x, y);
        drawGallow(g2, x, y);
        drawMan(g2, x, y);   
    }

    private void drawGuess(Graphics2D g2, int x, int y) {
        Font font = g2.getFont();
        g2.setFont(new Font(font.getName(), Font.PLAIN, (int) (Math.min(x,y) * 0.05)));
        FontMetrics fm = g2.getFontMetrics();
        int l = guess.length();

        int yC = (int) (y * 0.05);
        int height = (int) (y * 0.15);
        int width = (int) ((x * 0.96) / l);
        int xC = (int) (x * 0.02);

        for(int i = 0; i < l; i++) {
            g2.drawRect(xC, yC, (int)(width - (x * 0.005)), height);
            String letter = guess.substring(i, i + 1);
            if(!letter.equals("_"))
                g2.drawString(letter, (int) (xC + (width - (x * 0.005) - fm.stringWidth(letter)) / 2),(int) (yC + (((height - fm.getHeight()) / 2) + fm.getAscent())));
            
            xC += width;
        }
    }

    private void drawGallow(Graphics2D g2, int x, int y) {
        g2.drawLine((int) (x * 0.2), (int) (y * 0.8), (int) (x * 0.8), (int) (y * 0.8));
        g2.drawRect((int) (x / 2 - x * 0.2), (int) (y * 0.8 - y * 0.075), (int) (x * 0.4), (int) (y * 0.075));
        g2.drawLine((int) (x / 2 + x * 0.2 - x * 0.035), (int) (y * 0.8 - y * 0.075),
                (int) (x / 2 + x * 0.2 - x * 0.035), (int) (y * 0.3));
        g2.drawLine((int) (x / 2 + x * 0.2 - x * 0.035), (int) (y * 0.3), (int) (x / 2), (int) (y * 0.3));
        g2.drawLine((int) (x / 2), (int) (y * 0.3), (int) (x / 2), (int) (y * 0.3 + y * 0.05));
    }

    private void drawMan(Graphics2D g2, int x, int y) {
        int boxSize = Math.min(x, y);
        int border = (int) (boxSize * 0.97);
        int radius = boxSize - border;

        int cCenterY = (int) (y * 0.3 + y * 0.05) + radius;
        int cCenterX = (int) (x / 2);

        if (gRemaining <= 5)
            g2.drawOval(cCenterX - radius, cCenterY - radius, radius * 2, radius * 2);

        if (gRemaining <= 4)
            g2.drawLine(cCenterX, cCenterY + radius, cCenterX, (int) (cCenterY + y * 0.19));

        if (gRemaining <= 3)
            g2.drawLine(cCenterX, cCenterY + radius + (int) (y * 0.19 * 0.07), (int) (cCenterX - x * 0.05),
                    cCenterY + radius + (int) (y * 0.19 * 0.23));

        if (gRemaining <= 2)
            g2.drawLine(cCenterX, cCenterY + radius + (int) (y * 0.19 * 0.07), (int) (cCenterX + x * 0.05),
                    cCenterY + radius + (int) (y * 0.19 * 0.23));

        if (gRemaining <= 1)
            g2.drawLine(cCenterX, (int) (cCenterY + y * 0.19 - y * 0.19 * 0.005), (int) (cCenterX - x * 0.05),
                    (int) (cCenterY + radius + y * 0.19 + y * 0.19 * 0.23));

        if (gRemaining == 0)
            g2.drawLine(cCenterX, (int) (cCenterY + y * 0.19 - y * 0.19 * 0.005), (int) (cCenterX + x * 0.05),
                    (int) (cCenterY + radius + y * 0.19 + y * 0.19 * 0.23));
    }
}
