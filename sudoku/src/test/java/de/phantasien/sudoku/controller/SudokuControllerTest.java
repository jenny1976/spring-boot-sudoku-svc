package de.phantasien.sudoku.controller;

import de.phantasien.sudoku.model.Move;
import de.phantasien.sudoku.model.MoveResult;
import de.phantasien.sudoku.model.Cell;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author jschulz
 */
public class SudokuControllerTest {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger LOG = Logger.getLogger(SudokuControllerTest.class);



    private MockMvc mvc;

    public SudokuControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new SudokuController()).build();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreateGame() throws Exception {

        MvcResult andReturn = mvc.perform(MockMvcRequestBuilders.put("/sudoku/create/easy").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.xpath("/Game").exists())
//                .andExpect(MockMvcResultMatchers.xpath("/Game/movesCount").exists())
//                .andExpect(MockMvcResultMatchers.xpath("/Game/movesCount").number(0D))
//                .andExpect(MockMvcResultMatchers.xpath("/Game/gameState").exists())
//                .andExpect(MockMvcResultMatchers.xpath("/Game/gameState").string("ongoing"))
//                .andExpect(MockMvcResultMatchers.xpath("/Game/gameLevel").exists())
//                .andExpect(MockMvcResultMatchers.xpath("/Game/gameLevel").string("medium"))
//                .andExpect(MockMvcResultMatchers.xpath("/Game/board").exists())

                .andReturn();

        LOG.log(Level.INFO, "response as string: "+ andReturn.getResponse().getContentAsString());
    }

    @Test
    public void testValidateMove() throws Exception {
        Move move = new Move(new Cell(1, 1, 8, false), 9, MoveResult.invalid);

        MvcResult andReturn = mvc.perform(MockMvcRequestBuilders.post("/sudoku/validate/111").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{}")
        )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.xpath("/Move/square/rowNum").exists())
//                .andExpect(MockMvcResultMatchers.xpath("/Move/square/rowNum").number(1D))
//                .andExpect(MockMvcResultMatchers.xpath("/Move/square/colNum").exists())
//                .andExpect(MockMvcResultMatchers.xpath("/Move/square/colNum").number(1D))
//                .andExpect(MockMvcResultMatchers.xpath("/Move/square/value").exists())
//                .andExpect(MockMvcResultMatchers.xpath("/Move/square/value").number(8D))
//                .andExpect(MockMvcResultMatchers.xpath("/Move/square/preset").exists())
//                .andExpect(MockMvcResultMatchers.xpath("/Move/input").exists())
//                .andExpect(MockMvcResultMatchers.xpath("/Move/input").number(9D))
//                .andExpect(MockMvcResultMatchers.xpath("/Move/moveResult").exists())
//                .andExpect(MockMvcResultMatchers.xpath("/Move/moveResult").string("valid"))
                .andReturn();


        LOG.log(Level.INFO, "response as string: "+ andReturn.getResponse().getContentAsString());
    }

    @Test
    public void testLoadGame() throws Exception {

        MvcResult andReturn = mvc.perform(MockMvcRequestBuilders.get("/sudoku/111").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.xpath("/Game").exists())
//                .andExpect(MockMvcResultMatchers.xpath("/Game/movesCount").exists())
//                .andExpect(MockMvcResultMatchers.xpath("/Game/gameState").exists())
//                .andExpect(MockMvcResultMatchers.xpath("/Game/gameLevel").exists())
//                .andExpect(MockMvcResultMatchers.xpath("/Game/board").exists())
//                .andExpect(MockMvcResultMatchers.xpath("/Game/movesCount").string("0"))
                .andReturn();

        LOG.log(Level.INFO, "response as string: "+ andReturn.getResponse().getContentAsString());
    }

}
