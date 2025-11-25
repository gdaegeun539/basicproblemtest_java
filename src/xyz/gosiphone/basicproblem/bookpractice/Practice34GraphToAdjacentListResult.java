package xyz.gosiphone.basicproblem.bookpractice;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice34GraphToAdjacentListResult {
    public static void main(String[] args) {
//        char[][] graph = {{'1', '2'}, {'2', '3'}, {'3', '4'}, {'4', '5'}};
//        int n = 5;
        char[][] graph = {{'1', '2'}, {'1', '3'}, {'2', '4'}, {'2', '5'}, {'3', '6'}, {'5', '6'}};
        int n = 6;

        ArrayList<Integer>[] newGraph = new ArrayList[n + 1];
        for (int idx = 0; idx < n + 1; idx++) {
            newGraph[idx] = new ArrayList<>();
        }

        for (char[] edge : graph) {
            newGraph[Character.getNumericValue(edge[0])].add(Character.getNumericValue(edge[1]));
        }

        System.out.println(Arrays.toString(newGraph));
    }
}
