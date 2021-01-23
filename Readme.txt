===========================================================================================================================================
UHRENSPIEL - VERSION 1.0 / 22.01.2020
===========================================================================================================================================

SOFTWARE DESIGN & ENTWICKLUNG
----------------------------------------------------
- Tina Kolbe, Zürich / CH
- Oliver Piert, Langnau am Albis / CH


QUELLCODE
-----------------
Link GitHub: https://github.zhaw.ch/piertoli/Uhrenspiel.git


SPIELBESCHREIBUNG
-----------------------------
Kinder im Alter zwischen ca. 4 und 7 Jahren sollen mit dem Uhrenspiel das Lesen des analogen Uhrblattes auf spielerische Art erlernen können. Dafür stehen verschiedene 
Levels zur Verfügung um die Uhrzeiten für volle-, halbe- und viertel-Stunde mit zwei Aufgabenmodi Multiple-Choice sowie manuelle Zeiteingabe zu lernen. 

Profis können im Expertenmodus zeigen, dass sie die Uhr lesen können. Als Starthilfe stehen dem Spieler zwei weitere Funktionen zur Verfügung. Im Lernmodus kann der 
Spieler die verschiedenen Uhrzeiten mit den ent-sprechenden Uhrenbildern lernen und das Tutorial zeigt auf einfache Weise, wie das Uhrenspiel gespielt wird. 


FEATURES ÜEBERSICHT
--------------------------------
Spielmodi			Spiel Hilfen		Weitere Funktionen
- Level 1 – Volle Stunde		- Tutorial			- Spiel Speichern
- Level 2 – Halbe Stunde		- Lernmodus		- Spiel Laden
- Level 3 – Viertel Stunde		
- Level 4 –Level 1-3 gemischt		
- Expertenmodus			


SOFTWARE ENTWICKLUNG & KLASSENARCHITEKTUR
-------------------------------------------------------------------------
Die Klassenarchitektur wurde mit Hilfe von CRC-Karten und Durchspielen von Anwendungsfällen entwickelt. Dieses Vorgehen hat sich sehr gut bewährt, da das 
Zusammenspiel der Klassen wie ursprünglich entworfen funktioniert.

Die Softwarearchitektur wurde konsequent in den drei Ebenen Presentation Layer (GUI Elemente), Domain Layer (Spielelogik & Ablauf) und Persistenz Layer 
(unterstützende Funktionen) umgesetzt (siehe Bild rechts). Im Presentation Layer steuert die «MainGUI» Klasse die Erstellung von allen Screens im Spiel und wird von 
verschiedenen spezialisierten GUI-Klassen erweitert um die entsprechenden Screens darzustellen.


TESTING & BEKANNTE FEHLER
------------------------------------------
Das Uhrenspiel enthält für den Domain Layer, daher die Spielelogik & Ablauf, umfassende automatisierte Unit-Tests welche die korrekte Funktionsweise des Spiels 
sicherstellen. Weiter wurde das Spiel mit Testspieler im Rahmen von User Acceptance Tests extensiv getestet und dabei identifizierte Fehler im Spiel behoben.

Zum Zeitpunkt des Releases der Version 1.0 am 22.01.2020 bestehen keine bekannten Fehler im Uhrenspiel.


MÖGLICHE WITERENTWICKLUNGEN
--------------------------------------------------
Das Uhrenspiel wurde mit dem "Model - View - Controller" Prinzip so entworfen, dass Erweiterungen einfach in das bestehende Spiel integriert werden können.

Ideen für mögliche Erweiterungen des Uhrenspiels wären zum Beispiel:
> Integration von Musik und Soundeffekten
> Sprachausgabe zur Ansage der jeweiligen Uhrzeit
> Weiterer Antwortenmodus mit Zuordnung verschiedener Uhrzeiten
> Zweispielermodus
> Bestenliste


© COPYRIGHT 2020 - URHEBERRECHTSHINWEIS
-------------------------------------------------------------------
Der Quellcode dieses Uhrenspiels ist urheberrechtlich geschützt.

Das Urheberrecht liegt bei Tina Kolbe und Oliver Piert. Bitte fragen Sie uns, falls Sie Inhalte dieses Spiels weiterentwickeln oder verändern möchten.
Die Weiterverbreitung dieses Uhrenspiels für nicht-kommerzielle Zwecke ist gestattet.

Zürich, 22. Januar 2021
Autoren: Oliver Piert & Tina Kolbe

===========================================================================================================================================