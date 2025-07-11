# Projekthandbuch: AusgabenNotizblock

<hr>

## Aufgabenübersicht
### **10.07.2025**
- [x] Projekt erstellt
- [x] Packages erstellt
- [x] Model-Klasse Expense fertigstell
- [x] Controller Erstellen
- [x] ExpenseDAO, expenseView Erstellt
- [x] Liste, loadData / saveData Anlegen
- [X] Testen ob Datei ersteltl wird
- [x] Erstelle View
- [x] View mit GridLayout und BorderLayout gebaut
- [x] Radiobuttons für Kategorien (mit ButtonGroup)
- [x] Getter für alle Felder in View angelegt
- [x] Methoden für Button-Handler in View angelegt (addSaveHandler, addShowHandler)

<hr>

## Todos
- [ ] Button "Speichern" mit Funktion belegen (Daten auslesen, Expense anlegen, speichern)
- [ ] Button "Protokoll anzeigen" mit Funktion belegen (Liste auslesen, Infofenster anzeigen)
- [ ] Infofenster "Ausgabe gespeichert" (JOptionPane.showMessageDialog)
- [ ] Infofenster "Protokoll" (JOptionPane oder neues Fenster/JTextArea)
- [ ] loadData beim Start integrieren, sodass alte Daten angezeigt werden

<hr>

## Notizen/Erkenntnisse
- Enum für Kategorie wäre "strenger" // **Nachschauen Enum**
- Model braucht timestamp (LocalDateTime)
- Für die RadioButtons reicht es, sie später im Controller abzufragen (isSelected)
- Kapselung: Alle Felder private, Zugriff nur über Getter/Setter
- GUI immer erst ohne Funktion aufbauen, dann nach und nach Logik ergänzen
- Mit kleinen Panels kann man GridLayout-Layouts einfach und übersichtlich machen

<hr>

## GUI-Tipps:
- Für einfache GUIs reicht GridLayout, für komplexere später GridBagLayout lernen
- Radiobuttons immer in ButtonGroup, damit nur eine Auswahl möglich ist
- ActionListener für Buttons werden in der View über eigene Methoden angebunden (addXHandler)
- GUI schrittweise aufbauen: Erst sichtbares Layout, dann Funktionalität
- Panels für Übersichtlichkeit gruppieren (unten: Buttons, oben: Felder)

<hr>

### Model-Klasse Expense:
- Beschreibung: String
- Betrag: double
- Datum: LocalDate
- Kategorie: String (für Radiobuttons, einfache Weiterverarbeitung)
- timestamp: LocalDateTime (bei Erstellung gesetzt)
- Getter für alle Felder

### Model-Klasse ExpenseDAO:
- Arraylist erstellen und getter erstellen
- toString WICHTIG!
- saveData erstellen

### GUI/Controller-Teil:
- View bauen (Layout, Felder, Buttons)
- Infofenster (JOptionPane) für Bestätigung und Protokoll
- Buttons per ActionListener mit Controller-Logik verbinden
- Erst speichern/anlegen/anzeigen, danach das Laden der Daten umsetzen
