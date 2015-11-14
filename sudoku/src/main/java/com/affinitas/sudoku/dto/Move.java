package com.affinitas.sudoku.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jennifer Schulz, jennykroete.gmx.de, 14.11.2015
 */
@XmlRootElement
public class Move implements Serializable {

    private static final long serialVersionUID = 8241087104067697332L;

    private Square square;

    private int input;

    private MoveResult moveResult;

    public Move() {
    }

    public Move(Square square, int input, MoveResult moveResult) {
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

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    @Override
    public String toString() {
        return "Move{" + "square=" + square + ", input=" + input + ", moveResult=" + moveResult + '}';
    }

}
