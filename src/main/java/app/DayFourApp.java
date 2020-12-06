package app;

import app.enigm.DayFour;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class DayFourApp {

    public static void main(String args[]) throws IOException, URISyntaxException {
        List<String> puzzle = PuzzleReader.readPuzzle();
        List<Map<String, String>> validPassports = DayFour.resolver(puzzle);

        System.out.println("Number of valid passports = " + validPassports.size());

        int counter = 0;
        for(Map<String, String> passport : validPassports) {
            if(DayFour.checkPassportDatas(passport))
                counter++;
        }

        System.out.println("Number of valid passports = " + counter);
    }
}
