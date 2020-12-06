package app;

import app.enigm.DayFive;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class DayFiveApp {

    public static void main(String args[]) throws IOException, URISyntaxException {
        List<String> puzzle = PuzzleReader.readPuzzle();
        System.out.println("The seat ID = " + DayFive.resolverPartOne(puzzle));

        System.out.println("Your seat ID = " + DayFive.resolverPartTwo(puzzle));
    }
}
