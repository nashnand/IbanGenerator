package Iban;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButton extends IBANGEN implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        CountryCodeTextBox.setText("");
        CountryCodeTextBox.setEditable(true);
        BICTextBox.setText("");
        BICTextBox.setEditable(true);
        SortCodeTextBox.setText("");
        SortCodeTextBox.setEditable(true);
        AccountNumberTextBox.setText("");
        AccountNumberTextBox.setEditable(true);
        GenratedIBANTextBox.setText("");
        GenerateButton.setEnabled(true);

    }

}
