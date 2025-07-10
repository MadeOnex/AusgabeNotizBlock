public class Controller {

    private ExpenseDAO expensedao;
    private ExpenseView expenseview;


    public Controller () {
        expensedao = new ExpenseDAO();
        expenseview = new ExpenseView(450, 300, "Ausgabennotizblock");
    }




}

