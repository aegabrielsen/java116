package tests;

import org.junit.Test;
import ratings.ProblemSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestProblemSet {

    // TODO: Write testing for all 3 methods of the ratings.ProblemSet class

        @Test
        public void averageTest1() {
            ArrayList<Double> arrayTestNumbers = new ArrayList<>();
            assertEquals(ProblemSet.average(arrayTestNumbers), 0.0, 0.0001);
        }
        @Test
        public void averageTest2() {
            ArrayList<Double> arrayTestNumbers = new ArrayList<>();
            arrayTestNumbers.add(1.0);
            assertEquals(ProblemSet.average(arrayTestNumbers), 1.0, 0.0001);
        }
        @Test
        public void averageTest3() {
            ArrayList<Double> arrayTestNumbers = new ArrayList<>();
            arrayTestNumbers.add(1.0);
            arrayTestNumbers.add(2.0);
            arrayTestNumbers.add(3.0);
            assertEquals(ProblemSet.average(arrayTestNumbers), 2.0, 0.0001);
        }
                @Test
        public void averageTest4() {
            ArrayList<Double> arrayTestNumbers = new ArrayList<>();
            arrayTestNumbers.add(-1.0);
            arrayTestNumbers.add(-2.0);
            arrayTestNumbers.add(-3.0);
            assertEquals(ProblemSet.average(arrayTestNumbers), -2.0, 0.0001);
        }

    @Test
    public void averageTest5() {
        ArrayList<Double> arrayTestNumbers = new ArrayList<>();
        arrayTestNumbers.add(-2.0);
        arrayTestNumbers.add(-1.0);
        arrayTestNumbers.add(0.0);
        arrayTestNumbers.add(1.0);
        arrayTestNumbers.add(2.0);
        assertEquals(ProblemSet.average(arrayTestNumbers), 0.0, 0.0001);
    }

    @Test
    public void averageTest6() {
        ArrayList<Double> arrayTestNumbers = new ArrayList<>();
        for (double i = 0.0; i < 100000.0; i += 1.0) {
            arrayTestNumbers.add(i);
        }
        assertEquals(ProblemSet.average(arrayTestNumbers), 49999.5, 0.0001);
    }

//        above for average

    @Test
public void sumOfDigitsTest1() {
        int digitTestNumbers = 0;
    assertTrue(ProblemSet.sumOfDigits(Math.abs(digitTestNumbers)) == 0);
}
    @Test
public void sumOfDigitsTest2() {
        int digitTestNumbers = 627;
    assertTrue(ProblemSet.sumOfDigits(Math.abs(digitTestNumbers)) == 15);
}
    @Test
public void sumOfDigitsTest3() {
        int digitTestNumbers = -37;
    assertTrue(ProblemSet.sumOfDigits(Math.abs(digitTestNumbers)) == 10);
}

    @Test
    public void sumOfDigitsTest4() {
        int digitTestNumbers = 1;
        assertTrue(ProblemSet.sumOfDigits(Math.abs(digitTestNumbers)) == 1);
    }

    @Test
    public void sumOfDigitsTest5() {
        int digitTestNumbers = 7;
        assertTrue(ProblemSet.sumOfDigits(Math.abs(digitTestNumbers)) == 7);
    }

    @Test
    public void sumOfDigitsTest6() {
        int digitTestNumbers = 100000;
        assertTrue(ProblemSet.sumOfDigits(Math.abs(digitTestNumbers)) == 1);
    }

// above for sumOfDigits
@Test
public void bestKeyTest1() {
    HashMap<String, Integer> largestHashTestNumber = new HashMap<>();
    assertEquals("", ProblemSet.bestKey(largestHashTestNumber));
}
@Test
public void bestKeyTest2() {
    HashMap<String, Integer> largestHashTestNumber = new HashMap<>();
    largestHashTestNumber.put("CSE", -24);
    largestHashTestNumber.put("MTH", -100);
    largestHashTestNumber.put("CAT", -1);
    largestHashTestNumber.put("DOG", -30);
    assertEquals("CAT", ProblemSet.bestKey(largestHashTestNumber));
}
@Test
public void bestKeyTest3() {
    HashMap<String, Integer> largestHashTestNumber = new HashMap<>();
    largestHashTestNumber.put("CSE", 10);
    largestHashTestNumber.put("MTH", 20);
    largestHashTestNumber.put("CAT", 300);
    largestHashTestNumber.put("DOG", 300);
//    assertEquals("CAT", ProblemSet.bestKey(largestHashTestNumber));
//    assertThat(ProblemSet.bestKey(largestHashTestNumber), isOneOf("CAT", "DOG"));
    assertTrue(ProblemSet.bestKey(largestHashTestNumber).equals("DOG") || ProblemSet.bestKey(largestHashTestNumber).equals("CAT"));
}
@Test
public void bestKeyTest4() {
    HashMap<String, Integer> largestHashTestNumber = new HashMap<>();
    largestHashTestNumber.put("CAT", 1);
    assertEquals("CAT", ProblemSet.bestKey(largestHashTestNumber));
}
@Test
public void bestKeyTest5() {
    HashMap<String, Integer> largestHashTestNumber = new HashMap<>();
    largestHashTestNumber.put("CAT", 0);
    assertEquals("CAT", ProblemSet.bestKey(largestHashTestNumber));
}

}
