package app;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PuzzleReader {

    public static List<String> readPuzzle() throws URISyntaxException, IOException {
        List<String> puzzleLines = new ArrayList<String>();

        Path path = Paths.get(PuzzleReader.class.getClassLoader().getResource("input7.txt").toURI());
        puzzleLines = FileUtils.readLines(path.toFile(), "UTF-8");

        return puzzleLines;
    }
}
