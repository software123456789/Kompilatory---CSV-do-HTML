package com.dominik;

public class CsvToHtmlTable extends CSV_GrammarBaseListener {

    @Override
    public void enterCsv_file(CSV_GrammarParser.Csv_fileContext ctx){
        System.out.println("<table>");
    }

    @Override
    public void exitCsv_file(CSV_GrammarParser.Csv_fileContext ctx){
        System.out.println("</table>");
    }

    @Override
    public void enterRow(CSV_GrammarParser.RowContext ctx){
        System.out.println("<tr>");
    }

    @Override
    public void exitRow(CSV_GrammarParser.RowContext ctx){
        System.out.println("</tr>");
    }

    @Override
    public void enterCell(CSV_GrammarParser.CellContext ctx) {
        System.out.printf("<td>");
        if(ctx.CHARS().getText() != null){
            System.out.printf(ctx.CHARS().getText());
        } else{
            System.out.printf("");
        }

    }

    @Override
    public void exitCell(CSV_GrammarParser.CellContext ctx) {
        System.out.println("</td>");
    }

}
