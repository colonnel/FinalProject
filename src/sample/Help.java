package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Inna on 17.04.2016.
 */
public class Help {

    public Help() {
        Desktop desktop = Desktop.getDesktop();
        try {
            URI url = new URI("c:/help.html");
            desktop.browse(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
