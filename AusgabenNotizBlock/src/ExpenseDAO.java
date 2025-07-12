import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExpenseDAO {

    private ArrayList<Expense> expenseList;
    private final String SEPARATOR = ";";
    private final String PATH = "data/saveFile.csv";

    public ExpenseDAO() {
        this.expenseList = new ArrayList<>();
    }

    //Zugriff auf Liste
    public ArrayList<Expense> getExpenseList() {
        return expenseList;
    }

    public String getExpenseListAsText() {
        String listString = "";
        String br = "\n";

        for ( Expense expense : expenseList) {
            listString += "ID: " + expense.getId() + br;
            listString += "Beschreibung " + expense.getBeschreibung() + br;
            listString += "Betrag: " + expense.getBetrag() + br;
            listString += "Datum: " + expense.getDate() + br;
            listString += "Kategorie: " + expense.getKategorie() + br;
        }

        return listString;
    }



    public void saveData() {

        FileWriter csv = null; //Filewriter Objekt
        try{
            csv = new FileWriter( PATH );
            for(Expense expense : expenseList ){
                if(expense != null) {
                    String line = expense.getId() + SEPARATOR;
                    line += expense.getBeschreibung() + SEPARATOR;
                    line += expense.getBetrag() + SEPARATOR;
                    line += expense.getDate() + SEPARATOR;
                    line += expense.getKategorie() + SEPARATOR;


                    line += "\n"; //Zeilenumbruch
                    csv.write(line);
                }
            }
        }
        catch( IOException e ){
            //in der Variable e wird der Fehler angenommen
            System.err.println("IO Error: "+ e.getMessage());
        }
        catch( Exception e ){
            System.err.println("Error: "+ e.getMessage());
        }
        finally {
            if (csv != null) {
                try {
                    csv.close();
                } catch( IOException e ) {
                    System.err.println("Error" + e.getMessage() );
                }
            }
        }

    }

    public void loadData() {

    }





}
