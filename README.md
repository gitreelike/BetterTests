Better Tests
============

Allgemeines
-----------

Beispiele mit JUnit (Kotlin und Java), Spock (Groovy) und jest (JS). 

Projekt bauen und Tests ausführen: `./gradlew check`

alle Tests aus einem Package ausführen (am Beispiel vom package _ex0_): `./gradlew test --tests "ex0*"`

Testreport anschauen: `open build/reports/tests/index.html`

Ex0: Hello World 
----------------

> Hello World!

mache dich mit der Konfiguration und dem Aufbau eines einfachen Tests vertraut.

- wie bewertet Ihr Lesbarkeit von Tests und Reports?

Ex10: Testfokus (Protagonist)
-----------------------------

> Wer von einer Tragödie erzählen kann, war nicht ihr _Held_

es sollte leicht nachvollziehbar sein, wer oder was im Fokus des Test steht

- kurze Diskussion mit Partner

Ex11: stateful Protagonist
--------------------------

> one test per method?

1 Test pro Methode ist ein Anti-Pattern. Gute Tests bilden
fachliche Zusammenhänge ab. Das umfasst meist mehrere
Methoden. 

- schau dir das Beispiel an und erkenne den Zusammenhang zwischen den beiden
Methoden des getesteten Objekts.

Ex12: interaction based testing
-------------------------------

> Object-oriented design is the process of planning a system of interacting 
> objects for the purpose of solving a software problem.

- schau dir im Beispiel verschiedene Methoden an Interaktionen zwischen Objekten zu testen

Ex20: Testassertions
--------------------

> Am Ende jeder Geschichte lauert der Drache oder ein Schatz.

Jeder Test geht rot oder grün aus*. Wir unterscheiden zwischen failures und errors.
Im Failure Fall sollte es eine aussagekräftige Fehlermeldung geben (_watch
the test fail_).

- wie bewertest du die Assertion APIs hinsichtlich Fehlermeldung, 
    Lesbarkeit, Erweiterbarkeit und Wiederverwendbarkeit?

* @Ignore/Test assumptions sind Ausnahmen
  
Ex30: Collaboration
-------------------

> Erst such dir einen Gefährten, dann erst begib dich auf die Reise!

die UnitUnderTest kooperiert typischerweise mit anderen Units. Es gibt 
Gründe diese im Test durch Dummies, Stubs, Fakes und Mocks zu ersetzen.

- bewerte die gezeigten Beispiele bzgl. Nachvollziehbarkeit und Lesbarkeit

Ex31: Overspecified Tests
-------------------------

> overspecified tests tend to be brittle

- öffne _ex31.OverSpecifiedSpec_, dort ist ein (fehlschlagender)
  Test für ein neues Feature. 
- erweitere die Implementierung.
- Bewertung?

Ex32: Bad Mocking
-----------------

> Mock only types you own

- bewerte und diskutiere den Test und die Empfehlung

Ex40: Testdaten
---------------

> komplexe Testdaten

- welche Daten sind relevant? wie gut lässt sich das erkennen?

Ex50: listen to the tests
-------------------------

> ist es schlecht zu testen dann ist es vielleicht 
>    auch schlecht zu benutzen?

- was lässt sich anhand der Tests über den Code aussagen?
- wie kann der Code verändert werden?
- welche Effekte hat das auf den Test?

Ex51: more than one test
------------------------

> keine Kontrollstrukturen in Tests

- parametrisierbare Tests
    
Ex60: Integration Tests
-----------------------

> does it really work?

- funktioniert mein code mit 3rd Party Code, Frameworks, Drittsystemen?

Ex70: Test Environment
----------------------

> every test should have a stage

für den Test benötigte Ressourcen bilden die Kulisse. Gutes Setup
ist vom eingentlichen Test klar getrennt und ggfs. wiederverwendbar

Ex80: Ui Tests mit WebDriver (Geb/Fluentlentium)
------------------------------------------------

funktioniert aktuell nicht in gradle. Ursache unbekannt
