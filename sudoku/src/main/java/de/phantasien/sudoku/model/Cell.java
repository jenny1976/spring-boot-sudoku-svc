package de.phantasien.sudoku.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author jschulz, 14.11.2015
 */
public class Cell implements Serializable {

    private static final long serialVersionUID = -7751033628818962425L;

    private int rowNum;
    private int colNum;

    private Integer value;

    private boolean preset;


    public Cell() {
    }

    public Cell(int rowNo, int colNo, Integer value, boolean preset) {
        this.rowNum = rowNo;
        this.colNum = colNo;
        this.preset = preset;
        this.value = value;
    }

    public int getRowNum() {
        return rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public Integer getValue() {
        return value;
    }

    public boolean isPreset() {
        return preset;
    }

    @Override
    public String toString() {
        return "Cell{" + "rowNum=" + rowNum + ", colNum=" + colNum + ", value=" + value + ", preset=" + preset + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.rowNum;
        hash = 47 * hash + this.colNum;
        hash = 47 * hash + Objects.hashCode(this.value);
        hash = 47 * hash + (this.preset ? 1 : 0);
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
        final Cell other = (Cell) obj;
        if (this.rowNum != other.rowNum) {
            return false;
        }
        if (this.colNum != other.colNum) {
            return false;
        }
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        if (this.preset != other.preset) {
            return false;
        }
        return true;
    }
}
