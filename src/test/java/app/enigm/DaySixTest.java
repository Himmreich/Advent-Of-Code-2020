package app.enigm;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class DaySixTest extends TestCase {

    public void testResolver1() {
        List<String> puzzle = Arrays.asList("abc", "", "a", "b", "c", "", "ab", "ac", "", "a", "a", "a", "a", "", "b");
        Assert.assertEquals(11 ,DaySix.resolverPartOne(puzzle));
    }

    public void testResolver2() {
        List<String> puzzle = Arrays.asList("abc", "", "a", "b", "c", "", "ab", "ac", "", "a", "a", "a", "a", "", "b");
        Assert.assertEquals(6 ,DaySix.resolverPartTwo(puzzle));
    }
}
