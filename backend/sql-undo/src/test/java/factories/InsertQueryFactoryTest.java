package factories;

import org.junit.jupiter.api.Test;

import com.sqlundo.functional.factories.InsertQueryFactory;

/**
 *
 * @author Luan Nadaletti
 *
 */
class InsertQueryFactoryTest {

	@Test
	void testInsertQuerySingleValue() {
		String script = "INSERT INTO table (field) VALUES ('value')";
		InsertQueryFactory factory = new InsertQueryFactory();
	}
}
