package sample;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


/**
 * Created by Admin on 19.04.16.
 */
public class HelpFrame extends JFrame {

    public HelpFrame() {

        setTitle("Help file");
        setLayout(new FlowLayout());
        JLabel label = new JLabel();
        label.getVerticalAlignment();
        label.getHorizontalAlignment();
        label.setText("<html><h4>For add a shape on canvas press on keyboard:</h4>\n" +
                "<p>\"1\" - circle\n" +
                "<br>\"2\" - square\n" +
                "<br>\"3\" - triangle\n" +
                "<br>\"4\" - rectangle\n" +
                "<br>\"5\" - oval\n" +
                "<br>\"R\" - random shape</p>\n" +
                "<h4>You may to move last shape with arrow keys on keyboard:</h4>\n" +
                "<p>For switching between shapes use:\n" +
                "<br>\"A\" - previous shape\n" +
                "<br>\"D\" - next shape\n" +
                "<br>If You want to clear canvas - click on\n" +
                "<br>\"Clear canvas\" button or press \"C\" on keyboard.</p>\n" +
                "<h4>Have a nice day!</h4></html>");
        add(label, BorderLayout.SOUTH);
        setSize(400, 400);
        setVisible(true);
        JButton closeButton = new JButton("Close");
       // closeButton.addActionListener(new ButtonActionListener

       // );
        add(closeButton);


    }

}
