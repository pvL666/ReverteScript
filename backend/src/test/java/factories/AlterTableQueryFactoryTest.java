package factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.revertescript.functional.factories.AlterTableQueryFactory;
import com.revertescript.functional.models.AlterTableQuery;

/**
 * @author Luan Nadaletti
 *
 */
class AlterTableQueryFactoryTest {

	@Test
	void testCreateQueryValidStatement() {
		String statement = "ALTER TABLE myTable ADD COLUMN myColumn INT";
		AlterTableQueryFactory factory = new AlterTableQueryFactory();
		AlterTableQuery expectedQuery = new AlterTableQuery(statement, "myTable", "ADD", "myColumn", "INT", true,
				false);

		AlterTableQuery actualQuery = (AlterTableQuery) factory.createQuery(statement);

		assertEquals(expectedQuery.getClass(), actualQuery.getClass(), "As classes das querys estão diferentes.");
		assertEquals(expectedQuery.toString(), actualQuery.toString(), "Os statements setados estão diferentes entre as querys.");
		assertEquals(expectedQuery.getTable(), actualQuery.getTable(), "As tabelas setadas estão diferentes entre as querys.");
		assertEquals(expectedQuery.getOperator(), actualQuery.getOperator(), "Os operadores setados estão diferentes entre as querys.");
		assertEquals(expectedQuery.getTarget(), actualQuery.getTarget(), "Os targets setados estão diferentes entre as querys.");
		assertEquals(expectedQuery.getDataType(), actualQuery.getDataType(), "Os dataType setados estão diferentes entre as querys.");
	}

	@Test
	void testCreateQueryInvalidStatement() {
		String statement = "ALTER TABLE";
		AlterTableQueryFactory factory = new AlterTableQueryFactory();

		assertThrows(IllegalArgumentException.class, () -> factory.createQuery(statement));
	}

}
