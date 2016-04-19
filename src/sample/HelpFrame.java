package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Admin on 19.04.16.
 */
public class HelpFrame extends JFrame {

    public HelpFrame() {
        JButton closeButton = new JButton("Close");
        setTitle("Help file");
        setLayout(new FlowLayout());
        File helpFile=new File();
        //add(closeButton);
        //closeButton.addActionListener((ActionListener) this);
        setSize(300, 600);
        setVisible(true);

    }

}
