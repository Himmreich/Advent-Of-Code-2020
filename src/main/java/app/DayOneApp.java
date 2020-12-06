package app;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class DayOneApp {

    public static void main(String args[]) throws IOException, URISyntaxException {
        List<String> puzzle = PuzzleReader.readPuzzle();
        for (String entry : puzzle) {
            for (String entry2 : puzzle) {
                if(Integer.parseInt(entry) + Integer.parseInt(entry2) == 2020) {
                    System.out.println("The first result is = " + Integer.parseInt(entry) * Integer.parseInt(entry2));
                    break;
                }
            }
        }

        for (String entry : puzzle) {
            for (String entry2 : puzzle) {
                for (String entry3 : puzzle) {
                    if(Integer.parseInt(entry) + Integer.parseInt(entry2) + Integer.parseInt(entry3) == 2020) {
                        System.out.println("The second result is = " + Integer.parseInt(entry) * Integer.parseInt(entry2) * Integer.parseInt(entry3));
                        break;
                    }
                }
            }
        }
    }
}
