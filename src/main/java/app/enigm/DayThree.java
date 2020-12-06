package app.enigm;

import java.util.ArrayList;
import java.util.List;

public class DayThree {

    public static int resolver(List<String> puzzle, int initPos, int initLine) {
        int nbTrees = 0;
        List<String> newLines = new ArrayList<>();
        newLines.add(puzzle.get(0));
        int pos = 0;
        int i = 0;
        while (i < puzzle.size()) {
            if(i+initLine >= puzzle.size()) break;
            pos = pos + initPos;
            if(pos >= puzzle.get(i).length()) pos = pos - puzzle.get(i).length();
            if(puzzle.get(i + initLine).charAt(pos) == '#'){
                nbTrees++;
                StringBuilder newLine = new StringBuilder(puzzle.get(i + initLine));
                newLine.setCharAt(pos, 'X');
                newLines.add(newLine.toString());
            } else {
                StringBuilder newLine = new StringBuilder(puzzle.get(i + initLine));
                newLine.setCharAt(pos, 'O');
                newLines.add(newLine.toString());
            }
            //System.out.println(newLines.get(i));
            i = i + initLine;
        }
        return nbTrees;
    }
}
