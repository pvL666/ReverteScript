package com.sqlundo.functional.factories;

import com.sqlundo.functional.enums.CreateQueryType;
import com.sqlundo.functional.models.CreateQuery;
import com.sqlundo.functional.models.Query;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Factory class responsible for creating a {@link CreateQuery} object based on
 * a provided statement. The statement is parsed using a regular expression
 * pattern, and the extracted values are used to create the query object.
 * <p>
 * The expected format of the statement is: CREATE <type>
 * <table>
 * <p>
 * The factory uses regular expressions to extract the type and table name from
 * the statement and creates a {@link CreateQuery} object with the extracted
 * values.
 * <p>
 * This factory only supports parsing CREATE statements with the specified
 * format.
 * <p>
 * The type is matched to the {@link CreateQueryType} enumeration using the
 * {@link CreateQueryType#fromType(String)} method.
 *
 * @author Luan Nadaletti
 */
public class CreateQueryFactory implements QueryFactory {

    /**
     * Creates a {@link CreateQuery} object based on the provided statement.
     *
     * @param statement The CREATE statement to create the query from.
     * @return A {@link CreateQuery} object representing the parsed query.
     * @throws IllegalArgumentException If the statement is invalid and cannot
     *                                  be parsed.
     */
    @Override
    public Query createQuery(String statement) {
        String regex = "\\s*CREATE\\s*(\\w*)\\s*(\\w*)\\s*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(statement);

        if (!matcher.find()) {
            throw new IllegalArgumentException("Invalid CREATE statement: " + statement);
        }

        String type = matcher.group(1);
        String table = matcher.group(2);

        return new CreateQuery(statement, table,
                CreateQueryType.fromType(type));
    }

}
