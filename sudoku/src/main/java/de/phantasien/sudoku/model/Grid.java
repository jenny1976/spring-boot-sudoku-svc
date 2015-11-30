package de.phantasien.sudoku.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author jschulz, 14.11.2015
 */
public class Grid implements Serializable {

    private static final long serialVersionUID = 418061626191626746L;

    public static final int rows = 9;

    public static final int cols = 9;

    private final Cell[][] fields;

    public Grid() {
        fields = new Cell[rows][cols];
    }

    public Grid(Cell[][] fields) {
        this.fields = fields;
    }

    public Cell[][] getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return "Board{" + "rows=" + rows + ", cols=" + cols + ", fields=" + Arrays.deepToString(fields) + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Arrays.deepHashCode(this.fields);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grid other = (Grid) obj;
        if (!Arrays.deepEquals(this.fields, other.fields)) {
            return false;
        }
        return true;
    }

}
