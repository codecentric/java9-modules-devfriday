# java9-modules-devfriday
DevFriday tryout project with Java 9 modules (Jigsaw)

Note: make sure to download the Jigsaw enabled Java 9 EA build from here;
https://jdk9.java.net/jigsaw/


# Geleerd:
- automatisch detecteren van implementaties op het 'modulepath'
- publieke interfaces moeten expliciet 'exposed' worden
- filenamen jar-files zijn niet van belang, wordt gekeken naar module definitie binnen file
- meerdere versies van zelfde module niet ondersteund als tegelijk op het classpath / modulepath
-


# Uitzoeken:
- versies van benodigde modules specificeren. Mogelijk??
- beperkte set van 'java' mee linken


# Commands:

    javac -d mods -modulesourcepath src $(find src -name "*.java")

    java -modulepath mods -m nl.codecentric.test/nl.codecentric.test.Main
    java -mp mlib -m nl.codecentric.test

    jar --create --file=mlib/fastsocket@1.0.jar --module-version=1.0 -C mods/nl.codecentric.fastsocket .
    jar --create --file=mlib/socket@1.0.jar --module-version=1.0 -C mods/nl.codecentric.socket .
    jar --create --file=mlib/maintest.jar --main-class=nl.codecentric.test.Main -C mods/nl.codecentric.test .


## Provide -Xdiag:resolver to get information about bindings:

    java -Xdiag:resolver -mp mlib -m nl.codecentric.test
