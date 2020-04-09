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
    public void enterHeader_row(CSV_GrammarParser.Header_rowContext ctx) {
        System.out.println("<tr>");
    }

    @Override public void exitHeader_row(CSV_GrammarParser.Header_rowContext ctx) {
        System.out.println("</tr>");
    }

    @Override
    public void enterRow(CSV_GrammarParser.RowContext ctx){
        System.out.println("<tr>");
    }

    @Override
    public void exitRow(CSV_GrammarParser.RowContext ctx){
        System.out.println("</tr>");
    }


    @Override public void enterCell_header(CSV_GrammarParser.Cell_headerContext ctx) {
        System.out.printf("<th>");
        if(ctx.CHARS().getText() != null){
            System.out.printf(ctx.CHARS().getText());
        } else{
            System.out.printf("");
        }
    }

    @Override public void exitCell_header(CSV_GrammarParser.Cell_headerContext ctx) {
        System.out.println("</th>");
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
