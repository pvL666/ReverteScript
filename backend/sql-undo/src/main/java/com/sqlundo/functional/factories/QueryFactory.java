package com.sqlundo.functional.factories;

import com.sqlundo.functional.models.Query;

/**
 * The QueryFactory interface provides a contract for creating Query objects
 * based on a provided statement. Concrete implementations of this interface are
 * responsible for parsing the statement and creating the corresponding Query
 * object.
 * <p>
 * Example usage:
 *
 * <pre>
 * String statement = "SELECT * FROM my_table";
 * QueryFactory factory = new SelectQueryFactory();
 * Query query = factory.createQuery(statement);
 * </pre>
 * <p>
 * Implementations of this interface should provide an implementation for the
 * {@link #createQuery(String)} method, which takes a statement as input and
 * returns a Query object representing the parsed query.
 * <p>
 * The specific type of Query object returned may vary depending on the
 * implementation.
 * <p>
 * It is recommended to create concrete implementations of this interface for
 * each query type or statement format that needs to be supported.
 * <p>
 * Implementations of this interface should handle any necessary validation or
 * parsing of the statement and throw appropriate exceptions if the statement is
 * invalid or cannot be parsed.
 * <p>
 * Implementations of this interface should be thread-safe if intended to be
 * used concurrently.
 *
 * @author Luan Nadaletti
 */
public interface QueryFactory {

    /**
     * Creates a Query object based on the provided statement.
     *
     * @param statement The statement to create the query from.
     * @return A Query object representing the parsed query.
     * @throws IllegalArgumentException If the statement is invalid or cannot be
     *                                  parsed.
     */
    Query createQuery(String statement);

}
