import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class InfoPanel extends JPanel {
    private JLabel label;
    private JPanel cards;
    private JButton back;

    public InfoPanel(JPanel c) {
        this.cards = c;
        back = new JButton("<--");
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                CardLayout cl = (CardLayout) cards.getLayout();
                cl.show(cards, "MAIN");
            }
        });

        add(back);

        label = new JLabel("Info Panel");
        add(label);
    }
}
