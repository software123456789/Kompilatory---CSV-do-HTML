# Teoria kompilacji i kompilatory
# *Translator plików w formacie CSV na tabele HTML*

# Spis treści
- [Opis projektu](#opis-projektu)
- [Narzędzia](#narzędzia)
- [Gramatyka dla plików w formacie CSV](#gramatyka-dla-plików-w-formacie-csv)

# Opis projektu
Celem projektu jest projekt i implementacja translatora plików w formacie CSV na tabele HTML. 


# Narzędzia 

ANTLR (ANother Tool for Language Recognition) - to generator analizatora składni, który używa algorytmu LL (*)
do parsowania języków. https://www.antlr.org/

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

# Gramatyka dla plików w formacie CSV 
Tutaj będzie gramatyka dla plików CSV..
