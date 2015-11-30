package de.phantasien.sudoku.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author jschulz, 14.11.2015
 */
public class Game implements Serializable {

    private static final long serialVersionUID = 183330891574822943L;

    private GameState gameState = GameState.ongoing;

    private GameLevel gameLevel;

    private Grid board;

    private int movesCount = 0;

    public Game(GameLevel gameLevel, Grid board) {
        this.gameLevel = gameLevel;
        this.board = board;
    }

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

    public Grid getBoard() {
        return board;
    }

    public void setBoard(Grid board) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.gameState);
        hash = 79 * hash + Objects.hashCode(this.gameLevel);
        hash = 79 * hash + Objects.hashCode(this.board);
        hash = 79 * hash + this.movesCount;
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
        final Game other = (Game) obj;
        if (this.gameState != other.gameState) {
            return false;
        }
        if (this.gameLevel != other.gameLevel) {
            return false;
        }
        if (!Objects.equals(this.board, other.board)) {
            return false;
        }
        if (this.movesCount != other.movesCount) {
            return false;
        }
        return true;
    }

}
