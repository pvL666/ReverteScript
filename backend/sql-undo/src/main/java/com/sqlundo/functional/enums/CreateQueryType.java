package com.sqlundo.functional.enums;

/**
 * Enumeration representing the types of create queries. Currently supports
 * TABLE and SEQUENCE types.
 */
public enum CreateQueryType {

    TABLE {
        @Override
        public String getKeyWord() {
            return "TABLE";
        }
    },
    SEQUENCE {
        @Override
        public String getKeyWord() {
            return "SEQUENCE";
        }
    };

    /**
     * Returns the keyword associated with the query type.
     *
     * @return The keyword corresponding to the query type.
     */
    public abstract String getKeyWord();

    /**
     * Returns the query type based on a type string.
     *
     * @param type The type string to be converted to a query type.
     * @return The query type corresponding to the type string, or null if not
     * found.
     */
    public static CreateQueryType fromType(String type) {
        if ("TABLE".equalsIgnoreCase(type)) {
            return TABLE;
        }
        if ("SEQUENCE".equalsIgnoreCase(type)) {
            return SEQUENCE;
        }
        return null;
    }

}
