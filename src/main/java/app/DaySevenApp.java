package app;

import app.enigm.DaySeven;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class DaySevenApp {

    public static void main(String args[]) throws IOException, URISyntaxException {
        List<String> puzzle = PuzzleReader.readPuzzle();
        System.out.println("The seat ID = " + DaySeven.resolverPartOne(puzzle));

        System.out.println("Your seat ID = " + DaySeven.resolverPartTwo(puzzle));
    }
}
