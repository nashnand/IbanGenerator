package Iban;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AccountNumberValidation extends IBANGEN implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        System.out.println(ke.getModifiersEx() + "-" + ke.paramString() + "-" + ke.getID() + "-" + ke.getClass());

        String value = AccountNumberTextBox.getText();
        int l = value.length();
        if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_DELETE) {
            AccountNumberTextBox.setEditable(true);
            IBANGEN.ErrorlabelAccountNumber.setText("");
        } else {
            AccountNumberTextBox.setEditable(false);
            IBANGEN.ErrorlabelAccountNumber.setText("* Enter only numeric digits(0-9)");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

