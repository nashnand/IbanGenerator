package Iban;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class GenerateButton extends IBANGEN implements ActionListener {
    public void actionPerformed(ActionEvent e) {

        if (CountryCodeTextBox.getText().isEmpty() || BICTextBox.getText().isEmpty() || SortCodeTextBox.getText().isEmpty() || AccountNumberTextBox.getText().isEmpty()) {
            GenerateButton.setEnabled(false);
            GenratedIBANTextBox.setText("Reset & Enter All field ");
        } else {

            StringBuffer CountryCodeFormatted = null, BICFormatted = null;
            String FinalVal, IBAN;
            BigInteger ModulasBy = BigInteger.valueOf(98);
            BigInteger DifferenceBy = BigInteger.valueOf(97);
            BigInteger FinalValBigInteger, Reminder, Checkdigit;

            /*Checkdigit Calculation*/
            /*Bic Mapping*/
            BICFormatted = Mapping(BICTextBox.getText());
            /*Country Mapping*/
            CountryCodeFormatted = Mapping(CountryCodeTextBox.getText());
            FinalVal = BICFormatted + (SortCodeTextBox.getText()) + (AccountNumberTextBox.getText()) + CountryCodeFormatted + "00";
            FinalValBigInteger = new BigInteger(FinalVal);
            Reminder = FinalValBigInteger.mod(ModulasBy);
            Checkdigit = DifferenceBy.subtract(Reminder);
            IBAN = Checkdigit.toString();

            /*FINAL IBAN CONCATINATION*/
            String GenerateIban = CountryCodeTextBox.getText().toUpperCase() + IBAN +
                    SortCodeTextBox.getText().toUpperCase() + SortCodeTextBox.getText() +
                    AccountNumberTextBox.getText();
            GenratedIBANTextBox.setText(GenerateIban);

        }
    }


}
