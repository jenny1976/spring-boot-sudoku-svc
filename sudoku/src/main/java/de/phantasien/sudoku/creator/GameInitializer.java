package de.phantasien.sudoku.creator;

import de.phantasien.sudoku.model.Grid;
import de.phantasien.sudoku.model.Game;
import de.phantasien.sudoku.model.GameLevel;
import de.phantasien.sudoku.model.Move;
import de.phantasien.sudoku.model.MoveResult;
import de.phantasien.sudoku.model.Cell;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * @author jschulz, 14.11.2015
 */
@Component
public class GameInitializer {

    private final List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9);

    public Game createGame(final GameLevel level) {
        Collections.shuffle(numberList);

        Map<String, Cell> fields = new HashMap<>(Grid.cols*Grid.rows);

        for (int i = 0; i < Grid.rows; i++) {
            for (int y = 0; y < Grid.cols; y++) {

                fields.put(i+","+y, new Cell(i, y, numberList.get(y), true));

            } if (i==2 || i==5) {
                Collections.rotate(numberList, -4);
            } else {
                Collections.rotate(numberList, -3);
            }
        }

        return new Game(level, new Grid(fields));
    }










    //----------- dummy content methods ----------------



    public static Move createDummyM() {
        final Move move = new Move();
        move.setInput(9);
        move.setMoveResult(MoveResult.valid);
        move.setColNum(1);
        move.setRowNum(1);

        return move;
    }
}
