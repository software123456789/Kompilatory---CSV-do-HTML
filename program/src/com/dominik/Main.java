package com.dominik;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;


import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        CharStream codePointCharStream = null;

        try {
            codePointCharStream = CharStreams.fromFileName("usernames.csv");
        } catch (IOException e) {
            System.out.println("File char stream not found.");
            e.printStackTrace();
        }

        CSV_GrammarLexer csv_grammarLexer = new CSV_GrammarLexer(codePointCharStream);

        CommonTokenStream commonTokenStream = new CommonTokenStream(csv_grammarLexer);

        CSV_GrammarParser csv_grammarParser = new CSV_GrammarParser(commonTokenStream);

        ParseTree parseTree = csv_grammarParser.csv_file(); // begin parsing at csv_file rule

//        System.out.println(parseTree.toStringTree(csv_grammarParser));

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();

        parseTreeWalker.walk(new CsvToHtmlTable(), parseTree);

    }
}
