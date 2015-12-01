package de.phantasien.sudoku.validator;

import de.phantasien.sudoku.model.Cell;
import de.phantasien.sudoku.model.Grid;
import java.util.BitSet;

/**
 * @author jschulz, 14.11.2015
 */
public class GridValidator {

    public boolean validateGrid(final Grid grid) {
        Cell[][] cells = grid.getFields();

        return false;
    }

    public boolean validateRow(Cell input, Cell[] row) {

        return isValidInput(input, row);
    }

    public boolean validateCol(Cell input, Cell[] column) {

        return isValidInput(input, column);
    }

    public boolean validateBlock(Cell input, Cell[] fields) {

        return isValidInput(input, fields);
    }

    protected boolean isValidNumber(int input) {
        return (input >=1 && input <=9);
    }

    protected boolean isValidInput(Cell input, Cell[] row) {
        if(!isValidNumber(input.getValue()))
            return false;

        BitSet bitSet = new BitSet(row.length);

        for (Cell row1 : row) {
            int value = row1.getValue();
            if(!bitSet.get(value)) {
                bitSet.set(value);
            }
        }

        return !bitSet.get(input.getValue());
    }

}
