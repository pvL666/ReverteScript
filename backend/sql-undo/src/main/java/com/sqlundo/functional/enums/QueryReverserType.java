package com.sqlundo.functional.enums;

import com.sqlundo.functional.models.Query;
import com.sqlundo.functional.reversers.AlterTableQueryReverser;
import com.sqlundo.functional.reversers.CreateQueryReverser;
import com.sqlundo.functional.reversers.InsertQueryReverser;
import com.sqlundo.functional.reversers.QueryReverser;

/**
 * The {@code QueryReverserType} enum represents different types of query
 * reversers. Each query reverser type is associated with a corresponding
 * {@link QueryReverser} implementation that can reverse a specific type of SQL
 * query.
 *
 * <p>
 * This enum provides methods to retrieve the appropriate {@link QueryReverser}
 * for each query reverser type, and to determine the query reverser type based
 * on a given {@link Query} object.
 * </p>
 *
 * <p>
 * Example usage:
 *
 * <pre>{@code
 * Query query = new InsertQuery("INSERT INTO table (column) VALUES ('value')");
 * QueryReverserType reverserType = QueryReverserType.fromQuery(query);
 * QueryReverser reverser = reverserType.getQueryReverser();
 * }</pre>
 * </p>
 *
 * @author Luan Nadaletti
 * @see QueryReverser
 */
public enum QueryReverserType {
    INSERT_REVERSER {
        @Override
        public QueryReverser getQueryReverser() {
            return new InsertQueryReverser();
        }
    },

    CREATE_REVERSER {
        @Override
        public QueryReverser getQueryReverser() {
            return new CreateQueryReverser();
        }
    },

    ALTER_TABLE_REVERSER {
        @Override
        public QueryReverser getQueryReverser() {
            return new AlterTableQueryReverser();
        }
    };

    /**
     * Returns the {@link QueryReverser} associated with this query reverser
     * type.
     *
     * @return The query reverser for this query reverser type.
     */
    public abstract QueryReverser getQueryReverser();

    /**
     * Determines the {@code QueryReverserType} based on the given {@link Query}
     * object.
     *
     * @param query The query object.
     * @return The query reverser type associated with the query, or
     * {@code null} if no match is found.
     */
    public static QueryReverserType fromQuery(Query query) {
        if (query.toString().contains("INSERT INTO")
                && query.toString().contains("VALUES")) {
            return INSERT_REVERSER;
        }
        if (query.toString().contains("CREATE")) {
            return CREATE_REVERSER;
        }
        if (query.toString().contains("ALTER TABLE")) {
            return ALTER_TABLE_REVERSER;
        }

        return null;
    }

}
