package xyz.gosiphone.basicproblem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<Integer> a = new ArrayList<>();

        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        for (int idx = 0; idx < n; idx++) {
            a.add(Integer.parseInt(st2.nextToken()));
        }

        ArrayList<Integer> smallerNumbers = new ArrayList<>();
        for (int num: a) {
            if (num < x) {
                smallerNumbers.add(num);
            }
        }

        for(int result: smallerNumbers) {
            System.out.print(result + " ");
        }
    }
}
