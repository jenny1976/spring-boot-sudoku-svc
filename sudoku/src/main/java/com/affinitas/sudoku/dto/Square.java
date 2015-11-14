package com.affinitas.sudoku.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jennifer Schulz, jennykroete.gmx.de, 14.11.2015
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class Square implements Serializable {

    private static final long serialVersionUID = -7751033628818962425L;

    private int rowNum;
    private int colNum;

    private int value;

    private boolean preset;


    public Square() {
    }

    public Square(int rowNo, int colNo, int value, boolean preset) {
        this.rowNum = rowNo;
        this.colNum = colNo;
        this.value = value;
        this.preset = preset;
    }

    public int getRowNum() {
        return rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public int getValue() {
        return value;
    }

    public boolean isPreset() {
        return preset;
    }

    @Override
    public String toString() {
        return "Square{" + "rowNo=" + rowNum + ", colNo=" + colNum + ", value=" + value
                + ", preset=" + preset + '}';
    }
}
