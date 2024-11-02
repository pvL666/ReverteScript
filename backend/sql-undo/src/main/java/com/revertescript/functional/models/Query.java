package com.revertescript.functional.models;

/**
 * Represents a database query. This is an abstract class that provides common
 * functionality for different types of queries.
 * <p>
 * The class provides a constructor to initialize the query with the statement
 * and table name. It also provides a getter method to retrieve the table name
 * associated with the query. The `toString()` method is overridden to return
 * the original statement of the query.
 * <p>
 * This class is intended to be extended by specific query types such as SELECT,
 * INSERT, UPDATE, DELETE, etc.
 * <p>
 * Instances of this class are immutable once created.
 *
 * @author Luan Nadaletti
 */
public abstract class Query {

    protected final String statement;
    protected final String table;

    /**
     * Constructs a Query object with the provided statement and table name.
     *
     * @param statement The original statement of the query.
     * @param table     The name of the table associated with the query.
     */
    protected Query(String statement, String table) {
        this.statement = statement;
        this.table = table;
    }

    public String getTable() {
        return table;
    }

    @Override
    public String toString() {
        return statement;
    }

}
