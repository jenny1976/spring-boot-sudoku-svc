package de.phantasien.sudoku.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author jschulz, 14.11.2015
 */
public class Move implements Serializable {

    private static final long serialVersionUID = 8241087104067697332L;

    private Cell square;

    private int input;

    private MoveResult moveResult;

    public Move() {
    }

    public Move(Cell square, int input, MoveResult moveResult) {
        this.square = square;
        this.input = input;
        this.moveResult = moveResult;
    }

    public int getInput() {
        return input;
    }

    public void setInput(int input) {
        this.input = input;
    }

    public MoveResult getMoveResult() {
        return moveResult;
    }

    public void setMoveResult(MoveResult moveResult) {
        this.moveResult = moveResult;
    }

    public Cell getSquare() {
        return square;
    }

    public void setSquare(Cell square) {
        this.square = square;
    }

    @Override
    public String toString() {
        return "Move{" + "square=" + square + ", input=" + input + ", moveResult=" + moveResult + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.square);
        hash = 47 * hash + this.input;
        hash = 47 * hash + Objects.hashCode(this.moveResult);
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
        final Move other = (Move) obj;
        if (!Objects.equals(this.square, other.square)) {
            return false;
        }
        if (this.input != other.input) {
            return false;
        }
        if (this.moveResult != other.moveResult) {
            return false;
        }
        return true;
    }

}
