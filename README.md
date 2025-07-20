# AusgabenNotizblock

**AusgabenNotizblock** ist eine einfache Java-Swing-Anwendung zur Verwaltung persönlicher Ausgaben.  
Sie ist als Übungsprojekt für das MVC-Pattern und Datei-Speicherung entstanden.

---

## Features

- Erfassen von Ausgaben mit Beschreibung, Betrag, Datum, Kategorie
- 5 vordefinierte Kategorien (Freizeit, Nahrung, Kosmetik, Kleidung, Sonstiges)
- Jede Ausgabe erhält automatisch einen Zeitstempel (Erstellungszeit)
- Speicherung und Laden der Ausgaben als CSV-Datei (`data/saveFile.csv`)
- Übersichtliches Protokoll aller Ausgaben (tabellarische Anzeige)
- Einzelne Ausgaben lassen sich gezielt über die ID löschen
- Benutzerfreundliche Oberfläche (Swing, Grid-/BorderLayout)

---

## Screenshots

*Hauptansicht zur Eingabe neuer Ausgaben*

<img width="437" height="292" alt="grafik" src="https://github.com/user-attachments/assets/92d42b6f-0edf-4caf-b276-f88aec13ff93" />


*Protokoll-Fenster mit Löschfunktion*

<img width="748" height="140" alt="grafik" src="https://github.com/user-attachments/assets/7cf94925-c26f-41c5-a8c2-e90191012c33" />


---

## Installation & Nutzung

1. Projekt clonen oder ZIP herunterladen:
    ```
    git clone https://github.com/MadeOnex/AusgabeNotizBlock/tree/main
    ```
2. In deiner IDE öffnen (z.B. IntelliJ oder Eclipse)
3. Das Projekt kompilieren & ausführen (`Main.java`)
4. Die App legt die Datei `data/saveFile.csv` automatisch an  
   (ggf. `data`-Ordner selbst erstellen, falls nicht vorhanden)
5. Neue Ausgaben erfassen und speichern

---

## Bedienung

- **Beschreibung, Summe, Datum und Kategorie** ausfüllen
- Mit **Speichern** hinzufügen
- Über **Protokoll anzeigen** das Ausgabenprotokoll öffnen
- Zum Löschen: Im Protokoll die ID eingeben und auf "Delete" klicken

---

## Projektstruktur

- `src/Expense.java` — Model-Klasse (Ausgabe-Datensatz)
- `src/ExpenseDAO.java` — Datenzugriff & Datei-Speicherung
- `src/ExpenseView.java` — Benutzeroberfläche
- `src/Controller.java` — Steuert die Aktionen (MVC)
- `src/Main.java` — Startpunkt

---

## Hinweise

- Das Projekt speichert nur lokal (kein Cloud-/Netzwerk-Support)
- Die Oberfläche basiert komplett auf Java Swing
- Zeitstempel bleiben auch nach Neustart/Neuladen erhalten

---

## Lizenz

MIT License

---

## Autor 


- MadeOnex https://github.com/MadeOnex

---

