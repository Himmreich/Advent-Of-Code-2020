package app;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class DayTwoPart2App {
    public static void main(String args[]) throws IOException, URISyntaxException {
        List<String> puzzle = PuzzleReader.readPuzzle();
        int nbPasswordsValid = 0;
        for (String entry : puzzle) {
            String password = entry.split(":")[1].trim();
            String letter = entry.split(":")[0].split(" ")[1];
            String regex1 = entry.split(":")[0].split(" ")[0].split("-")[0];
            String regex2 = entry.split(":")[0].split(" ")[0].split("-")[1];

            if(password.charAt(Integer.parseInt(regex1) - 1) == letter.charAt(0) && password.charAt(Integer.parseInt(regex2) - 1) != letter.charAt(0))
                nbPasswordsValid++;
            else if(password.charAt(Integer.parseInt(regex1) - 1) != letter.charAt(0) && password.charAt(Integer.parseInt(regex2) - 1) == letter.charAt(0))
                nbPasswordsValid++;
        }
        System.out.println("Nombre de mots de passes valides = " + nbPasswordsValid);
    }
}
