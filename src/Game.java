import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    public Game() {
        HangmanPanel hp = new HangmanPanel();
        ControlPanel cp = new ControlPanel(hp);

        Container ct = getContentPane();
        ct.setLayout(new BorderLayout());
        ct.add(hp, BorderLayout.CENTER);
        ct.add(cp, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hangman");
        pack();
        setVisible(true);
    }
}
