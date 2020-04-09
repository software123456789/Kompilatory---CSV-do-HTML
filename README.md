# Teoria kompilacji i kompilatory
# *Translator plików w formacie CSV na tabele HTML*

# Spis treści
- [Opis projektu](#opis-projektu)
  + [Narzędzia](#narzędzia)
  + [Literatura](#literatura)
  + [Instrukcja instalacji ANTLR dla Windows](#instrukcja-instalacji-antlr-dla-windows)
- [Realizacja projektu](#realizacja-projektu)
   * [Część 1 gramatyka](#część-1-gramatyka)
     + [Rozpatrywany format danych](#rozpatrywany-format-danych)
     + [Gramatyka dla plików w formacie CSV](#gramatyka-dla-plików-w-formacie-csv)
   * [Część 2 lexer i parser](#część-2-lexer-i-parser)
     + [Generacja lexera i parsera](#generacja-lexera-i-parsera)
     + [Testy działania lexera](#testy-działania-lexera)
     + [Testy działania parsera](#testy-działania-parsera)
   * [Część 3 konwersja csv do html](#część-3-konwersja-csv-do-html)
     + [Format tabeli HTML](#format-tabeli-html)

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

## Część 1 gramatyka
Pierwszym krokiem jest określenie postaci języka wejściowego dla narzędzia ANTLR. W projekcie definiujemy język dla plików CSV przy użyciu gramatyki w formacie określanym przez ANTLR. Gramatyka jest zapisana w pliku z rozszerzeniem .g4.

### Rozpatrywany format danych
CSV to format przechowywanie danych w plikach tekstowych. Istnieje wiele implementacji standardu CSV. W naszym projekcie zakładamy, że:
+ Rekordy oddzielane są znakiem nowej linii (również ostatni wiersz musi zawierać znak nowej linii)
+ Pola oddzielane są przecinkiem
+ Pole może zawierać dowolny ciąg znaków lub być puste
+ Pierwszy wiersz pliku to nagłówek zawierający opisy kolumn

Przykład danych zgodnych z powyższym opisem (plik usernames.csv): 

*Username,Identifier,First name,Last name*

*booker12,9012,Rachel,Booker*

*grey07,2070,Laura,Grey*

*johnson81,4081,Craig,Johnson*

*jenkins46,9346,Mary,Jenkins*

*smith79,5079,Jamie,Smith*




### Gramatyka dla plików w formacie CSV 
(Zawartość pliku CSV_Grammar.g4):

```console
grammar CSV_Grammar;

csv_file: header_row row+;			 // plik csv to naglowek i przynajmniej jeden wiersz
	
header_row: cell_header (',' cell_header)* '\n'; // naglowek to jedna lub wiecej komorek naglowka oddzielone przecinkami az do nowej linii

row: cell (',' cell)* '\n';	                 // wiersz to jedna lub wiecej komorek oddzielone przecinkami az do nowej linii

cell_header: CHARS | ;	                         // komorka naglowka to ciag znakow, ale moze byc tez pusta

cell: CHARS | ;		                         // komorka to ciag znakow, ale moze byc tez pusta

CHARS: ~[,\n]+ ; 	                         // cokolwiek co nie jest przecinkiem i nowa linia 
```
## Część 2 lexer i parser
Kolejnym krokiem jest wygenerowanie lexera oraz parsera na podstawie pliku z gramatyką.

### Generacja lexera i parsera
Możemy to zrobić z linii komend:
```console
antlr4 CSV_Grammar.g4
```
W efekcie generowane jest kilka plików, najważniejsze to:
+ CSV_GrammarLexer.java - zawiera implementację lexera dla gramatyki, plik ten zawiera reguły, które przekształcają słowa wejściowe na tokeny, tokeny zapisane są w gramatyce jako reguły rozpoczynające się dużymi literami lub jako symbole w apostrofach
+ CSV_GrammarParser.java - zawiera implementację parsera dla gramatyki, plik ten zawiera reguły, które przekształcają tokeny wejściwe w drzewo syntaktyczne zgodnie z produkcjami zapisanymi w gramatyce (produkcje to reguły zaczynające się od małych liter) 
+  CSV_GrammarListener, CSVGrammarBaseListener - to interfejs i klasa, które umożliwiają przechodzenie po drzewie syntaktycznym poprzez mechanizm listenerów (analogia do reagowania na akcje użytkownika w GUI)

### Testy działania lexera

### Testy działania parsera

## Część 3 konwersja csv do html

### Docelowy format tabeli HTML

### Opis programu

W programie używane są klasy, które zostały wygnerowane przez narzędzie antlr4 z poziomu linii komend:
```console
antlr4 CSV_Grammar.g4
```
Wykonanie tego polecenia powoduje generacje lexera, parsera oraz klas i interfejsów pozwalających na przechodzenie po drzewie syntaktycznym. 

+ Określenie danych wejściowych
```java
        CharStream codePointCharStream = null; 

        try {
            codePointCharStream = CharStreams.fromFileName("usernames.csv"); // plik csv z danymi 
        } catch (IOException e) {
            System.out.println("File char stream not found.");
            e.printStackTrace();
        }
```
+ Utworzenie lexera i parsera
```java
	CSV_GrammarLexer csv_grammarLexer = new CSV_GrammarLexer(codePointCharStream);

        CommonTokenStream commonTokenStream = new CommonTokenStream(csv_grammarLexer);

        CSV_GrammarParser csv_grammarParser = new CSV_GrammarParser(commonTokenStream);
```

+ Utworzenie drzewa syntaktycznego
```java
	ParseTree parseTree = csv_grammarParser.csv_file();
```

+ Przechodzenie po wygenerowanym drzewie
```java	
	ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
	parseTreeWalker.walk(new CsvToHtmlTable(), parseTree);
```

### How to run

