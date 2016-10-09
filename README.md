Better Tests
============

Allgemeines
-----------

Beispiele mit JUnit (Kotlin und Java) und Spock (Groovy). 

Projekt bauen und Tests ausführen: `./gradlew test`

alle Tests aus einem Package ausführen (am Beispiel vom package _ex0_): `./gradlew test --tests "ex0*"`

Testreport anschauen: `open build/reports/tests/index.html`

Ex0: Hello World 
----------------

> Hello World!

mache dich mit der Konfiguration und dem Aufbau eines einfachen Tests vertraut.

- wie bewertet Ihr Lesbarkeit von Tests und Reports?

Ex10: Testfokus (Protagonist)
-----------------------------

> Wer von einer Tragödie erzählen kann, war nicht ihr Held

es sollte leicht nachvollziehbar sein, was im Fokus des Test steht

- kurze Diskussion mit Partner

Ex11: stateful Protagonist
--------------------------

> one test per method?

1 Test pro Methode ist ein Anti-Pattern. Gute Tests bilden
fachliche Zusammenhänge ab. Das umfasst meist mehrere
Methoden. 

- schau dir das Beispiel an und erkenne den Zusammenhang zwischen den beiden
Methoden des getesteten Objekts.

Ex20: Testassertions
--------------------

> Am Ende jeder Geschichte lauert der Drache oder ein Schatz.

Jeder Test geht rot oder grün aus*. Wir unterscheiden zwischen failures und errors.
Im Failure Fall sollte es eine aussagekräftige Fehlermeldung geben (_watch
the test fail_).

- wie bewertest du die Assertion APIs hinsichtlich Fehlermeldung, 
    Lesbarkeit, Erweiterbarkeit und Wiederverwendbarkeit?
  
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

Ex40: Testdaten
---------------

- komplexe Testdaten
- welche Daten sind relevant?


Ex50: listen to the tests
-------------------------

- ist es schlecht zu testen dann ist es vielleicht 
    auch schlecht zu benutzen?
    
Ex60: Integration Tests
-----------------------

>

- funktioniert mein code mit 3rd Party Code, Frameworks, Drittsystemen?

Ex70: Test Environment
----------------------

> every test should have a stage

für den Test benötigte Ressourcen bilden die Kulisse. Gutes Setup
ist vom eingentlichen Test klar getrennt und ggfs. wiederverwendbar




