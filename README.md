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
     + [Docelowy format tabeli HTML](#docelowy-format-tabeli-html)
     + [Opis programu](#opis-programu)
     + [Testowe wykonanie programu](#testowe-wykonanie-programu)
     + [How to run](#how-to-run)

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
 
W celu przetestowania działania parsera zostało wygenerowane drzewo syntaktyczne przy użyciu narzędzia antlr4. Na początku należy wygenerować klasy dla gramatyki przy użyciu narzędzia antlr4 z poziomu linii komend:
```console
antlr4 CSV_Grammar.g4
```
Następnie trzeba skompilować wygenerowane pliki poleceniem:
```console
javac *.java
```
Na koniec wystarczy wygenerować drzewo poleceniem:
```console
java org.antlr.v4.gui.TestRig CSV_Grammar csv_file -tree usernames.csv -gui
```
W powyzszym poleceniu flaga -gui jest opcjonalna lecz przydatna, ponieważ wizualizuje nam drzewo. Bez tej flagi drzewo generowane jest w formie tekstu.

Wygenerowane drzewo syntaktyczne dla gramatyki dla przykładowych danych:
![Drzewo syntaktyczne dla gramatyki](https://i.ibb.co/XXtVx2x/syntactic-tree.png)


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

Przechodzenie po drzewie syntaktycznym jest realizowane przez klasę ParseTreeWalker. Jest to klasa z biblioteki antlr, jako parametr przyjmuje ona obiekt klasy CsvToHtmlTable. CsvToHtmlTable to utworzona w projekcie klasa, która dziedziczy po wygenerowanej przez antlr4 klasie CSV_GrammarBaseListener i nadpisuje niektóre z jej metod. 

Sposób przechodzenia po drzewie opiera się o mechanizm 'listenerów'. Listenery reagują na wydarzenia związane z przechodzeniem po drzewie syntaktycznym. Podstawowe wydarzenia to wejście do danego typu węzła i wyjście z daneg typu węzła.

Przykłady zaimplementowanych listenerów:
```java
@Override
    public void enterCsv_file(CSV_GrammarParser.Csv_fileContext ctx){
        System.out.println("<table>");
    }
```

```java
    @Override
    public void enterCell(CSV_GrammarParser.CellContext ctx) {
        System.out.printf("<td>");
        if(ctx.CHARS().getText() != null){
            System.out.printf(ctx.CHARS().getText());
        } else{
            System.out.printf("");
        }
    }
```

### Testowe wykonanie programu
Dla pliku wejściowego usernames.csv generowany jest fragment HTML zamieszczony poniżej:
```html
<table>
<tr>
<th>Username</th>
<th>Identifier</th>
<th>First name</th>
<th>Last name</th>
</tr>
<tr>
<td>booker12</td>
<td>9012</td>
<td>Rachel</td>
<td>Booker</td>
</tr>
<tr>
<td>grey07</td>
<td>2070</td>
<td>Laura</td>
<td>Grey</td>
</tr>
<tr>
<td>johnson81</td>
<td>4081</td>
<td>Craig</td>
<td>Johnson</td>
</tr>
<tr>
<td>jenkins46</td>
<td>9346</td>
<td>Mary</td>
<td>Jenkins</td>
</tr>
<tr>
<td>smith79</td>
<td>5079</td>
<td>Jamie</td>
<td>Smith</td>
</tr>
</table>
```
![res](https://user-images.githubusercontent.com/39568472/78917202-dc687780-7a8e-11ea-8567-4adf329741ac.PNG)

### How to run

Aby uruchomić program należy dodać do projektu .jar z biblioteką antlr. 

W IntelliJ IDEA: File -> Project Structure -> Libraries -> Add -> Path to .jar

Następnie można uruchomić metodę main z klasy Main. Na standardowe wyjście wypisywana jest tabela HTML utworzona na podstawie danych z pliku usernames.csv.

