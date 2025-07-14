# Projekthandbuch: AusgabenNotizblock




<hr>


## Projektstart & Vorbereitung
1. **Aufgabenstellung und Ziel**
    - Anforderungen genau lesen
    - Wichtige Punkte als eigene Notizen dokumentieren


2. **Projektstruktur**
    - Java-Projekt anlegen
    - Packages für `model`, `dao`, `view`, `controller` (MVC)
    - Handbuch/Markdown-Logbuch führen – offene Todos und Fortschritte notieren


3. **UML-Klassendiagramm**
    - Grob auf Papier oder digital skizzieren
    - Welche Klassen? Methoden? Beziehungen?


<hr>


## Schritt-für-Schritt Umsetzung

### 1. Model-Klasse (z.B. Expense)
- Nur `private` Attribute, für alles Getter (und ggf. Setter)
- Konstruktor: Pflichtwerte + Zeitstempel (`LocalDateTime.now()`)
- Eigene `toString()`-Methode für Debug/Protokoll
- Kategorie ggf. als Enum (später)

### 2. DAO-Klasse (z.B. ExpenseDAO)
- ArrayList für Datensätze + Getter
- Methoden zum **Speichern** (`saveData()`) und **Laden** (`loadData()`) als CSV
- Fehlerhandling (Ordner prüfen/erstellen, Exceptions für Zahlen/Datum abfangen)
- Immer das gleiche CSV-Format verwenden
- `addExpense(Expense expense)`: Fügt Objekt zur Liste hinzu, speichert danach, gibt Erfolg zurück (boolean).
- `getExpenseListAsText()`: Gibt alle Einträge als formatierten String zurück (für Protokollfenster).

### 3. View/GUI (z.B. ExpenseView)
- Layout einfach halten: GridLayout oder BoxLayout, später GridBagLayout
- Jede Zeile (Label + Feld) als eigenes Panel für Flexibilität
- Alle Felder/Buttons privat + Getter
- Methoden für Button-Handler (`addSaveHandler`, `addShowHandler`)
- RadioButtons immer in eine ButtonGroup
- GUI erst grob bauen, dann schrittweise Logik ergänzen
- `showInfoWindow(String msg)`: Zeigt Infofenster nach Erfolg (z.B. „gespeichert“).
- `showErrorWindow(String msg)`: Zeigt Fehlermeldung bei falscher Eingabe.


### 4. Controller
- Holt Eingaben aus View, prüft und konvertiert sie
- Erstellt Model-Objekte, gibt sie an DAO weiter
- Speichert nach jedem Eintrag (`saveData`)
- Zeigt Info-/Fehlerfenster (`JOptionPane`)
- Baut Protokoll-Liste und zeigt sie in der View an
- Alle Logik/Aktion immer im Controller halten!
- `onSaveClick(ActionEvent e)`:
    - Liest Felder aus View.
    - Prüft: Keine Felder leer, Beträge und Datum im richtigen Format.
    - Holt Kategorie (RadioButton isSelected).
    - Ruft DAO `addExpense()` auf.
    - Zeigt Info/Error-Fenster.
    - Leert Felder nach Erfolg.
- `onShowListClick(ActionEvent e)`: Holt Liste als Text und zeigt sie im Infofenster an.
- `getDoubleValueFromText(String text, min, max)`: Prüft Eingabe auf leer/Fehler, ersetzt Komma, wandelt um, prüft Wertebereich.


<hr>


## Testing und Extras

- Nach jedem Schritt testen (auch Einzelmethoden)!
- Für Debug: `System.out.println()` oder `JOptionPane.showMessageDialog()`
- Extras wie **Löschen, Bearbeiten, Filter** erst nach Basis-Funktionen bauen


<hr>


## Tipps für zukünftige Projekte

- Fehlermeldungen immer früh und klar anzeigen
- Kommazahlen: `.replace(",", ".")` nutzen, damit beide Schreibweisen funktionieren
- Datum: Einheitliches Format, klare Eingabeanweisung (z.B. `YYYY-MM-DD`)
- View nie mit Logik überfrachten – nur Anzeige/Eingabe!
- Controller = Herzstück: Hier wird geprüft, verarbeitet, gespeichert


<hr>


## Eigenen Workflow als Checkliste

1. Aufgabenstellung lesen, Handbuch anlegen
2. Model bauen (Felder, Getter, Zeitstempel, toString)
3. DAO bauen (Liste, Speichern, Laden, Fehlerhandling)
4. View bauen (GUI, Panels, Felder, Buttons, ButtonGroup)
5. Controller bauen (Eingaben lesen, prüfen, verarbeiten, speichern, anzeigen)
6. Alles einzeln testen, Fehler dokumentieren
7. Extras (Löschen etc.) zum Schluss
8. Erkenntnisse und Tipps immer ins Handbuch ergänzen