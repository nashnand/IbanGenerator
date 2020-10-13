package Iban;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SortIntegerValidation extends IBANGEN implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        String value = SortCodeTextBox.getText();
        int l = value.length();
        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_DELETE) {
            SortCodeTextBox.setEditable(true);
            IBANGEN.Errorlabel.setText("");
        } else {
            SortCodeTextBox.setEditable(false);
            SortCodeTextBox.setToolTipText("* Enter only numeric digits(0-9)");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}