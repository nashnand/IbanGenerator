package Iban;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class IBANGEN extends BICandCountryMapping {

    public static JLabel CountryCodeLabel;
    public static JTextField CountryCodeTextBox;
    public static JLabel SortCodeLabel;
    public static JTextField SortCodeTextBox;
    public static JLabel BICLabel;
    public static JTextField BICTextBox;
    public static JLabel AccountNumberLabel;
    public static JTextField AccountNumberTextBox;
    public static JButton GenerateButton;
    public static JTextField GenratedIBANTextBox;
    public static JButton ResetButton;

    public static JLabel Errorlabel;

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame("IBAN CALCULATOR");
        JPanel panel = new JPanel();
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        CountryCodeLabel = new JLabel("CountryCode");
        CountryCodeLabel.setBounds(10, 20, 130, 25);
        panel.add(CountryCodeLabel);
        CountryCodeTextBox = new JTextField(50);
        CountryCodeTextBox.setBounds(150, 20, 190, 25);
        CountryCodeTextBox.setToolTipText("*Enter only Character");
        CountryCodeTextBox.addKeyListener(new CountryCodeValidation());
        panel.add(CountryCodeTextBox);

        BICLabel = new JLabel("BIC");
        BICLabel.setBounds(10, 70, 130, 25);
        panel.add(BICLabel);
        BICTextBox = new JTextField(20);
        BICTextBox.setBounds(150, 70, 190, 25);
        BICTextBox.setToolTipText("Enter BIC");
        panel.add(BICTextBox);

        SortCodeLabel = new JLabel("Sort Code");
        SortCodeLabel.setBounds(10, 120, 130, 25);
        panel.add(SortCodeLabel);
        SortCodeTextBox = new JTextField(20);
        SortCodeTextBox.setBounds(150, 120, 190, 25);
        SortCodeTextBox.setToolTipText("*Enter only Numeric Values");
        /*SortCodeTextBox.addKeyListener(new ButtonListener.IntegerValidation());*/
        SortCodeTextBox.addKeyListener(new SortIntegerValidation());
        panel.add(SortCodeTextBox);

        AccountNumberLabel = new JLabel("AccountNumber");
        AccountNumberLabel.setBounds(10, 170, 130, 25);
        panel.add(AccountNumberLabel);
        AccountNumberTextBox = new JTextField(20);
        AccountNumberTextBox.setBounds(150, 170, 190, 25);
        AccountNumberTextBox.setToolTipText("*Enter only Numeric Values");
        AccountNumberTextBox.addKeyListener(new AccountNumberValidation());
        panel.add(AccountNumberTextBox);

        Errorlabel = new JLabel();
        Errorlabel.setBounds(150, 200, 300, 20);
        Errorlabel.setForeground(Color.red);
        Errorlabel.setFont(new Font("Serif", Font.PLAIN, 12));


        GenerateButton = new JButton("Generate IBAN");
        GenerateButton.setBounds(10, 220, 130, 25);
        GenerateButton.addActionListener(new GenerateButton());
        panel.add(GenerateButton);
        GenratedIBANTextBox = new JTextField(20);
        GenratedIBANTextBox.setBounds(150, 220, 190, 25);
        panel.add(GenratedIBANTextBox);

        ResetButton = new JButton("Reset");
        ResetButton.setBounds(10, 270, 330, 25);
        ResetButton.addActionListener(new ResetButton());
        panel.add(ResetButton);

        BufferedImage img = ImageIO.read(new File("C:\\GITPROJ\\IbanGenerator\\src\\main\\resources\\iban.png"));
        frame.setIconImage(img);
        frame.setVisible(true);

    }
}