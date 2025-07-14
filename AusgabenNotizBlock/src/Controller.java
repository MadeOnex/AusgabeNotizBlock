import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;

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
        System.out.println(event.getActionCommand());

        String beschreibung = expenseview.getBeschreibungTf().getText();
        String datumText = expenseview.getDateTf().getText();
        String summeText = expenseview.getSummeTf().getText();

        if (beschreibung.isEmpty() || summeText.isEmpty() || datumText.isEmpty()) {
            JOptionPane.showMessageDialog(expenseview, "Bitte alle Felder Ausfüllen!");
            return;
        }
        double betragText = getDoubleValueFromText(expenseview.getSummeTf().getText(), 0, 999); // Min 0, Max 999


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
        expensedao.addExpense(id, beschreibung, betragText, datumText, kategorie);

        expensedao.saveData();

        //Felder Leeren
        expenseview.getBeschreibungTf().setText("");
        expenseview.getSummeTf().setText("");
        expenseview.getDateTf().setText("");
    }

    public void onShowList(ActionEvent event) {
        System.out.println("Liste Anzeigen");
        String list = expensedao.getExpenseListAsText();
        expenseview.showInfoWindow(list);
    }


    // Min max Zuordnen und fehler wenn Komma
    private double getDoubleValueFromText(String text, double min, double max) {
        double value = 0;

        try {
            value = Double.parseDouble(text);
            if (value > max || value < min) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            expenseview.showErrorWindow("Die Kommazahl muss mit Punkt angegeben werden.");
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            expenseview.showErrorWindow("Keine Gültige Ausgabe.");
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return value;
    }


}

