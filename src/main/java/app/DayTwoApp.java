package app;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class DayTwoApp {

    public static void main(String args[]) throws IOException, URISyntaxException {
        List<String> puzzle = PuzzleReader.readPuzzle();
        int nbPasswordsValid = 0;
        for (String entry : puzzle) {
            String password = entry.split(":")[1].trim();
            String letter = entry.split(":")[0].split(" ")[1];
            String regex1 = entry.split(":")[0].split(" ")[0].split("-")[0];
            String regex2 = entry.split(":")[0].split(" ")[0].split("-")[1];

            int counter = 0;
            for(int i = 0; i < password.length(); i++) {
                if(password.charAt(i) == letter.charAt(0))
                    counter++;
            }
            if(counter >= Integer.parseInt(regex1) && counter <= Integer.parseInt(regex2))
                nbPasswordsValid++;

        }
        System.out.println("Nombre de mots de passes valides = " + nbPasswordsValid);
    }
}
