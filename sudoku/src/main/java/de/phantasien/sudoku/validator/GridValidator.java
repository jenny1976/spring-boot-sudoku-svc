package de.phantasien.sudoku.validator;

import de.phantasien.sudoku.model.Cell;
import de.phantasien.sudoku.model.Grid;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jschulz, 14.11.2015
 */
public class GridValidator {

    private final List<Integer> validNumbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

    public boolean validateGrid(final Grid grid) {
        final Map<String, Cell> cells = grid.getFields();
        boolean result = true;

        Map<String, Cell> toCheck = new HashMap<>(9);

        for (int i = 0; i < Grid.rows; i++) {

            for (int y = 0; y < Grid.cols; y++) {
                toCheck.put(i+","+y, cells.get(i+","+y));
            }
            result = validateNine(toCheck);
            toCheck = new HashMap<>(9);
        }

        for (int i = 0; i < Grid.cols; i++) {

            for (int y = 0; y < Grid.rows; y++) {
                toCheck.put(y+","+i, cells.get(y+","+i));
            }
            result = validateNine(toCheck);
            toCheck = new HashMap<>(9);
        }


        return result;
    }

    public boolean validateNine(Map<String, Cell> fields) {
        BitSet bitSet = new BitSet(fields.size());

        for (Map.Entry<String, Cell> entrySet : fields.entrySet()) {
//            String key = entrySet.getKey();
            Cell cell = entrySet.getValue();

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

    protected boolean isValidNumber(int input) {
        return (validNumbers.contains(input));
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
