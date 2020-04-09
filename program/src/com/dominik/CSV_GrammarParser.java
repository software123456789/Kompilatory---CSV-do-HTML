// Generated from CSV_Grammar.g4 by ANTLR 4.8
package com.dominik;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CSV_GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, CHARS=3;
	public static final int
		RULE_csv_file = 0, RULE_header_row = 1, RULE_row = 2, RULE_cell_header = 3, 
		RULE_cell = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"csv_file", "header_row", "row", "cell_header", "cell"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "CHARS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CSV_Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CSV_GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Csv_fileContext extends ParserRuleContext {
		public Header_rowContext header_row() {
			return getRuleContext(Header_rowContext.class,0);
		}
		public List<RowContext> row() {
			return getRuleContexts(RowContext.class);
		}
		public RowContext row(int i) {
			return getRuleContext(RowContext.class,i);
		}
		public Csv_fileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_csv_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSV_GrammarListener ) ((CSV_GrammarListener)listener).enterCsv_file(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSV_GrammarListener ) ((CSV_GrammarListener)listener).exitCsv_file(this);
		}
	}

	public final Csv_fileContext csv_file() throws RecognitionException {
		Csv_fileContext _localctx = new Csv_fileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_csv_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			header_row();
			setState(12); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(11);
				row();
				}
				}
				setState(14); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << CHARS))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Header_rowContext extends ParserRuleContext {
		public List<Cell_headerContext> cell_header() {
			return getRuleContexts(Cell_headerContext.class);
		}
		public Cell_headerContext cell_header(int i) {
			return getRuleContext(Cell_headerContext.class,i);
		}
		public Header_rowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header_row; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSV_GrammarListener ) ((CSV_GrammarListener)listener).enterHeader_row(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSV_GrammarListener ) ((CSV_GrammarListener)listener).exitHeader_row(this);
		}
	}

	public final Header_rowContext header_row() throws RecognitionException {
		Header_rowContext _localctx = new Header_rowContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header_row);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			cell_header();
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(17);
				match(T__0);
				setState(18);
				cell_header();
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RowContext extends ParserRuleContext {
		public List<CellContext> cell() {
			return getRuleContexts(CellContext.class);
		}
		public CellContext cell(int i) {
			return getRuleContext(CellContext.class,i);
		}
		public RowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSV_GrammarListener ) ((CSV_GrammarListener)listener).enterRow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSV_GrammarListener ) ((CSV_GrammarListener)listener).exitRow(this);
		}
	}

	public final RowContext row() throws RecognitionException {
		RowContext _localctx = new RowContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_row);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			cell();
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(27);
				match(T__0);
				setState(28);
				cell();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cell_headerContext extends ParserRuleContext {
		public TerminalNode CHARS() { return getToken(CSV_GrammarParser.CHARS, 0); }
		public Cell_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cell_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSV_GrammarListener ) ((CSV_GrammarListener)listener).enterCell_header(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSV_GrammarListener ) ((CSV_GrammarListener)listener).exitCell_header(this);
		}
	}

	public final Cell_headerContext cell_header() throws RecognitionException {
		Cell_headerContext _localctx = new Cell_headerContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cell_header);
		try {
			setState(38);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHARS:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				match(CHARS);
				}
				break;
			case T__0:
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CellContext extends ParserRuleContext {
		public TerminalNode CHARS() { return getToken(CSV_GrammarParser.CHARS, 0); }
		public CellContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cell; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSV_GrammarListener ) ((CSV_GrammarListener)listener).enterCell(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSV_GrammarListener ) ((CSV_GrammarListener)listener).exitCell(this);
		}
	}

	public final CellContext cell() throws RecognitionException {
		CellContext _localctx = new CellContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cell);
		try {
			setState(42);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHARS:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				match(CHARS);
				}
				break;
			case T__0:
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\5/\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\6\2\17\n\2\r\2\16\2\20\3\3\3\3\3\3"+
		"\7\3\26\n\3\f\3\16\3\31\13\3\3\3\3\3\3\4\3\4\3\4\7\4 \n\4\f\4\16\4#\13"+
		"\4\3\4\3\4\3\5\3\5\5\5)\n\5\3\6\3\6\5\6-\n\6\3\6\2\2\7\2\4\6\b\n\2\2\2"+
		".\2\f\3\2\2\2\4\22\3\2\2\2\6\34\3\2\2\2\b(\3\2\2\2\n,\3\2\2\2\f\16\5\4"+
		"\3\2\r\17\5\6\4\2\16\r\3\2\2\2\17\20\3\2\2\2\20\16\3\2\2\2\20\21\3\2\2"+
		"\2\21\3\3\2\2\2\22\27\5\b\5\2\23\24\7\3\2\2\24\26\5\b\5\2\25\23\3\2\2"+
		"\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31\27\3\2\2"+
		"\2\32\33\7\4\2\2\33\5\3\2\2\2\34!\5\n\6\2\35\36\7\3\2\2\36 \5\n\6\2\37"+
		"\35\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"$\3\2\2\2#!\3\2\2\2$%\7"+
		"\4\2\2%\7\3\2\2\2&)\7\5\2\2\')\3\2\2\2(&\3\2\2\2(\'\3\2\2\2)\t\3\2\2\2"+
		"*-\7\5\2\2+-\3\2\2\2,*\3\2\2\2,+\3\2\2\2-\13\3\2\2\2\7\20\27!(,";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}