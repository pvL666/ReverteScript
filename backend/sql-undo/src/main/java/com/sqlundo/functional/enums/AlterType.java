package com.sqlundo.functional.enums;

/**
 * Specifies the type of alteration in an ALTER TABLE SQL statement. The
 * `AlterType` enum represents the possible types of table modifications that
 * can be applied, such as adding or dropping columns or constraints.
 *
 * <ul>
 * <li>{@link #COLUMN} - Indicates that the alteration applies to a column in
 * the table.</li>
 * <li>{@link #CONSTRAINT} - Indicates that the alteration applies to a
 * constraint in the table.</li>
 * <li>{@link #NONE} - Specifies that the alteration has no specific type,
 * meaning no additional keyword (e.g., COLUMN or CONSTRAINT) is required.</li>
 * </ul>
 *
 * This enum allows for a structured approach to handling different types of
 * table alterations and supports flexibility across SQL dialects that may or
 * may not require specific keywords for certain operations.
 *
 * @author Luan Nadaletti
 */
public enum AlterType {
    COLUMN, CONSTRAINT, NONE;
}
