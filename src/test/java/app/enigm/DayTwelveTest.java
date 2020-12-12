package app.enigm;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class DayTwelveTest extends TestCase {

    public void testResolver1() {
        List<String> puzzle = Arrays.asList("F10", "N3", "F7", "R90", "F11");

        int east = 0;
        int north = 0;
        int south = 0;
        int west = 0;
        char currentDir = 'E';

        for (String input : puzzle) {
            char direction = input.charAt(0);
            int units = Integer.valueOf(input.substring(1));
            if (direction == 'N') {

            } else if (direction == 'S') {

            } else if (direction == 'E') {

            } else if (direction == 'W') {

            } else if (direction == 'L') {
                if(units == 90)
                    if(currentDir == 'E')
                        currentDir = 'N';
                if(units == 180)
                    if(currentDir == 'E')
                        currentDir = 'W';
            } else if (direction == 'R') {

            } else if (direction == 'F') {
                if(currentDir == 'E')
                    east = units - west + east;
                else if(currentDir == 'N')
                    north = units - south + north;
                else if (currentDir == 'W')
                    west = units - east + west;
                else if(currentDir == 'S')
                    south = units - north + south;
            }
        }
    }
}
