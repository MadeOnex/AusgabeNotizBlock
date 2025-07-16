# Thema 16 ( Ausgabennotizblock  )
Das Programm soll Geldausgaben einer Person festhalten. Dazu wird ein Beschreibung (für was Geld ausgegeben wurde), die Summe und das Datum festgehalten.
Weiterhin soll die Geldausgabe in 5 Kategorien eingeteilt werden vom Nutzer: Freizeit, Nahrung, Kosmetik, Kleidung, Sonstiges.
Die Angabe der Kategorien erfolgt via Radio-Button. Die eingegebenen Daten werden anschließend übersichtlich zusammengefasst in einem Infofenster dargestellt.
Zusätzlich erfüllen Sie bitte die Funktionalität der Protokollierung siehe oben ( protokollieren Sie hier Beschreibung, Summe, Kategorie und dazu den jeweiligen Zeitstempel ).

<hr>

## Angaben
Obwohl die Projekte alle unterschiedlich sind, sollen alle Projekte bestimmten Anforderungen folgen. Bitte halten Sie sich an diese Vorgaben!

Es soll unbedingt das Java Swing Framework verwendet werden
Die Oberfläche des Programms soll anwenderfreundlich gestaltet sein (Usability)
Halten Sie die Kapselung strikt ein (keine öffentlichen Attribute, nur Getter und Setter verwenden)

<hr>

## Ihr Projekt soll nur folgende Klassen haben, um bestimmten Designvorgaben zu folgen:

### **~Controller:** <br>
- Übernimmt die Steuerung des Programms als Bindeglied zwischen der Bedienoberfläche und Datenverarbeitung



### **~DataAccessObject:** <br>
- Dient als Bindeglied zur Aufbereitung und Bereitstellung der Daten, welche in einer Liste, die Objekte der Modelklasse enthält, gespeichert sind.<br>
<br>
**Zusätzlich stellt es 2 Methoden zu Verfügung:** <br>
<br>
- LoadData -> lädt gespeicherte Daten als CSV
- SavaData -> speichert die Daten der jeweiligen Berechnung / des Vorgangs als CSV


### **~Modelklasse (zutreffender Name):** <br>
- Speichert je einen Datensatz (aus Berechnung oder Vorgang) und macht den Wert oder die einzelnen Werte die zusammengehören über Getter zugängig wird vom DataAccessObject verwaltet
<br>
* speichert zusätzlich immer den Zeitpunkt der Erstellung des Objekts, in einem Attribut "timestamp" vom Typen LocalDateTime und macht diesen über Getter zugängig


### **~Viewklasse:** <br>
- Stellt die Benutzeroberfläche dar nimmt Eingaben des Benutzers an gibt Ausgaben an den Nutzer aus

<hr>

>Jedes Programm berechnet und erstellt etwas nach Aufgabenbeschreibung und >protokolliert das Ergebnis inkl. Zeitstempel mit Hilfe der Modelklasse<br>
>Das Protokoll der erstellten Daten (auch der gespeicherten Daten) soll per >Button in einem Infofenster angezeigt werden<br>
>Bitte erfüllen Sie zuerst diese obigen Mindestanforderungen und ihre >individuelle Aufgabenstellung. Und geben Sie dann dieses Version  hier auf >Ecampus ab.<br>
>Falls Ihnen dann noch Zeit bleibt, dürfen Sie das Programm gern erweitern >und mir diese 2. Version gern persönlich vorstellen.

>Probieren:
>Fertigen Sie ein UML-Klassendiagramm von ihrem Programm an (bitte nicht >automatisch generiert)

**Umfang: ca. 12 UE**

<hr>

## Aufgabenübersicht
### **10.07.2025**
- [x] Projekt erstellt
- [x] Packages erstellt
- [x] Model-Klasse Expense fertigstellen
- [x] Controller Erstellen
- [x] ExpenseDAO, expenseView Erstellt
- [x] Liste, loadData / saveData Anlegen
- [X] Testen ob Datei erstellt wird
- [x] Erstelle View
- [x] View mit GridLayout und BorderLayout gebaut
- [x] Radiobuttons für Kategorien (mit ButtonGroup)
- [x] Getter für alle Felder in View angelegt
- [x] Methoden für Button-Handler in View angelegt (addSaveHandler, addShowHandler)
- [X] Info, Error, showWindow Erstellen
- [X] Value aus dem Text holen (getValueAsText)
- [X] Button "Speichern" mit Funktion belegen (Daten auslesen, Expense anlegen, speichern)
- [X] Button "Protokoll anzeigen" mit Funktion belegen (Liste auslesen, Infofenster anzeigen)
- [X] onSaveClick einrichten
- [X] loadData einrichten (DAO / Controller)

<hr>

### **14.07.2025**
- [X] Localtime stempel beim Speichern in DAO
- [X] Kein Leeres darf bleiben
- [X] Datum im Format
- [X] ShowConfirmWindow Anpassen
- [X] Protokoll Anpassung, TimeStamp Korrektur, Zweiten Konstruktor(TimeStamp / Ohne)
- [X] TimeStamp Anpassung, Korrektur Auslesen aus Datei, Datum Format anpassung
- [X] Delete,Close Btn Hinzugefügt im Protokoll
- [X] Remove/Delete-Methoden sollten boolean zurückgeben, damit Controller und GUI gezielt auf Erfolg/Misserfolg reagieren können.
- [X] Button, Textfield als Feldvariable anlegen und nur einmal Initialisieren
- [X] Panel nur Erzeugen
- [X] Delete Aktuallisieren kein neues fenster / In showProtokol
- [X] Protokollanzeige mit schließen, delete-Btn, JDialog-Objekt als feld in View nutzen
- [X] Vor jedem Neuzeigen des Protokolls: prüfen, ob ein altes Fenster noch offen ist; falls ja, dispose().
- [X] Protokoll in HTML text Bold, Unterstrichen Übersichtlicher 
- [X] Textfeld leer nach Speichern Löschen


<hr>

Anzeigefenster
-------------------------------------------------------------
|               Ausgabennotizblock                          |
-------------------------------------------------------------
| Beschreibung:  [__________________________]               |
|                                                          |
| Summe (€):     [_________]                               |
|                                                          |
| Datum:         [__.__.____]             |
|                                                          |
| Kategorie:                                               |
|    ( ) Freizeit   ( ) Nahrung   ( ) Kosmetik             |
|    ( ) Kleidung   ( ) Sonstiges                          |
|                                                          |
| [Ausgabe speichern]    [Protokoll anzeigen]              |
-------------------------------------------------------------

nachdem Ausgabe speichern gedrückt wurde
----------------------------------------
|       Ausgabenerfassung erfolgreich!  |
----------------------------------------
| Beschreibung: Einkauf DM             |
| Summe:        19,95 €                |
| Datum:        10.07.2025             |
| Kategorie:    Kosmetik               |
| Zeitstempel:  10.07.2025, 13:28 Uhr  |
----------------------------------------
|                [OK]                  |
----------------------------------------

nachdem Protokoll anzeigen gedrückt wurde
-----------------------------------------------------
|           Protokoll aller Ausgaben                |
-----------------------------------------------------
| Beschreibung | Summe | Kategorie | Zeitstempel     |
|--------------|-------|-----------|-----------------|
| Einkauf DM   | 19,95 | Kosmetik  | 10.07.2025 ...  |
| Bus Ticket   | 2,80  | Freizeit  | 09.07.2025 ...  |
| ...          | ...   | ...       | ...             |
-----------------------------------------------------
|       [Delete]               [Schließen]            |
-----------------------------------------------------
