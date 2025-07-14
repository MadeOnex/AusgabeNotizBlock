import java.io.*;
import java.util.ArrayList;

public class ExpenseDAO {

    private ArrayList<Expense> expenseList;
    private final String SEPARATOR = ";";
    private final String PATH = "data/saveFile.csv";

    public ExpenseDAO() {
        expenseList = loadData();
    }


    public boolean addExpense(int id, String beschreibung, double betrag, String date, String kategorie) {
        Expense expense = new Expense(id, beschreibung, betrag, date, kategorie);
        expenseList.add(expense);
        return false;
    }

    //Zugriff auf Liste
    public ArrayList<Expense> getExpenseList() {
        return expenseList;
    }

    public String getExpenseListAsText() {
        String listString = "";
        String br = "\n";

        for (Expense expense : expenseList) {
            listString += "ID: " + expense.getId() + br;
            listString += "Beschreibung " + expense.getBeschreibung() + br;
            listString += "Betrag: " + expense.getBetrag() + br;
            listString += "Datum: " + expense.getDate() + br;
            listString += "Kategorie: " + expense.getKategorie() + br;
            listString += br + "----------------------------" + br;
        }

        return listString;
    }


    public void saveData() {

        File dir = new File("data");
        if (!dir.exists()) {
            dir.mkdirs();
        }


        FileWriter csv = null; //Filewriter Objekt
        try {
            csv = new FileWriter(PATH);
            for (Expense expense : expenseList) {
                if (expense != null) {
                    String line = expense.getId() + SEPARATOR;
                    line += expense.getBeschreibung() + SEPARATOR;
                    line += expense.getBetrag() + SEPARATOR;
                    line += expense.getDate() + SEPARATOR;
                    line += expense.getKategorie() + SEPARATOR;


                    line += "\n"; //Zeilenumbruch
                    csv.write(line);
                }
            }
        } catch (IOException e) {
            //in der Variable e wird der Fehler angenommen
            System.err.println("IO Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            if (csv != null) {
                try {
                    csv.close();
                } catch (IOException e) {
                    System.err.println("Error" + e.getMessage());
                }
            }
        }

    }

    public ArrayList<Expense> loadData() {
        //Leere Liste Erzeugen
        ArrayList<Expense> tempExpenseList = new ArrayList<>();
        FileReader file = null;
        try {
            file = new FileReader(PATH);
            //Reader zeilenweise lesen
            BufferedReader reader = new BufferedReader(file);
            String line; //solange eine Zeile
            while ((line = reader.readLine()) != null) {
                //Daten als Variable speichern
                String[] data = line.split(SEPARATOR);
                int id = Integer.parseInt(data[0]);
                String beschreibung = data[1];
                double betrag = Double.parseDouble(data[2]);
                String datum = data[3];
                String kategorie = data[4];

                Expense expense = new Expense(id, beschreibung, betrag, datum, kategorie);
                tempExpenseList.add(expense);
            }
        } catch (IOException e) {
            System.out.println("Error:" + e.getMessage());
        }
        return tempExpenseList;
    }


}
