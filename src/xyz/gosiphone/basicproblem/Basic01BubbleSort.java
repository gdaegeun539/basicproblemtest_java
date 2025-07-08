package xyz.gosiphone.basicproblem;

import java.util.Arrays;

public class Basic01BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] sampleArray = new int[100000];
        for (int i = 1 ; i <= 100000; i++ ){
            sampleArray[i - 1] = (int) (Math.random() * 100000);
        }

        int[] bubbleSortedSampleArray = sampleArray.clone();

        Long start = System.currentTimeMillis();

        bubbleSort(bubbleSortedSampleArray);

        Long end = System.currentTimeMillis();

        System.out.println("\n\n\n"+ Arrays.toString(bubbleSortedSampleArray) +"\n\n\n");

        System.out.println((end - start) / 1000.0);

        Arrays.sort(sampleArray);

        System.out.println(Arrays.equals(bubbleSortedSampleArray, sampleArray));
    }
}
