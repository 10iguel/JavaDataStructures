package edu.ensign.cs235.queue;

import java.util.ArrayList;
import java.util.Scanner;

public class Functions {
    public static void main(String[] args) {
        ArrayList<Integer> numbersArray = new ArrayList<>();
        numbersArray.add(1);
        numbersArray.add(45);
        numbersArray.add(21);
        numbersArray.add(41);
        numbersArray.add(84);
        numbersArray.add(62);
        int[] numbers = {1,2,3,4,5,6,7};
        //System.out.println(biggestNumber(numbersArray));
        System.out.println(fibonacci(7));

    }
    public static int fibonacci(int num){
        if (num <= 1)
            return num;

        return fibonacci(num-1) + fibonacci(num-2);
    }
}
