package de.phantasien.sudoku.validator;

import de.phantasien.sudoku.model.Cell;

/**
 * @author jschulz, 14.11.2015
 */
public class BoardValidator {

    public boolean validateRow(Cell input, Cell[] row) {

        return true;
    }

    public boolean validateCol(Cell input, Cell[] column) {

        return true;
    }

    public boolean validateBlock(Cell input, Cell[][] fields) {

        return true;
    }

    private boolean isValidNumber(int move) {
        if( move >=0 && move <=9 )
            return true;
        return false;
    }

}
