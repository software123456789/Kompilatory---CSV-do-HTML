# Teoria kompilacji i kompilatory
# *Translator plików w formacie CSV na tabele HTML*

# Spis treści
- [Opis projektu](#opis-projektu)
  + [Narzędzia](#narzędzia)
  + [Literatura](#literatura)
  + [Instrukcja instalacji ANTLR dla Windows](#instrukcja-instalacji-antlr-dla-windows)
- [Realizacja projektu](#realizacja-projektu)
  + [Gramatyka dla plików w formacie CSV](#gramatyka-dla-plików-w-formacie-csv)

# Opis projektu
Celem projektu jest projekt i implementacja translatora plików w formacie CSV na tabele HTML. Translator został wykonany zgodnie z architekturą współczesnych interpreterów i translatorów - składa się z lexera i parsera. W wyniku działania lexera i parsera otrzymywane jest drzewo syntaktyczne. Przechodzenie po drzewie pozwala na wykonywanie działań zgodnie z regułami translacji. 


## Narzędzia 

ANTLR (ANother Tool for Language Recognition) - to generator analizatora składni, który używa algorytmu LL (*)
do parsowania języków. https://www.antlr.org/

## Literatura
+ The Definitive ANTLR 4 Reference by Terence Parr

https://pragprog.com/book/tpantlr2/the-definitive-antlr-4-reference

## Instrukcja instalacji ANTLR dla Windows
 1. Pobieramy plik .jar ze strony https://www.antlr.org/download/ - aktualnie najnowsza wersja to antlr-4.8-complete.jar
 2. Pobrany plik umieszczamy w dowolnym katalogu
 3. Klasy z pobranego pliku należy dodać do zmiennej CLASSPATH, tymczasowe dodanie do zmiennej CLASSPATH można zrealizować z linii komend:
 
 ```console
 SET CLASSPATH=.;C:\Users\Dominik\Desktop\Kompilatory\antlr\antlr-4.8-complete.jar;%CLASSPATH%
 ```
 
 4. Sprawdzamy poprawność konfiguracji z linii komend: 
 
 ```console
 java org.antlr.v4.Tool
 ```
 
 5. Wpisywanie takiej komendy za każdym razem byłoby dość męczące więc możemy utworzyć aliasy, na windows robimy to przy pomocy doskey:
 
```console
doskey antlr4=java org.antlr.v4.Tool $*
doskey grun =java org.antlr.v4.gui.TestRig $*
```
TestRig to klasa do testowania wyników wygenerowanych przez klasę Tool, będzie również często używana. 

6. Teraz możemy używać narzędzia przez komendę:

```console
antlr4
```

# Realizacja projektu

## Gramatyka dla plików w formacie CSV 
Pierwszym krokiem jest określenie postaci języka wejściowego dla narzędzia ANTLR. W projekcie definiujemy język dla plików CSV przy użyciu gramatyki w formacie określanym przez ANTLR. Gramatyka jest zapisana w plik z rozszerzeniem .g4.
(Zawartość pliku CSV_Grammar.g4):

```console
grammar CSV

csv_file : header row+;		   // plik csv to naglowek i przynajmniej jeden wiersz
	
header: row;			   // naglowek to pojedynczy wiersz

row: cell (',' cell)* '\n';	   // wiersz to jedna lub wiecej komorek oddzielone przecinkami az do nowej linii

cell: CHARS | ;			   // komorka to ciag znakow, ale moze byc tez pusta

CHARS: ~[,\n]+ ; 		   // cokolwiek co nie jest przecinkiem i nowa linia 
```

