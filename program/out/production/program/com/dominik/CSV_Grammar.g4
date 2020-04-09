grammar CSV_Grammar;

csv_file: header row+;		// plik csv to naglowek i przynajmniej jeden wiersz
	
header: row;			// naglowek to pojedynczy wiersz

row: cell (',' cell)* '\n';	// wiersz to jedna lub wiecej komorek oddzielone przecinkami az do nowej linii

cell: CHARS | ;			// komorka to ciag znakow, ale moze byc tez pusta

CHARS: ~[,\n]+ ; 		// cokolwiek co nie jest przecinkiem i nowa linia 