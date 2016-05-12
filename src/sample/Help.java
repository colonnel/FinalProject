package sample;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


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
