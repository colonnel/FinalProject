package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Admin on 19.04.16.
 */
public class HelpFrame extends JFrame {

    public HelpFrame() {
        JButton closeButton = new JButton("Close");
        setTitle("Help file");
        setLayout(new FlowLayout());
        add(closeButton);
        closeButton.addActionListener((ActionListener) this);
        setSize(300, 100);
        setVisible(true);
    }

}
