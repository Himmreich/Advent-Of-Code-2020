package app;

import app.enigm.DayEight;
import app.enigm.DayFive;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class DayEightApp {

    public static void main(String args[]) throws IOException, URISyntaxException {
        List<String> puzzle = PuzzleReader.readPuzzle();
        System.out.println("The first response is = " + DayEight.resolverPartOne(puzzle));

        System.out.println("Your second response is = " + DayEight.resolverPartTwo(puzzle));
    }
}
