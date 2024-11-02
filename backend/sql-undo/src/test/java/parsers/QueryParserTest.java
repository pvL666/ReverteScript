package parsers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sqlundo.functional.models.InsertQuery;
import com.sqlundo.functional.models.Query;
import com.sqlundo.functional.parsers.QueryParser;

/**
 * @author Luan Nadaletti
 *
 */
class QueryParserTest {

	private QueryParser parser;

	@BeforeEach
	void setup() {
		String script = "INSERT INTO table (column) VALUES ('value');";
		parser = new QueryParser(script);
	}

	@Test
	void testParse() {
		List<Query> queries = parser.parse();

		assertEquals(1, queries.size(), "O tamanho da lista de queries é superior a 1.");

		Query insertQuery = queries.get(0);
		assertTrue(insertQuery instanceof InsertQuery, "A query gerada não é uma InsertQuery.");

		insertQuery = (InsertQuery) insertQuery;
		assertEquals("INSERT INTO table (column) VALUES ('value');", insertQuery.toString(),
				"O statement setado no objeto Query está incorreto.");
	}

}
