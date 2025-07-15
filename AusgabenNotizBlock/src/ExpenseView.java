import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class ExpenseView extends JFrame {

    private JButton saveBtn, showListBtn, closeBtn;
    private JTextField beschreibungTf, summeTf, dateTf;
    private JRadioButton nahrungBtn, kosmetikBtn, kleidungBtn, sonstBtn;
    private JTextField idTf = new JTextField(6);
    private JButton deleteBtn = new JButton("Delete");
    private JDialog protokollDialog;

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

    public JRadioButton getKosmetikBtn() { return kosmetikBtn; }

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


    //Fenster fasst daten Übersichtlich ein mit Grid
    public void showMsgDialog(String beschreibung, double betrag, String date, String kategorie, String zeitStamp) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,2,5,5));
        //panel.setBorder(new EmptyBorder(5,5,5,5));

        panel.add(new JLabel("Beschreibung:"));
        panel.add(new JLabel(beschreibung));

        panel.add(new JLabel("Summe:"));
        panel.add(new JLabel(String.format("%.2f €", betrag)));

        panel.add(new JLabel("Datum:"));
        panel.add(new JLabel(date));

        panel.add(new JLabel("Kategorie:"));
        panel.add(new JLabel(kategorie));

        panel.add(new JLabel("Zeitstempel:"));
        panel.add(new JLabel(zeitStamp));

        JOptionPane.showMessageDialog(this, panel, "Ausgabeerfassung erfolgreich", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showProtokoll (List<Expense> ausgaben) {

        //Ausrichtung
        JPanel hauptPanel = new JPanel(new BorderLayout());
        JPanel tabellenPanel = new JPanel(new GridLayout(0, 6));


        // Überschrift
        tabellenPanel.add(new JLabel("<html><b>ID</b><br><hr></html>"));
        tabellenPanel.add(new JLabel("<html><b>Beschreibung</b><br><hr></html>"));
        tabellenPanel.add(new JLabel("<html><b>Summe</b><br><hr></html>"));
        tabellenPanel.add(new JLabel("<html><b>Datum</b><br><hr></html>"));
        tabellenPanel.add(new JLabel("<html><b>Kategorie</b><br><hr></html>"));
        tabellenPanel.add(new JLabel("<html><b>Zeitstempel</b><br><hr></html>"));

        // Eintrag
        for (Expense expense : ausgaben) {
            tabellenPanel.add(new JLabel(String.valueOf(expense.getId())));
            tabellenPanel.add(new JLabel(expense.getBeschreibung()));
            tabellenPanel.add(new JLabel(String.format("%.2f", expense.getBetrag())));
            tabellenPanel.add(new JLabel(String.valueOf(expense.getDate())));
            tabellenPanel.add(new JLabel(expense.getKategorie()));
            tabellenPanel.add(new JLabel(expense.getTimestamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm 'Uhr'"))));
        }

        hauptPanel.add(tabellenPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(new JLabel("ID:"));
        buttonPanel.add((idTf));
        buttonPanel.add(deleteBtn);
        hauptPanel.add(buttonPanel, BorderLayout.SOUTH);

//        JOptionPane.showMessageDialog(this, hauptPanel, "Protokoll aller Ausgaben", JOptionPane.PLAIN_MESSAGE);
        if (protokollDialog != null && protokollDialog.isShowing()) {
            protokollDialog.dispose();
        }
        protokollDialog = new JDialog(this, "Protokoll aller Ausgaben", true);
        protokollDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        protokollDialog.setContentPane(hauptPanel);
        protokollDialog.pack();
        protokollDialog.setLocationRelativeTo(this);
        protokollDialog.setVisible(true);
    }

    public void addDeleteHandler (ActionListener listener) {
        deleteBtn.addActionListener(listener);
    }

    public JTextField getIdTf() {
        return idTf;
    }
}
