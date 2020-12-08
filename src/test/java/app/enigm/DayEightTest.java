package app.enigm;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

public class DayEightTest extends TestCase {

    public void testResolver1() {
        List<String> puzzle = Arrays.asList("nop +0" ,
                "acc +1" ,
                "jmp +4" ,
                "acc +3" ,
                "jmp -3" ,
                "acc -99" ,
                "acc +1" ,
                "jmp -4" ,
                "acc +6");
        Assert.assertEquals(5 ,DayEight.resolverPartOne(puzzle).intValue());
    }

    public void testResolver2() {
        List<String> puzzle = Arrays.asList("nop +0" ,
                "acc +1" ,
                "jmp +4" ,
                "acc +3" ,
                "jmp -3" ,
                "acc -99" ,
                "acc +1" ,
                "nop -4" ,
                "acc +6");
        Assert.assertEquals(8 ,DaySix.resolverPartTwo(puzzle));
    }
}
