package Iban;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.HashMap;

public class IBANGEN implements ActionListener {
    static String CCode, SScode, ANum;
    public static JLabel Concode;
    public static JTextField CountryCode;
    public static JLabel Scode;
    public static JTextField SortCode;
    public static JLabel Bcode;
    public static JTextField BBCode;
    public static JLabel Acnum;
    public static JTextField AccNum;
    public static JButton Generate;
    public static JTextField IBANTEXT;
    StringBuffer ConConsol = null;
    StringBuffer BicConsol = null;

    public static void main(String[] args) {

        JFrame frame = new JFrame("IBAN CALCULATOR");
        JPanel panel = new JPanel();
        frame.setSize(500, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);


        Concode = new JLabel("Countrycode");
        Concode.setBounds(10, 20, 130, 25);
        panel.add(Concode);
        CountryCode = new JTextField(50);
        CountryCode.setBounds(150, 20, 190, 25);
        panel.add(CountryCode);

        Bcode = new JLabel("BIC");
        Bcode.setBounds(10, 50, 130, 25);
        panel.add(Bcode);
        BBCode = new JTextField(20);
        BBCode.setBounds(150, 50, 190, 25);
        panel.add(BBCode);

        Scode = new JLabel("SortCode");
        Scode.setBounds(10, 80, 130, 25);
        panel.add(Scode);
        SortCode = new JTextField(20);
        SortCode.setBounds(150, 80, 190, 25);
        panel.add(SortCode);

        Acnum = new JLabel("AccountNumber");
        Acnum.setBounds(10, 110, 130, 25);
        panel.add(Acnum);
        AccNum = new JTextField(20);
        AccNum.setBounds(150, 110, 190, 25);
        panel.add(AccNum);

        Generate = new JButton("Generate");
        Generate.setBounds(10, 150, 130, 25);
        Generate.addActionListener(new IBANGEN());
        panel.add(Generate);
        IBANTEXT = new JTextField(20);
        IBANTEXT.setBounds(150, 150, 190, 25);
        panel.add(IBANTEXT);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*Checkdigit Calculation*/
        String FinalVal;
        /*Bic Mapping*/
        BicConsol = Mapping(CountryCode.getText());
        /*Country Mapping*/
        ConConsol = Mapping(BBCode.getText());
        FinalVal = BicConsol + (SortCode.getText()) + (AccNum.getText()) + ConConsol + "00";
        BigInteger bInt = new BigInteger(FinalVal);
        int Modfind = 98;
        int Diffval = 97;
        BigInteger Modfind_Bint = BigInteger.valueOf(Modfind);
        BigInteger Diffval_Bint = BigInteger.valueOf(Diffval);
        BigInteger Reminder = bInt.mod(Modfind_Bint);
        BigInteger Checkdigit = Diffval_Bint.subtract(Reminder);
        String IBAN = Checkdigit.toString();

        /*FINAL IBAN CONCATINATION*/
        String GenerateIban = CountryCode.getText().toUpperCase() + IBAN + BBCode.getText().toUpperCase() + SortCode.getText() + AccNum.getText();
        IBANTEXT.setText(GenerateIban);
    }

    /* Creating HashTable for keymapping */
    public int HashMapMethod(String Value) {
        HashMap<String, Integer> ConCodeMap = new HashMap<String, Integer>();
        ConCodeMap.put("A", 10);
        ConCodeMap.put("B", 11);
        ConCodeMap.put("C", 12);
        ConCodeMap.put("D", 13);
        ConCodeMap.put("E", 14);
        ConCodeMap.put("F", 15);
        ConCodeMap.put("G", 16);
        ConCodeMap.put("H", 17);
        ConCodeMap.put("I", 18);
        ConCodeMap.put("J", 19);
        ConCodeMap.put("K", 20);
        ConCodeMap.put("L", 21);
        ConCodeMap.put("M", 22);
        ConCodeMap.put("N", 23);
        ConCodeMap.put("O", 24);
        ConCodeMap.put("P", 25);
        ConCodeMap.put("Q", 26);
        ConCodeMap.put("R", 27);
        ConCodeMap.put("T", 28);
        ConCodeMap.put("S", 29);
        ConCodeMap.put("U", 30);
        ConCodeMap.put("V", 31);
        ConCodeMap.put("W", 32);
        ConCodeMap.put("X", 33);
        ConCodeMap.put("Y", 34);
        ConCodeMap.put("Z", 35);
        int Mapvalue = ConCodeMap.get(Value);
        return Mapvalue;
    }

    public StringBuffer Mapping(String Map) {
        StringBuffer output = new StringBuffer(110);
        StringBuffer MappedValue = new StringBuffer(110);
        String BCOD = Map.toUpperCase();
        for (int i = 0; i < BCOD.length(); i++) {
            Character ParseBic = BCOD.charAt(i);
            String New = ParseBic.toString();
            int BicInt = HashMapMethod(New);
            MappedValue = output.append(BicInt);
        }
        return MappedValue;
    }
}
