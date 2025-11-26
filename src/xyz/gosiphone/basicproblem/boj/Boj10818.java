package xyz.gosiphone.basicproblem.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        ArrayList<Integer> nums = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int iter = 0; iter < n; iter++) {
            int num = Integer.parseInt(st.nextToken());
            nums.add(num);
        }

        int maxResult = Collections.max(nums);
        int minResult = Collections.min(nums);
        System.out.println(minResult + " " + maxResult);
    }
}

/*
* 1. 첫 정수의 개수를 입력받기
* 2. 두 번째 정수를 순서대로 나누어 입력받기
* 3. (수도코드 아님) 그냥 내장 메소드를 이용해 스트림으로 변환해서 최대/최소값을 뽑아내기? 언어 잘 쓰는 것도 실력이야
* 3-1. 스트림으로 뽑을 필요도 없이 컬렉션단에서 지원해주네? (`Collections.max(nums)`, `Collections.min(nums)`)
* */
