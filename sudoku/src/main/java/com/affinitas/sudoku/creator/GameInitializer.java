package com.affinitas.sudoku.creator;

import com.affinitas.sudoku.dto.Board;
import com.affinitas.sudoku.dto.Game;
import com.affinitas.sudoku.dto.GameLevel;
import com.affinitas.sudoku.dto.GameState;
import com.affinitas.sudoku.dto.Move;
import com.affinitas.sudoku.dto.MoveResult;
import com.affinitas.sudoku.dto.Square;

/**
 * @author Jennifer Schulz, jennykroete.gmx.de, 14.11.2015
 */
public class GameInitializer {

    public static Game createDummy() {
        final Game g = new Game();

        final Square[][] fields = new Square[Board.rows][Board.cols];

        // ----------- first 3x9
        // first row
        fields[0][0] = new Square(0, 0, 1, true);
        fields[0][1] = new Square(0, 1, 2, true);
        fields[0][2] = new Square(0, 2, 3, true);
        fields[0][3] = new Square(0, 3, 4, true);
        fields[0][4] = new Square(0, 4, 5, true);
        fields[0][5] = new Square(0, 5, 6, true);
        fields[0][6] = new Square(0, 6, 7, true);
        fields[0][7] = new Square(0, 7, 8, true);
        fields[0][8] = new Square(0, 8, 9, true);

        // 2nd row
        fields[1][0] = new Square(1, 0, 7, true);
        fields[1][1] = new Square(1, 1, 8, false);
        fields[1][2] = new Square(1, 2, 9, true);
        fields[1][3] = new Square(1, 3, 1, true);
        fields[1][4] = new Square(1, 4, 2, true);
        fields[1][5] = new Square(1, 5, 3, true);
        fields[1][6] = new Square(1, 6, 4, true);
        fields[1][7] = new Square(1, 7, 5, true);
        fields[1][8] = new Square(1, 8, 6, true);

        // 3rd row
        fields[2][0] = new Square(2, 0, 4, true);
        fields[2][1] = new Square(2, 1, 5, true);
        fields[2][2] = new Square(2, 2, 6, true);
        fields[2][3] = new Square(2, 3, 7, true);
        fields[2][4] = new Square(2, 4, 8, true);
        fields[2][5] = new Square(2, 5, 9, true);
        fields[2][6] = new Square(2, 6, 1, true);
        fields[2][7] = new Square(2, 7, 2, true);
        fields[2][8] = new Square(2, 8, 3, true);

        // ----------- 2nd 3x9
        // ...

        final Board b = new Board(fields);
        g.setBoard(b);
        g.setGameLevel(GameLevel.medium);
        g.setGameState(GameState.ongoing);

        return g;
    }

    public static Move createDummyM() {
        final Move move = new Move();
        move.setInput(9);
        move.setMoveResult(MoveResult.valid);
        move.setSquare(new Square(1, 1, 8, false));

        return move;
    }
}
