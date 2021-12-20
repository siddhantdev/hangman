import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class InfoPanel extends JPanel {
    private JPanel cards;
    private JButton back;
    private JButton play;

    public InfoPanel(JPanel c) {
        this.cards = c;
        back = new JButton("<--");
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                CardLayout cl = (CardLayout) cards.getLayout();
                cl.show(cards, "MAIN");
            }
        });

        setLayout(new GridLayout(3, 1));

        JPanel bP = new JPanel();
        bP.add(back);

        add(bP);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setLineWrap(true);
        area.setBorder(BorderFactory.createCompoundBorder(
            area.getBorder(),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        area.setColumns(20);
        area.setText("The player has to guess a word");
        area.append(" is picked by the computer. The word to");
        area.append("guess is represented by a row of rectangles,");
        area.append("each representing a letter of the word. If the");
        area.append("player guesses a letter which occurs in the word,");
        area.append("the corresponding rectangle(s) will be filled in ");
        area.append("with the letter. However, if the letter does not ");
        area.append("occur in the word, then a part of the hanged stick ");
        area.append("figure will be drawn. \n\n If the hanged man appears");
        area.append("fully before the player correctly guesses the word, then the player loses.");

        add(area);

        play = new JButton("Play");
        play.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                CardLayout cl = (CardLayout) cards.getLayout();
                cl.show(cards, "HANG");
            }
        });

        JPanel playP = new JPanel();
        playP.add(play);
        add(playP);
    }
}
