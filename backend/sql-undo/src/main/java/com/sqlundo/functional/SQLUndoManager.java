package com.sqlundo.functional;

import java.util.ArrayList;
import java.util.List;

import com.sqlundo.api.model.QueryDTO;
import com.sqlundo.functional.enums.QueryReverserType;
import com.sqlundo.functional.exception.UnsupportedQueryException;
import com.sqlundo.functional.models.Query;
import com.sqlundo.functional.parsers.QueryParser;
import com.sqlundo.functional.reversers.QueryReverser;

public class SQLUndoManager {

    public static List<QueryDTO> undo(String scriptText) {
        List<QueryDTO> queries = new ArrayList<>();
        for (Query query : parseQueries(scriptText)) {
            queries.add(new QueryDTO(query.toString(), reverseQuery(query)));
        }

        return queries;
    }

    /**
     * Parses the provided script and returns a list of queries.
     *
     * @param script The script to be parsed.
     *
     * @return A list of queries extracted from the script.
     */
    private static List<Query> parseQueries(String script) {
        QueryParser queryParser = new QueryParser(script);
        return queryParser.parse();
    }

    /**
     * Reverses the provided query based on the query type and displays the result
     * in the console.
     *
     * @param query The query to be reversed.
     *
     * @throws IllegalArgumentException      If the query cannot be reversed.
     * @throws UnsupportedOperationException If the query reversal is not supported.
     */
    private static String reverseQuery(Query query) {
        QueryReverserType reverserType = QueryReverserType.fromQuery(query);
        if (reverserType == null) {
            throw new IllegalArgumentException("Cannot reverse query: " + query);
        }

        QueryReverser reverser = reverserType.getReverserInstance();
        if (reverser == null) {
            throw new UnsupportedQueryException("Query reversal not supported: " + query);
        }

        return reverser.reverse(query);
    }
}
