package de.phantasien.sudoku.validator;

import de.phantasien.sudoku.model.Cell;
import de.phantasien.sudoku.model.Grid;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Map;

/**
 * @author jschulz, 14.11.2015
 */
public class GridValidator {

    private final List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9);

    public boolean validateGrid(final Grid grid) {
        Map<String, Cell> cells = grid.getFields();
        boolean result = true;
//        for (int i = 0; i < cells.length; i++) {
//
//            Cell[] row = cells[i];
//            result = validateNine(row);
//        }
//        for (int i = 0; i < 10; i++) {
//            Cell[] row = cells[0][i];
//            result = validateNine(row);
//        }

        return result;
    }

    public boolean validateNine(Cell[] fields) {
        BitSet bitSet = new BitSet(fields.length);

        for (Cell cell : fields) {
            int value = cell.getValue();
            if(!isValidNumber(value))
                return false;

            if(!bitSet.get(value)) {
                bitSet.set(value);
            } else {
                return false;
            }
        }

        return true;
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

    protected boolean isValidInput(Cell input, Cell[] cells) {
        if(!isValidNumber(input.getValue()))
            return false;

        BitSet bitSet = new BitSet(cells.length);

        for (Cell row1 : cells) {
            int value = row1.getValue();
            if(!bitSet.get(value)) {
                bitSet.set(value);
            }
        }

        return !bitSet.get(input.getValue());
    }

}
