import java.awt.event.ActionEvent;

public class Controller {

    private ExpenseDAO expensedao;
    private ExpenseView expenseview;


    public Controller () {
        expensedao = new ExpenseDAO();
        expenseview = new ExpenseView(450, 300, "Ausgabennotizblock");
    }

    privat void onSaveClick(ActionEvent event) {
        System.out.println(event.getActionCommand());



        expensedao.saveData();
    }

    // Min max Zuordnen und fehler wenn Komma
    private double getDoubleValueFromText (String text, double min, double max) {
        double value = 0;

        try {
            value = Double.parseDouble(text);
            if (value > max || value < min) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            expenseview.
        }
    }



}

