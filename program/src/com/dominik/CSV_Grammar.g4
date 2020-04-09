grammar CSV_Grammar;

csv_file: header_row row+;							// plik csv to naglowek i przynajmniej jeden wiersz
	
header_row: cell_header (',' cell_header)* '\n';	// naglowek to jedna lub wiecej komorek naglowka oddzielone przecinkami az do nowej linii

row: cell (',' cell)* '\n';							// wiersz to jedna lub wiecej komorek oddzielone przecinkami az do nowej linii

cell_header: CHARS | ;								// komorka naglowka to ciag znakow, ale moze byc tez pusta

cell: CHARS | ;										// komorka to ciag znakow, ale moze byc tez pusta

CHARS: ~[,\n]+ ; 									// cokolwiek co nie jest przecinkiem i nowa linia 