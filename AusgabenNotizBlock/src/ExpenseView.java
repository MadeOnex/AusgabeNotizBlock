import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ExpenseView extends JFrame {

    private JButton saveBtn, showListBtn;
    private JTextField beschreibungTf, summeTf, dateTf;
    private JRadioButton nahrungBtn, kosmetikBtn, kleidungBtn, sonstBtn;

    public ExpenseView ( int width, int height, String windowTitle) {
        setTitle(windowTitle);
        createUserInterface(width, height);

    }

    private void createUserInterface(int width, int height) {
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Panel Gruppieren, Button Erstellen
        JPanel bottomPanel = new JPanel();
        add(bottomPanel, BorderLayout.SOUTH);

        saveBtn = new JButton("Save");
        showListBtn = new JButton("Protokoll anzeigen");
        bottomPanel.add(saveBtn);
        bottomPanel.add(showListBtn);

        add(bottomPanel); // Add für Fenster


        //Grid Layout
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(6, 2, 10,10));
        topPanel.setBorder(new EmptyBorder(5,5,5,5));
        add(topPanel, BorderLayout.NORTH);

        //Gruppierugn Bezeichnung + Textfield
        JLabel beschreibungLabel = new JLabel("Beschreibung:");
        beschreibungTf = new JTextField();
        topPanel.add(beschreibungLabel);
        topPanel.add(beschreibungTf);

        JLabel summeLabel = new JLabel("Summe:");
        summeTf = new JTextField();
        topPanel.add(summeLabel);
        topPanel.add(summeTf);

        JLabel datumLabel = new JLabel("Datum:");
        dateTf = new JTextField();
        topPanel.add(datumLabel);
        topPanel.add(dateTf);

        //Radio Button
        JLabel katLabel = new JLabel("Kategorie");
        topPanel.add(katLabel);

        topPanel.add(new JLabel("")); // Platzhalter wegen RadioButtons in einer Reihe

        nahrungBtn = new JRadioButton("Nahrung");
        topPanel.add(nahrungBtn);

        kosmetikBtn = new JRadioButton("Kosmetik");
        topPanel.add(kosmetikBtn);

        kleidungBtn = new JRadioButton("Kleidung");
        topPanel.add(kleidungBtn);

        sonstBtn = new JRadioButton("Sonstiges");
        topPanel.add(sonstBtn);

        //Radio Btn Group wegen eine Auswahl
        ButtonGroup kategorieGroup = new ButtonGroup();
        kategorieGroup.add(nahrungBtn);
        kategorieGroup.add(kosmetikBtn);
        kategorieGroup.add(kleidungBtn);
        kategorieGroup.add(sonstBtn);



        //Visible
        setVisible(true);
    }


    // Getter Textfield


    public JTextField getDateTf() {
        return dateTf;
    }

    public JTextField getBeschreibungTf() {
        return beschreibungTf;
    }

    public JTextField getSummeTf() {
        return summeTf;
    }

    public JRadioButton getNahrungBtn() {
        return nahrungBtn;
    }

    public JRadioButton getKosmetikBtn() {
        return kosmetikBtn;
    }

    public JRadioButton getKleidungBtn() {
        return kleidungBtn;
    }

    public JRadioButton getSonstBtn() {
        return sonstBtn;
    }

    //Handler Button
    public void addSaveHandler (ActionListener listener) {
        saveBtn.addActionListener(listener);
    }

    public void addShowHandler (ActionListener listener) {
        showListBtn.addActionListener(listener);
    }

    //Info, Error Windows
    public void showErrorWindow(String message) {
        JOptionPane.showMessageDialog(this, message, "Fehler", JOptionPane.ERROR_MESSAGE);
    }

    public void showInfoWindow(String message) {
        JOptionPane.showMessageDialog(this, message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean showConfirmWindow(String message) {
        return JOptionPane.showConfirmDialog(this, message,"Bestätigen", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION;
    }


}
