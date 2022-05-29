package cz.czechitas.lekce9;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {
    private JLabel jmenoLabel;
    private JLabel prijmeniLabel;
    private JLabel adresaLabel;
    private JTextField jmenoField;
    private JTextField prijmeniField;
    private JTextField adresaField;

    private JCheckBox pracovniCheckbox;

    private JRadioButton zenaRadioButton;
    private JRadioButton muzRadioButton;
    private JButton ulozitButton;
    private JButton smazatButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Kontakty");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 4", "[right]rel[50:75:250,grow,fill]unrel[right]rel[50:75:250,grow,fill]"));
        setMinimumSize(new Dimension(400, 200));

        jmenoField = new JTextField();
        jmenoLabel = new JLabel("Jméno");
        jmenoLabel.setDisplayedMnemonic('J');
        jmenoLabel.setLabelFor(jmenoField);
        add(jmenoLabel);
        add(jmenoField);

        prijmeniField = new JTextField();
        prijmeniLabel = new JLabel("Příjmení");
        prijmeniLabel.setDisplayedMnemonic('P');
        prijmeniLabel.setLabelFor(prijmeniField);
        add(prijmeniLabel);
        add(prijmeniField);

        adresaField = new JTextField();
        adresaLabel = new JLabel("Adresa");
        adresaLabel.setDisplayedMnemonic('A');
        adresaLabel.setLabelFor(adresaField);
        add(adresaLabel);
        add(adresaField, "span");

        add(createGenderPanel(), "left, span 2");

        pracovniCheckbox = new JCheckBox("Pracovní kontakt");
        pracovniCheckbox.setMnemonic('r');
        add(pracovniCheckbox, "left, span");

        add(createButtonBar(), "span");

        pack();

        getRootPane().setDefaultButton(ulozitButton);

        ulozitButton.addActionListener(this::handleUlozit);
    }

    private JPanel createGenderPanel() {
        zenaRadioButton = new JRadioButton("žena");
        zenaRadioButton.setMnemonic('z');
        zenaRadioButton.setDisplayedMnemonicIndex(0);

        muzRadioButton = new JRadioButton("muž");
        muzRadioButton.setMnemonic('m');

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(zenaRadioButton);
        genderGroup.add(muzRadioButton);

        JPanel genderPanel = new JPanel();
        genderPanel.add(zenaRadioButton);
        genderPanel.add(muzRadioButton);
        return genderPanel;
    }

    private JPanel createButtonBar() {
        ulozitButton = new JButton("Uložit");
        ulozitButton.setMnemonic('U');

        smazatButton = new JButton("Smazat");
        smazatButton.setMnemonic('S');

        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));
        buttonBar.add(smazatButton);
        buttonBar.add(ulozitButton);
        return buttonBar;
    }


    private void handleUlozit(ActionEvent actionEvent) {
        System.out.println("Ukládám kontakt:");
        System.out.printf("Jméno: %s", jmenoField.getText()).println();
        System.out.printf("Příjmení: %s", prijmeniField.getText()).println();
        System.out.printf("Adresa: %s", adresaField.getText()).println();
        if (zenaRadioButton.isSelected()) {
            System.out.println("žena");
        }
        if (muzRadioButton.isSelected()) {
            System.out.println("muž");
        }
        System.out.printf("Pracovní kontakt: %s", pracovniCheckbox.isSelected() ? "ano" : "ne").println();
    }


}
