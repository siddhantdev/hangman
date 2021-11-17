import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JFrame {
    public Game() {
        String info = "INFO";
        String hang = "HANG";
        String main = "MAIN";

        Container ct = getContentPane();

        JPanel cards = new JPanel(new CardLayout());

        JPanel mainscreen = new JPanel(); //use FlowLayout
        JButton hB = new JButton("Play");
        JButton iB = new JButton("How to Play?");

        HangmanPanel hp = new HangmanPanel(cards);
        InfoPanel ip = new InfoPanel(cards);

        hB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, hang);
            }
        });

        iB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                cl.show(cards, info);
            }
        });

        mainscreen.add(hB);
        mainscreen.add(iB);

        cards.add(mainscreen, main);
        cards.add(hp, hang);
        cards.add(ip, info);
        ct.add(cards);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hangman");
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run GUI codes in the Event-Dispatching thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Game();  // Let the constructor do the job
            }
        });
    }
}
