package app;

import app.enigm.DayThree;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class DayThreeApp {

    public static void main(String args[]) throws IOException, URISyntaxException {
        List<String> puzzle = PuzzleReader.readPuzzle();
        int nbTrees = DayThree.resolver(puzzle, 3, 1);
        System.out.println("Number of trees = " + nbTrees);

        nbTrees = DayThree.resolver(puzzle, 1, 1);
        nbTrees = nbTrees * DayThree.resolver(puzzle, 3, 1);
        nbTrees = nbTrees * DayThree.resolver(puzzle, 5, 1);
        nbTrees = nbTrees * DayThree.resolver(puzzle, 7, 1);
        nbTrees = nbTrees * DayThree.resolver(puzzle, 1, 2);

        System.out.println("Number of trees = " + nbTrees);
    }
}
