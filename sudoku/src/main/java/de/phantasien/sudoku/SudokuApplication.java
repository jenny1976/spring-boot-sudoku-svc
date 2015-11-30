package de.phantasien.sudoku;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SudokuApplication { //implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SudokuApplication.class, args);
    }

//    @Override
//    public void run(String... strings) throws Exception {
//        SpringApplication.run(SudokuApplication.class, strings).close();
//    }
}
