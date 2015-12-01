package de.phantasien.sudoku.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author jschulz, 14.11.2015
 */
public class Move implements Serializable {

    private static final long serialVersionUID = 8241087104067697332L;

    private int rowNum;
    private int colNum;

    private int input;

    private MoveResult moveResult;

    public Move() {
    }

    public Move(int rowNum, int colNum, int input, MoveResult moveResult) {
        this.rowNum = rowNum;
        this.colNum = colNum;
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

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {
        this.colNum = colNum;
    }

    @Override
    public String toString() {
        return "Move{" + "rowNum=" + rowNum + ", colNum=" + colNum + ", input=" + input + ", moveResult=" + moveResult + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.rowNum;
        hash = 37 * hash + this.colNum;
        hash = 37 * hash + this.input;
        hash = 37 * hash + Objects.hashCode(this.moveResult);
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
        if (this.rowNum != other.rowNum) {
            return false;
        }
        if (this.colNum != other.colNum) {
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
