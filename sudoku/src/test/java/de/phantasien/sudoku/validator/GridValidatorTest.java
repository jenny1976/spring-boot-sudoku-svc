package de.phantasien.sudoku.validator;

import de.phantasien.sudoku.model.Cell;
import de.phantasien.sudoku.model.Grid;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author jschulz
 */
public class GridValidatorTest {

    public GridValidatorTest() {
    }

    private Grid dummy = new Grid();

    @Before
    public void setUp() {

        Map<String, Cell> fields = new HashMap<>(Grid.cols*Grid.rows);
        // ----------- first 3x9
        // first row
//        fields[0][0] = new Cell(0, 0, 1, true);
//        fields[0][1] = new Cell(0, 1, 2, true);
//        fields[0][2] = new Cell(0, 2, 3, true);
//        fields[0][3] = new Cell(0, 3, 4, true);
//        fields[0][4] = new Cell(0, 4, 5, true);
//        fields[0][5] = new Cell(0, 5, 6, true);
//        fields[0][6] = new Cell(0, 6, 7, true);
//        fields[0][7] = new Cell(0, 7, 8, true);
//        fields[0][8] = new Cell(0, 8, 9, true);

        // 2nd row
//        fields[1][0] = new Cell(1, 0, 7, true);
//        fields[1][1] = new Cell(1, 1, 8, false);
//        fields[1][2] = new Cell(1, 2, 9, true);
//        fields[1][3] = new Cell(1, 3, 1, true);
//        fields[1][4] = new Cell(1, 4, 2, true);
//        fields[1][5] = new Cell(1, 5, 3, true);
//        fields[1][6] = new Cell(1, 6, 4, true);
//        fields[1][7] = new Cell(1, 7, 5, true);
//        fields[1][8] = new Cell(1, 8, 6, true);

        // 3rd row
//        fields[2][0] = new Cell(2, 0, 4, true);
//        fields[2][1] = new Cell(2, 1, 5, true);
//        fields[2][2] = new Cell(2, 2, 6, true);
//        fields[2][3] = new Cell(2, 3, 7, true);
//        fields[2][4] = new Cell(2, 4, 8, true);
//        fields[2][5] = new Cell(2, 5, 9, true);
//        fields[2][6] = new Cell(2, 6, 1, true);
//        fields[2][7] = new Cell(2, 7, 2, true);
//        fields[2][8] = new Cell(2, 8, 3, true);

        // ----------- 2nd 3x9
        // ...

        dummy = new Grid(fields);

    }

    @After
    public void tearDown() {
    }

    @Test @Ignore
    public void testValidateGrid() {
        System.out.println("validateGrid");
        Grid grid = null;
        GridValidator instance = new GridValidator();
        boolean expResult = false;
        boolean result = instance.validateGrid(grid);

    }

    @Test
    public void testIsValidNumber() {
        System.out.println("isValidNumber");
        GridValidator instance = new GridValidator();

        int input = 10;
        boolean result = instance.isValidNumber(input);
        Assert.assertEquals(false, result);

        input = 0;
        result = instance.isValidNumber(input);
        Assert.assertEquals(false, result);

        input = 1;
        result = instance.isValidNumber(input);
        Assert.assertEquals(true, result);

        input = 9;
        result = instance.isValidNumber(input);
        Assert.assertEquals(true, result);
    }

    @Test
    public void testIsValidInput() {
        System.out.println("isValidInput");
        GridValidator instance = new GridValidator();

        Cell input = new Cell(2, 2, 5, false);
        Cell[] row = new Cell[2];
        row[0] = new Cell(1, 1, 3, true);
        row[1] = new Cell(1, 2, 7, true);
        boolean result = instance.isValidInput(input, row);
        Assert.assertEquals(true, result);

        input = new Cell(2, 2, 7, false);
        result = instance.isValidInput(input, row);
        Assert.assertEquals(false, result);

        input = new Cell(2, 2, 11, false);
        result = instance.isValidInput(input, row);
        Assert.assertEquals(false, result);
    }

    @Test
    public void testValidateNine() {
        System.out.println("validateNine");

        GridValidator instance = new GridValidator();

        Cell[] row = new Cell[9];
        row[0] = new Cell(1, 1, 3, true);
        row[1] = new Cell(1, 2, 7, true);
        row[2] = new Cell(1, 2, 1, true);
        row[3] = new Cell(1, 2, 2, true);
        row[4] = new Cell(1, 2, 4, true);
        row[5] = new Cell(1, 2, 5, true);
        row[6] = new Cell(1, 2, 6, true);
        row[7] = new Cell(1, 2, 8, true);

        row[8] = new Cell(1, 2, 8, true);
        boolean result = instance.validateNine(row);
        Assert.assertEquals(false, result);

        row[8] = new Cell(1, 2, 19, true);
        result = instance.validateNine(row);
        Assert.assertEquals(false, result);

        row[8] = new Cell(1, 2, 9, true);
        result = instance.validateNine(row);
        Assert.assertEquals(true, result);

    }

}
