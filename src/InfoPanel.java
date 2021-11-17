import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class InfoPanel extends JPanel {
    private JLabel label;
    public InfoPanel() {
        label = new JLabel("Info Panel");
        add(label);
    }
}
