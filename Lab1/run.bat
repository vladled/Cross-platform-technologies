echo off
:: Set pathes for JDK 
set path=C:\Program Files\Java\jdk1.8.0_181\bin
set include=C:\Program Files\Java\jdk1.8.0_181\include
set lib=C:\Program Files\Java\jdk1.8.0_181\lib
set link=C:\Program Files\Java\jdk1.8.0_181\bin
:: compile java code
javac -version Main.java
:: decompile java app, and saving byte-code in file
javap -c Main > decompailed_Main.txt
:: create docmentation for app
:: javadoc Main.java -d doc\
:: Run compiled app
java Main

pause