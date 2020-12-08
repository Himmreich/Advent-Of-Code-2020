package app;

import app.PuzzleReader;
import app.enigm.DaySix;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class DaySixApp {

    public static void main(String args[]) throws IOException, URISyntaxException {
        List<String> puzzle = PuzzleReader.readPuzzle();
        System.out.println("The first response is = " + DaySix.resolverPartOne(puzzle));

        System.out.println("The second response is = " + DaySix.resolverPartTwo(puzzle));
    }
}
