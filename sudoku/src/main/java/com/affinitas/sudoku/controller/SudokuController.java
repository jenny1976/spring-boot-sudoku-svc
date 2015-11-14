package com.affinitas.sudoku.controller;

import com.affinitas.sudoku.creator.GameInitializer;
import com.affinitas.sudoku.dto.GameLevel;
import com.affinitas.sudoku.dto.Game;
import com.affinitas.sudoku.dto.Move;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jennifer Schulz, jennykroete.gmx.de, 13.11.2015
 */
@RestController
@RequestMapping(
        value = "/sudoku",
        consumes = "application/xml",
        produces = "application/xml"
)
public class SudokuController {

    private static final Logger LOGGER = Logger.getLogger(SudokuController.class);



    @RequestMapping(value = "/{gameId}", method = RequestMethod.GET)
    public @ResponseBody Game loadGame(final @PathVariable Long gameId) {

        return GameInitializer.createDummy();
    }


    @RequestMapping(value = "/create/{level}", method = RequestMethod.PUT)
    public @ResponseBody Game createGame(final @PathVariable GameLevel level) {

   return GameInitializer.createDummy();
    }


    @RequestMapping(value = "/validate/{gameId}", method = RequestMethod.POST)
    public @ResponseBody Move validateMove(final @PathVariable Long gameId, @RequestBody @Valid Move move) {

        return GameInitializer.createDummyM();
    }


}
