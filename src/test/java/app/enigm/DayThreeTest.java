package app.enigm;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class DayThreeTest extends TestCase {


    public void testResolver1() {
        List<String> puzzle = Arrays.asList("..##.......",
                                            "#...#...#..",
                                            ".#....#..#.",
                                            "..#.#...#.#",
                                            ".#...##..#.",
                                            "..#.##.....",
                                            ".#.#.#....#",
                                            ".#........#",
                                            "#.##...#...",
                                            "#...##....#",
                                            ".#..#...#.#");

        int result = DayThree.resolver(puzzle, 1, 1);
        Assert.assertEquals(2, result);
    }

    public void testResolver2() {
        List<String> puzzle = Arrays.asList("..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#");

        int result = DayThree.resolver(puzzle, 3, 1);
        Assert.assertEquals(7, result);
    }

    public void testResolver3() {
        List<String> puzzle = Arrays.asList("..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#");

        int result = DayThree.resolver(puzzle, 5, 1);
        Assert.assertEquals(3, result);
    }

    public void testResolver4() {
        List<String> puzzle = Arrays.asList("..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#");

        int result = DayThree.resolver(puzzle, 7, 1);
        Assert.assertEquals(4, result);
    }

    public void testResolver5() {
        List<String> puzzle = Arrays.asList("..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#");

        int result = DayThree.resolver(puzzle, 1, 2);
        Assert.assertEquals(2, result);
    }

    public void testResolver6() {
        List<String> puzzle = Arrays.asList("..##.......",
                "#...#...#..",
                ".#....#..#.",
                "..#.#...#.#",
                ".#...##..#.",
                "..#.##.....",
                ".#.#.#....#",
                ".#........#",
                "#.##...#...",
                "#...##....#",
                ".#..#...#.#");

        int result1 = DayThree.resolver(puzzle, 1, 1);
        int result2 = DayThree.resolver(puzzle, 3, 1);
        int result3 = DayThree.resolver(puzzle, 5, 1);
        int result4 = DayThree.resolver(puzzle, 7, 1);
        int result5 = DayThree.resolver(puzzle, 1, 2);

        int result = result1 * result2 * result3 * result4 * result5;
        Assert.assertEquals(336, result);
    }
}
