package com.affinitas.sudoku.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jennifer Schulz, jennykroete.gmx.de, 14.11.2015
 */
@XmlRootElement
public class Game implements Serializable {

    private static final long serialVersionUID = 183330891574822943L;

    private GameState gameState;

    private GameLevel gameLevel;

    private Board board;

    private int movesCount = 0;

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GameLevel getGameLevel() {
        return gameLevel;
    }

    public void setGameLevel(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getMovesCount() {
        return movesCount;
    }

    public void setMovesCount(int movesCount) {
        this.movesCount = movesCount;
    }

    @Override
    public String toString() {
        return "Game{" + "gameState=" + gameState + ", gameLevel=" + gameLevel + ", board=" + board
                + ", movesCount=" + movesCount + '}';
    }


}
