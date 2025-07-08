package xyz.gosiphone.basicproblem;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class Basic02 {
    private void sample() {
        int[] sampleArr = new int[100000];

        Integer[] newArray = (Integer[]) Arrays.stream(sampleArr).boxed().distinct().toArray();

        Arrays.sort(newArray, Collections.reverseOrder());

        int[] finalArray = new int[100000];

        for(int i = 0; i < newArray.length; i++){
            finalArray[i] = newArray[(newArray.length - 1) - i];
        }

    }

    private int[] forSample(int[] paramArr){

        TreeSet<Integer> sampleSet = new TreeSet<>(Collections.reverseOrder());

        for(int num : paramArr){
            sampleSet.add(num);
        }

        return new int[0];
    }

    public static void main(String[] args) {

    }
}
