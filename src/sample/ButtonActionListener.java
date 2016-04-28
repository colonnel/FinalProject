package sample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bse on 22.04.16.
 */
public class ButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        e.getActionCommand();

    }
}
