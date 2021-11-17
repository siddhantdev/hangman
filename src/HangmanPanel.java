import java.awt.*;
import java.awt.event.*;
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
}
