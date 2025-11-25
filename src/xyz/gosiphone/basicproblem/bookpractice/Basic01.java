package xyz.gosiphone.basicproblem.bookpractice;

import java.util.Arrays;

public class Basic01 {
    public static void main(String[] args) {
        int[] sampleArray = new int[100000];
        for (int i = 1 ; i <= 100000; i++ ){
            sampleArray[i - 1] = (int) (Math.random() * 100000);
        }

        Long start = System.currentTimeMillis();

        Arrays.sort(sampleArray);

        Long end = System.currentTimeMillis();

        System.out.println("\n\n\n"+ Arrays.toString(sampleArray) +"\n\n\n");

        System.out.println((end - start) / 1000.0);
    }
}
