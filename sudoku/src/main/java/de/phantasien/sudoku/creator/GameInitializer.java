package de.phantasien.sudoku.creator;

import de.phantasien.sudoku.model.Grid;
import de.phantasien.sudoku.model.Game;
import de.phantasien.sudoku.model.GameLevel;
import de.phantasien.sudoku.model.Move;
import de.phantasien.sudoku.model.MoveResult;
import de.phantasien.sudoku.model.Cell;
import de.phantasien.sudoku.redis.GamesQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

/**
 * @author jschulz, 14.11.2015
 */
public class GameInitializer {

    private final List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9);

    @Inject
    private GamesQueue gamesQueue;

    public Game createGame(final GameLevel level) {
        Collections.shuffle(numberList);

        Cell[][] fields = new Cell[Grid.rows][Grid.cols];

        for (int i = 0; i < Grid.rows; i++) {
            for (int y = 0; y < Grid.cols; y++) {

                fields[i][y] = new Cell(i, y, numberList.get(y), true);


            } if(i==2 || i==5){
                Collections.rotate(numberList, -4);
            } else {
                Collections.rotate(numberList, -3);
            }
        }

        Game newGame = new Game(level, new Grid(fields));

//        gamesQueue.addGame(newGame);
        return newGame;
    }










    //----------- dummy content methods ----------------

    public static Game createDummy() {

        final Cell[][] fields = new Cell[Grid.rows][Grid.cols];

        // ----------- first 3x9
        // first row
        fields[0][0] = new Cell(0, 0, 1, true);
        fields[0][1] = new Cell(0, 1, 2, true);
        fields[0][2] = new Cell(0, 2, 3, true);
        fields[0][3] = new Cell(0, 3, 4, true);
        fields[0][4] = new Cell(0, 4, 5, true);
        fields[0][5] = new Cell(0, 5, 6, true);
        fields[0][6] = new Cell(0, 6, 7, true);
        fields[0][7] = new Cell(0, 7, 8, true);
        fields[0][8] = new Cell(0, 8, 9, true);

        // 2nd row
        fields[1][0] = new Cell(1, 0, 7, true);
        fields[1][1] = new Cell(1, 1, 8, false);
        fields[1][2] = new Cell(1, 2, 9, true);
        fields[1][3] = new Cell(1, 3, 1, true);
        fields[1][4] = new Cell(1, 4, 2, true);
        fields[1][5] = new Cell(1, 5, 3, true);
        fields[1][6] = new Cell(1, 6, 4, true);
        fields[1][7] = new Cell(1, 7, 5, true);
        fields[1][8] = new Cell(1, 8, 6, true);

        // 3rd row
        fields[2][0] = new Cell(2, 0, 4, true);
        fields[2][1] = new Cell(2, 1, 5, true);
        fields[2][2] = new Cell(2, 2, 6, true);
        fields[2][3] = new Cell(2, 3, 7, true);
        fields[2][4] = new Cell(2, 4, 8, true);
        fields[2][5] = new Cell(2, 5, 9, true);
        fields[2][6] = new Cell(2, 6, 1, true);
        fields[2][7] = new Cell(2, 7, 2, true);
        fields[2][8] = new Cell(2, 8, 3, true);

        // ----------- 2nd 3x9
        // ...

        final Grid b = new Grid(fields);
        final Game g = new Game(GameLevel.medium, b);

        return g;
    }

    public static Move createDummyM() {
        final Move move = new Move();
        move.setInput(9);
        move.setMoveResult(MoveResult.valid);
        move.setSquare(new Cell(1, 1, 8, false));

        return move;
    }
}
