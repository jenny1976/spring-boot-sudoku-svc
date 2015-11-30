package de.phantasien.sudoku.controller;

import de.phantasien.sudoku.creator.GameInitializer;
import de.phantasien.sudoku.model.GameLevel;
import de.phantasien.sudoku.model.Game;
import de.phantasien.sudoku.model.Move;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jschulz, 13.11.2015
 */
@RestController
@RequestMapping(
        value = "/sudoku",
        produces = { "application/json" },
        consumes = { "application/json" }
)
public class SudokuController {

    private static final Logger LOGGER = Logger.getLogger(SudokuController.class);

    private final GameInitializer gameInitializer = new GameInitializer();

    @RequestMapping(value = "/{gameId}", method = RequestMethod.GET)
    public @ResponseBody Game loadGame(final @PathVariable Long gameId) {

        return gameInitializer.createGame(GameLevel.easy);
    }


    @RequestMapping(value = "/create/{level}", method = RequestMethod.PUT)
    public @ResponseBody Game createGame(final @PathVariable GameLevel level) {

        return gameInitializer.createGame(level);
    }


    @RequestMapping(value = "/validate/{gameId}", method = RequestMethod.POST)
    public @ResponseBody Move validateMove(final @PathVariable Long gameId, @RequestBody @Valid Move move) {

        return gameInitializer.createDummyM();
    }


}
