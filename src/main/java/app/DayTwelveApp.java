package app;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayTwelveApp {

    public static void main(String args[]) throws IOException, URISyntaxException {
        List<String> puzzle = PuzzleReader.readPuzzle();

        Map<Character, Integer> directions = new HashMap<>();
        directions.put('E', 0);
        directions.put('W', 0);
        directions.put('N', 0);
        directions.put('S', 0);

        char currentDirection = 'E';

        for (String input : puzzle) {
            char direction = input.charAt(0);
            int units = Integer.valueOf(input.substring(1));

            if (direction == 'N'){
                updateDirections('N', units, directions);
            } else if (direction == 'S'){
                updateDirections('S', units, directions);
            } else if (direction == 'E'){
                updateDirections('E', units, directions);
            } else if (direction == 'W'){
                updateDirections('W', units, directions);
            } else if (direction == 'F') {
                updateDirections(currentDirection, units, directions);
            } else if (direction == 'L') {
                if(units == 90){
                    if(currentDirection == 'E')
                        currentDirection = 'N';
                    else if (currentDirection == 'N')
                        currentDirection = 'W';
                    else if (currentDirection == 'W')
                        currentDirection = 'S';
                    else if (currentDirection == 'S')
                        currentDirection = 'E';
                } else if (units == 180) {
                    if(currentDirection == 'E')
                        currentDirection = 'W';
                    else if (currentDirection == 'N')
                        currentDirection = 'S';
                    else if (currentDirection == 'W')
                        currentDirection = 'E';
                    else if (currentDirection == 'S')
                        currentDirection = 'N';
                } else if (units == 270) {
                    if(currentDirection == 'E')
                        currentDirection = 'S';
                    else if (currentDirection == 'N')
                        currentDirection = 'E';
                    else if (currentDirection == 'W')
                        currentDirection = 'N';
                    else if (currentDirection == 'S')
                        currentDirection = 'W';
                } else {
                    System.out.println("Undefined value = " + units);
                }
            } else if (direction == 'R') {
                if(units == 90){
                    if(currentDirection == 'E')
                        currentDirection = 'S';
                    else if (currentDirection == 'N')
                        currentDirection = 'E';
                    else if (currentDirection == 'W')
                        currentDirection = 'N';
                    else if (currentDirection == 'S')
                        currentDirection = 'W';
                } else if (units == 180) {
                    if(currentDirection == 'E')
                        currentDirection = 'W';
                    else if (currentDirection == 'N')
                        currentDirection = 'S';
                    else if (currentDirection == 'W')
                        currentDirection = 'E';
                    else if (currentDirection == 'S')
                        currentDirection = 'N';
                } else if (units == 270) {
                    if(currentDirection == 'E')
                        currentDirection = 'N';
                    else if (currentDirection == 'N')
                        currentDirection = 'W';
                    else if (currentDirection == 'W')
                        currentDirection = 'S';
                    else if (currentDirection == 'S')
                        currentDirection = 'E';
                }
                else {
                    System.out.println("Undefined value = " + units);
                }
            }
        }

        //Calcul final
        int ew = 0;
        if(directions.get('E') > directions.get('W')){
            ew = directions.get('E') - directions.get('W');
        } else {
            ew = directions.get('W') - directions.get('E');
        }

        int ns = 0;
        if(directions.get('N') > directions.get('S')){
            ns = directions.get('N') - directions.get('S');
        } else {
            ns = directions.get('S') - directions.get('N');
        }
        System.out.println(ew + ns);
    }

    private static final void updateDirections(char direction, int units, Map<Character, Integer> directions) {
        int temp = directions.get(direction);
        temp += units;
        directions.put(direction, temp);
    }
}
