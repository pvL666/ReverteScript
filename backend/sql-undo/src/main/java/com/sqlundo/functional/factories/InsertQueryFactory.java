package com.sqlundo.functional.factories;

import com.sqlundo.functional.exception.MalformattedQueryException;
import com.sqlundo.functional.models.InsertQuery;
import com.sqlundo.functional.models.Query;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Factory class responsible for creating an {@link InsertQuery} object based on
 * a provided statement. The statement is parsed using a regular expression
 * pattern, and the extracted values are used to create the query object.
 * <p>
 * The expected format of the statement is: INSERT INTO
 * <table>
 * (<fields>) VALUES (<values>)
 * <p>
 * The factory uses regular expressions to extract the table name, fields, and
 * values from the statement and creates an {@link InsertQuery} object with the
 * extracted values.
 * <p>
 * This factory only supports parsing INSERT statements with the specified
 * format.
 * <p>
 * The fields and values are extracted as comma-separated strings and converted
 * to lists using the {@link Arrays#asList(Object[])} method. The values are
 * trimmed to remove leading and trailing whitespace using the
 * {@link String#trim()} method.
 * <p>
 * The resulting {@link InsertQuery} object contains the statement, table name,
 * fields, and values.
 *
 * @author Luan Nadaletti
 */
public class InsertQueryFactory implements QueryFactory {

    /**
     * Creates an {@link InsertQuery} object based on the provided statement.
     *
     * @param statement The INSERT statement to create the query from.
     * @return An {@link InsertQuery} object representing the parsed query.
     * @throws MalformattedQueryException If the statement is invalid and cannot
     *                                  be parsed.
     */
    @Override
    public Query createQuery(String statement) {
        String regex = "\\s*INSERT\\s*INTO\\s*(\\w+)\\s*\\((.+)\\)\\s*VALUES\\s*\\((.+)\\)\\s*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(statement);

        if (!matcher.find()) {
            throw new MalformattedQueryException("Invalid INSERT statement: " + statement);
        }

        String table = matcher.group(1);
        List<String> fields = Arrays.stream(matcher.group(2).split(","))
                .map(String::trim).collect(Collectors.toList());
        List<String> values = Arrays.stream(matcher.group(3).split(","))
                .map(String::trim).collect(Collectors.toList());

        return new InsertQuery(statement, table, fields, values);
    }

}
