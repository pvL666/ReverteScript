package factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.sqlundo.functional.exception.MalformattedQueryException;
import com.sqlundo.functional.factories.AlterTableQueryFactory;
import com.sqlundo.functional.models.AlterTableQuery;

/**
 * @author Luan Nadaletti
 *
 */
class AlterTableQueryFactoryTest {

    @Test
    void testCreateQueryAddColumn() {
        String statement = "ALTER TABLE myTable ADD COLUMN myColumn INT";
        AlterTableQueryFactory factory = new AlterTableQueryFactory();
        AlterTableQuery query = (AlterTableQuery) factory.createQuery(statement);

        assertEquals(query.getColumnDefinitionClause(), "COLUMN",
                "Expected isColumnType to be true for ADD COLUMN operation.");
        assertEquals("myTable", query.getTable(), "Table name mismatch.");
        assertEquals("ADD", query.getOperator(), "Operator mismatch.");
        assertEquals("myColumn", query.getTarget(), "Target column mismatch.");
        assertEquals("INT", query.getDataType(), "Data type mismatch.");
    }

    @Test
    void testCreateQueryDropColumn() {
        String statement = "ALTER TABLE myTable DROP COLUMN myColumn";
        AlterTableQueryFactory factory = new AlterTableQueryFactory();
        AlterTableQuery query = (AlterTableQuery) factory.createQuery(statement);

        assertEquals(query.getColumnDefinitionClause(), "COLUMN",
                "Expected isColumnType to be true for DROP COLUMN operation.");
        assertEquals("myTable", query.getTable(), "Table name mismatch.");
        assertEquals("DROP", query.getOperator(), "Operator mismatch.");
        assertEquals("myColumn", query.getTarget(), "Target column mismatch.");
    }

    @Test
    void testCreateQueryAddConstraint() {
        String statement = "ALTER TABLE myTable ADD CONSTRAINT myConstraint UNIQUE (myColumn)";
        AlterTableQueryFactory factory = new AlterTableQueryFactory();
        AlterTableQuery query = (AlterTableQuery) factory.createQuery(statement);

        assertEquals(query.getColumnDefinitionClause(), "CONSTRAINT",
                "Expected isConstraintType to be true for ADD CONSTRAINT operation.");
        assertEquals("myTable", query.getTable(), "Table name mismatch.");
        assertEquals("ADD", query.getOperator(), "Operator mismatch.");
        assertEquals("myConstraint", query.getTarget(), "Target constraint mismatch.");
    }

    @Test
    void testCreateQueryDropConstraint() {
        String statement = "ALTER TABLE myTable DROP CONSTRAINT myConstraint";
        AlterTableQueryFactory factory = new AlterTableQueryFactory();
        AlterTableQuery query = (AlterTableQuery) factory.createQuery(statement);

        assertEquals(query.getColumnDefinitionClause(), "CONSTRAINT",
                "Expected isConstraintType to be true for DROP CONSTRAINT operation.");
        assertEquals("myTable", query.getTable(), "Table name mismatch.");
        assertEquals("DROP", query.getOperator(), "Operator mismatch.");
        assertEquals("myConstraint", query.getTarget(), "Target constraint mismatch.");
    }

    @Test
    void testCreateQueryInvalidStatement() {
        String statement = "ALTER TABLE";
        AlterTableQueryFactory factory = new AlterTableQueryFactory();

        assertThrows(MalformattedQueryException.class, () -> factory.createQuery(statement));
    }
}
