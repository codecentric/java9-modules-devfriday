# java9-modules-devfriday
DevFriday tryout project with Java 9 modules (Jigsaw)

Note: make sure to download the Jigsaw enabled Java 9 EA build from here;
https://jdk9.java.net/jigsaw/


# Geleerd:
- automatisch detecteren van implementaties op het 'modulepath'
- publieke interfaces moeten expliciet 'exposed' worden
- filenamen jar-files zijn niet van belang, wordt gekeken naar module definitie binnen file
- meerdere versies van zelfde module niet ondersteund als tegelijk op het classpath / modulepath
- 'jlink' commando gebruiken om minimale runtime te bouwen die alleen benodigde modules mee linked
- bij 'jlink' opletten bij modules die anders impliciet mee worden genomen omdat ze op het 'modulepath' staan, worden niet automatisch gelinked
- 'jlink' creert runnable script met de naam van de module, welke onder water standaard 'java' aan roept


# Uitzoeken:
- versies van benodigde modules specificeren. Mogelijk??


# Commands:

    javac -d mods -modulesourcepath src $(find src -name "*.java")

    java -modulepath mods -m nl.codecentric.test/nl.codecentric.test.Main
    java -mp mlib -m nl.codecentric.test

    jar --create --file=mlib/fastsocket@1.0.jar --module-version=1.0 -C mods/nl.codecentric.fastsocket .
    jar --create --file=mlib/socket@1.0.jar --module-version=1.0 -C mods/nl.codecentric.socket .
    jar --create --file=mlib/maintest.jar --main-class=nl.codecentric.test.Main -C mods/nl.codecentric.test .

## Link modules with Java SE modules to create minimum runtime:

Need to add not only 'test' module but also 'fastsocket' or some other module, because there are no direct references.
Otherwise the 'socket' interface will not have any implementations

    jlink --modulepath $JAVA_HOME/jmods:mlib --addmods nl.codecentric.test,nl.codecentric.fastsocket --output target

Will create a minimum Java installation in the 'target' directory.

## Provide -Xdiag:resolver to get information about bindings:

    java -Xdiag:resolver -mp mlib -m nl.codecentric.test
