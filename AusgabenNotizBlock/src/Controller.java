import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Controller {

    private ExpenseDAO expensedao;
    private ExpenseView expenseview;


    public Controller() {
        expensedao = new ExpenseDAO();
        expenseview = new ExpenseView(450, 300, "Ausgabennotizblock");
        expenseview.addSaveHandler(this::onSaveClick);
        expenseview.addShowHandler(this::onShowList);

    }

    private void onSaveClick(ActionEvent event) {

        String beschreibung = expenseview.getBeschreibungTf().getText();
        String datumText = expenseview.getDateTf().getText();
        String summeText = expenseview.getSummeTf().getText();

        // Kein Feld leer bleiben
        if (beschreibung.isEmpty() || summeText.isEmpty() || datumText.isEmpty()) {
            JOptionPane.showMessageDialog(expenseview, "Bitte alle Felder Ausfüllen!");
            return;
        }
        double betragText = getDoubleValueFromText(expenseview.getSummeTf().getText(), 0, 99999); // Min 0, Max 999

        //Datum Format
        LocalDate date;
        try {
            date = LocalDate.parse(datumText); //Spezifisches Format
        } catch(Exception e) {
            JOptionPane.showMessageDialog(expenseview, "Datum im Format yyyy-MM-dd eingeben");
            return;
        }

        //Radio Button
        String kategorie = "";
        if (expenseview.getNahrungBtn().isSelected()) {
            kategorie = "Nahrung";
        } else if (expenseview.getKleidungBtn().isSelected()) {
            kategorie = "Kleidung";
        } else if (expenseview.getKosmetikBtn().isSelected()) {
            kategorie = "Kosmetik";
        } else if (expenseview.getSonstBtn().isSelected()) {
            kategorie = "Sonstiges";
        }

        if (kategorie.isEmpty()) {
            JOptionPane.showMessageDialog(expenseview, "Bitte eine Kategorie auswählen");
            return;
        }


        int id = expensedao.getExpenseList().size() + 1;
        expensedao.addExpense(id, beschreibung, betragText, date, kategorie);
        System.out.println(event.getActionCommand());
        expensedao.saveData();

        expenseview.showMsgDialog(
                beschreibung,
                betragText,
                date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                kategorie,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd, HH:mm 'Uhr'"))
        );

        //Felder Leeren
        expenseview.getBeschreibungTf().setText("");
        expenseview.getSummeTf().setText("");
        expenseview.getDateTf().setText("");
    }

    public void onShowList(ActionEvent event) {
        System.out.println("Liste Anzeigen");
        List<Expense> list = expensedao.getExpenseList();
        expenseview.showProtokoll(list);
    }


    // Min max Zuordnen und fehler wenn Komma
    private double getDoubleValueFromText(String text, double min, double max) {
        double value = 0;
        text = text.trim().replace(",", ".");

        try {
            value = Double.parseDouble(text);
            if (value > max || value < min) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            expenseview.showErrorWindow("Bitte eine gültige Kommazahl eingeben.");
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            expenseview.showErrorWindow("Keine Gültige Ausgabe: Wert außerhalb des Bereichs.");
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return value;
    }


}

