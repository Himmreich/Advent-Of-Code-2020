package app.enigm;

import java.util.ArrayList;
import java.util.List;

public class DayEight {

    public static Integer resolverPartOne(List<String> puzzle) {
        int accumulator = 0;
        boolean stop = false;
        int i = 0;
        List<Integer> lineRead = new ArrayList<>();
        do{
            if(lineRead.contains(i)){
                stop = true;
                continue;
            }
            System.out.println("Current line = " + puzzle.get(i));
            System.out.println("Line number = " + i);
            lineRead.add(i);
            String instruction = puzzle.get(i).split(" ")[0];
            Integer code = Integer.valueOf(puzzle.get(i).split(" ")[1]);
            switch (instruction) {
                case "nop":
                    i++;
                    break;
                case "acc":
                    accumulator = accumulator + code;
                    i++;
                    break;
                case "jmp":
                    i = i + code;
                    break;
                default:
                    break;
            }
        } while(stop == false);

        return accumulator;
    }

    public static Integer resolverPartTwo(List<String> puzzle) {
        int accumulator = 0;
        boolean stop = false;
        int i = 0;
        List<Integer> lineRead = new ArrayList<>();
        do{
            if(lineRead.contains(i)){
                stop = true;
                continue;
            }
            lineRead.add(i);
            String instruction = puzzle.get(i).split(" ")[0];
            Integer code = Integer.valueOf(puzzle.get(i).split(" ")[1]);

            System.out.println("Current line = " + puzzle.get(i));
            switch (instruction) {
                case "nop":
                    i++;
                    break;
                case "acc":
                    accumulator = accumulator + code;
                    i++;
                    break;
                case "jmp":
                    i = i + code;
                    break;
                default:
                    break;
            }
        } while(stop == false);

        return accumulator;
    }
    
}
