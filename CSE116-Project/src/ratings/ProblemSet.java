package ratings;

import java.util.ArrayList;
import java.util.HashMap;

public class ProblemSet {


    public static double average(ArrayList<Double> numbers) {
        if (numbers.isEmpty()) {
            return 0.0;
        } else {
            double sum = 0.0;
            double total = 0.0;
            while (!numbers.isEmpty()) {
                double remove = numbers.remove(0);
                sum += remove;
                ++total;
                //System.out.println(sum + " " + total);
            }
            return sum / total;
        }
        // TODO: Implement this method to return the average of all the numbers in the input ArrayList
        //       If the ArrayList is empty, return 0.0
        //
        // Examples
        // [1.0,2.0,3.0] returns 2.0
        // [-5.0,5.0] returns 0.0
        // [6.5,6.5,8.5,8.5] returns 7.5
        // [] returns 0.0

    }

    public static int sumOfDigits(int numbers) {
        int sum = 0;
        int digit = 0;
        int numbers2 = Math.abs(numbers);
        while (numbers2 > 0) {
//            System.out.println(numbers);
            digit = numbers2 % 10;
            sum += digit;
            numbers2 /= 10;
        }
        return sum;
        // TODO: Write a public static method named sumOfDigits that takes an int as a parameter and
        //       returns the sum of the digits of the input as an int
        //
        // Examples
        // 123 returns 6
        // 57 returns 12
        // -36 returns 9
    }

    public static String bestKey(HashMap<String, Integer> numberMap) {
        if (numberMap.isEmpty()){
            return "";
        }
        int largestKey = Integer.MIN_VALUE;
        String largestKeyName = "";
        for (String i : numberMap.keySet()) {
            if (numberMap.get(i) > largestKey) {
                largestKey = numberMap.get(i);
                largestKeyName = i;
            }

//            System.out.println("key: " + i + " value: " + numberMap.get(i));
        }
//        System.out.println(largestKeyName);
//        System.out.println(largestKey);
    // TODO: Write a public static method named bestKey that takes a HashMap of String to Integer
    //       as a parameter and returns a key mapping to the largest Integer. Ties can be broken arbitrarily.
    //       If the HashMap is empty, return the empty String
    //
    // Examples
    // {"CSE": 100, "MTH": 90, "MGT": 10} returns "CSE"
    // {"cat": 5, "dog": 5, "fox": 4} can return either "cat" or "dog"
    // {} returns ""
        return largestKeyName;
}

//    public static void main(String[] args) {
//        ArrayList<Double> arrayNumbers = new ArrayList<>();
//        arrayNumbers.add(1.0);
//        arrayNumbers.add(2.0);
//        arrayNumbers.add(3.0);
//        arrayNumbers.add(4.0);
//        arrayNumbers.add(5.0);
//        System.out.println(average(arrayNumbers));
        // above is method 1

//       int digitNumbers = 0;
//        System.out.println(sumOfDigits(Math.abs(digitNumbers)));
        // above is method 2

//        HashMap<String, Integer> largestHashNumber = new HashMap<>();
//        largestHashNumber.put("CSE", 10);
//        largestHashNumber.put("MTH", 20);
//        largestHashNumber.put("CAT", 300);
//        largestHashNumber.put("DOG", 300);
//        System.out.println(largestHashNumber);
//        System.out.println(bestKey(largestHashNumber));


//    }

}
