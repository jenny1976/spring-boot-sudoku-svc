package com.affinitas.sudoku.dto;

import java.io.Serializable;
import java.util.Arrays;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Jennifer Schulz, jennykroete.gmx.de, 14.11.2015
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.PUBLIC_MEMBER)
public class Board implements Serializable {

    private static final long serialVersionUID = 418061626191626746L;

    public static final int rows = 9;

    public static final int cols = 9;

    private final Square[][] fields;

    public Board() {
        fields = new Square[rows][cols];
    }

    public Board(Square[][] fields) {
        this.fields = fields;
    }

    public Square[][] getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return "Board{" + "rows=" + rows + ", cols=" + cols + ", fields=" + Arrays.deepToString(fields) + '}';
    }

}
