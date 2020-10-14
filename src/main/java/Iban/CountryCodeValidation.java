package Iban;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CountryCodeValidation extends IBANGEN implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        String value = CountryCodeTextBox.getText().toLowerCase();
        if (ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z' || ke.getKeyChar() >= 'A' && ke.getKeyChar() <= 'Z' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_DELETE) {
            CountryCodeTextBox.setEditable(true);
            IBANGEN.ErrorlabelCountryCode.setText("");
        } else {
            CountryCodeTextBox.setEditable(false);
            IBANGEN.ErrorlabelCountryCode.setText("* Enter only character(a-z)");
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }
}
