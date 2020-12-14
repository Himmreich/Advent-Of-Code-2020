package app.enigm;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class DaySevenTest extends TestCase {

    public void testResolver1() {
        List<String> puzzle = Arrays.asList("light red bags contain 1 bright white bag, 2 muted yellow bags." ,
                "dark orange bags contain 3 bright white bags, 4 muted yellow bags." ,
                "bright white bags contain 1 shiny gold bag." ,
                "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags." ,
                "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags." ,
                "dark olive bags contain 3 faded blue bags, 4 dotted black bags." ,
                "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags." ,
                "faded blue bags contain no other bags." ,
                "dotted black bags contain no other bags.");
        System.out.println("The first result is = " + DaySeven.resolverPartOne(puzzle));
        Assert.assertEquals(DaySeven.resolverPartOne(puzzle), 4);
    }

    public void testResolver2() {

    }
}
