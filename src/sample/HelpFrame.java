package sample;

import javax.swing.*;
import java.awt.*;


public class HelpFrame extends JFrame {

    public HelpFrame() {
        setTitle(Const.TITLE_HELP);
        setLayout(new FlowLayout());
        JLabel label = new JLabel();
        label.getVerticalAlignment();
        label.getHorizontalAlignment();
        label.setText(Const.TEXT_HELP);
        add(label, BorderLayout.SOUTH);
        setSize(Const.SIZE_FRAME, Const.SIZE_FRAME);
        setVisible(true);
    }
}
