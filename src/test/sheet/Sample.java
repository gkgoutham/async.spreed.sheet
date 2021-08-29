package org.gk;

import java.util.*;

public class Sample {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("Hello", 2);
        map.put("Answer", 3);
        map.put("abcd", 5);

        int numberOfSamples = map.values().stream().reduce((a,b)-> a+b).get();

        for(Map.Entry<String, Integer> e: map.entrySet()) {
            System.out.println(e.getKey());
            int monteCarloProbability = (e.getValue() * 100) / numberOfSamples;
            System.out.println(monteCarloProbability);

        }

       /* List<Integer> valuesList = new ArrayList<Integer>(map.values());
        int randomIndex = new Random().nextInt(valuesList.size());
        Integer randomValue = valuesList.get(randomIndex);

        System.out.println(randomValue);*/
    }

    // Random Function to that returns 0 or 1 with
    // equal probability
    static int rand50()
    {
        // rand() function will generate odd or even
        // number with equal probability. If rand()
        // generates odd number, the function will
        // return 1 else it will return 0.
        return (int) (10 * Math.random()) & 1;
    }

    // Random Function to that returns 1 with 75%
    // probability and 0 with 25% probability using
    // Bitwise OR
    static int rand75()
    {
        return rand50() | rand50();
    }

    // Driver code
/*
    public static void main(String[] args)
    {
        // Initialize random number generator
        //srand(time(null));

        for (int i = 0; i < 50; i++)
        {
            System.out.print(rand75());
        }

    }
*/

}
