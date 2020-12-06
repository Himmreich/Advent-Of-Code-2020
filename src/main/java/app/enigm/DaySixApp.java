package app.enigm;

import app.PuzzleReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class DaySixApp {

    public static void main(String args[]) throws IOException, URISyntaxException {
        List<String> puzzle = PuzzleReader.readPuzzle();
        System.out.println("" + DaySix.resolverPartOne(puzzle));

        System.out.println("" + DaySix.resolverPartTwo(puzzle));
    }
}
