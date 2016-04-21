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
        JButton closeButton = new JButton("Close");
        setTitle("Help file");
        setLayout(new FlowLayout());
        JLabel label = new JLabel("<h4>For add a shape on canvas press on keyboard:</h4>\n" +
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
                "<h4>Have a nice day!</h4>");
        add(label, BorderLayout.SOUTH);
//        closeButton.addActionListener((ActionListener) this);
        setSize(300, 600);
        setVisible(true);
        add(closeButton);
        JTextArea helpFile = new JTextArea();
        helpFile.setEditable(false);
        JScrollPane scroll=new JScrollPane();
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        helpFile.append("<h4>For add a shape on canvas press on keyboard:</h4>\n" +
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
                "<h4>Have a nice day!</h4>");



    }

}
