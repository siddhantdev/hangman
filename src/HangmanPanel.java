import java.awt.*;
import javax.swing.*;

public class HangmanPanel extends JPanel {
    private JLabel label;
    public HangmanPanel() {
        label = new JLabel("Hangman Panel");
        add(label);
    }
}
