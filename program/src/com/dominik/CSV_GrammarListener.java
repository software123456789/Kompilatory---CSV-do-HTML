// Generated from CSV_Grammar.g4 by ANTLR 4.8
package com.dominik;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CSV_GrammarParser}.
 */
public interface CSV_GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CSV_GrammarParser#csv_file}.
	 * @param ctx the parse tree
	 */
	void enterCsv_file(CSV_GrammarParser.Csv_fileContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSV_GrammarParser#csv_file}.
	 * @param ctx the parse tree
	 */
	void exitCsv_file(CSV_GrammarParser.Csv_fileContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSV_GrammarParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(CSV_GrammarParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSV_GrammarParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(CSV_GrammarParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSV_GrammarParser#row}.
	 * @param ctx the parse tree
	 */
	void enterRow(CSV_GrammarParser.RowContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSV_GrammarParser#row}.
	 * @param ctx the parse tree
	 */
	void exitRow(CSV_GrammarParser.RowContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSV_GrammarParser#cell}.
	 * @param ctx the parse tree
	 */
	void enterCell(CSV_GrammarParser.CellContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSV_GrammarParser#cell}.
	 * @param ctx the parse tree
	 */
	void exitCell(CSV_GrammarParser.CellContext ctx);
}