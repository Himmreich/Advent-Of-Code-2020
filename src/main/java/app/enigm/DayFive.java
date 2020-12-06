package app.enigm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayFive {

    public static Integer resolverPartOne(List<String> puzzle) {

        int seatID = 0;

        for(String boarding : puzzle) {
            int startRow = 0;
            int endRow = 127;
            int startColumn = 0;
            int endColumn = 7;

            for(char c : boarding.toCharArray()) {
                switch (c) {
                    case 'F':
                        endRow = endRow - (((endRow + 1) - startRow) / 2);
                        break;
                    case 'B':
                        startRow = startRow + (((endRow + 1) - startRow) / 2);
                        break;
                    case 'R':
                        startColumn = startColumn + (((endColumn + 1) - startColumn) / 2);
                        break;
                    case 'L':
                        endColumn = endColumn - (((endColumn + 1) - startColumn) / 2);
                        break;
                }
            }
            int currentSeatID = startRow * 8 + startColumn;
            if(currentSeatID > seatID) seatID = currentSeatID;
        }
        return seatID;
    }

    public static Integer resolverPartTwo(List<String> puzzle) {

        List<Integer> seats = new ArrayList<>();

        for(String boarding : puzzle) {
            int startRow = 0;
            int endRow = 127;
            int startColumn = 0;
            int endColumn = 7;

            for(char c : boarding.toCharArray()) {
                switch (c) {
                    case 'F':
                        endRow = endRow - (((endRow + 1) - startRow) / 2);
                        break;
                    case 'B':
                        startRow = startRow + (((endRow + 1) - startRow) / 2);
                        break;
                    case 'R':
                        startColumn = startColumn + (((endColumn + 1) - startColumn) / 2);
                        break;
                    case 'L':
                        endColumn = endColumn - (((endColumn + 1) - startColumn) / 2);
                        break;
                }
            }
            seats.add(startRow * 8 + startColumn);
        }
        Collections.sort(seats);
        int yourSeat = 0;

        int startSeat = seats.get(0);

        for(int i = 0; i < seats.size(); i++){
            Integer seat = seats.get(i);
            if(seat == startSeat) {
                startSeat++;
            } else {
                yourSeat = startSeat;
                break;
            }
        }
        return  yourSeat;
    }
}
