package com.affinitas.sudoku.dto;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 * @author Jennifer Schulz, jennykroete.gmx.de, 14.11.2015
 */
@XmlEnum
public enum GameState {

    @XmlEnumValue(value = "solved")
    solved,
    
    @XmlEnumValue(value = "ongoing")
    ongoing

}
