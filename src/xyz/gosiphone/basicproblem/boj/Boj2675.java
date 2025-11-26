package xyz.gosiphone.basicproblem.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Boj2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());

        for (int times = 0; times < t; times++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken());
            String s = st.nextToken();

            StringBuilder result = new StringBuilder();
            for (int index = 0; index < s.length(); index++) {
                result.append(String.valueOf(s.charAt(index)).repeat(r));
            }
            System.out.println(result);
        }
    }
}

/*
* 1. 테스트케이스만큼 순회 돌기
* 2. 반복 횟수와 문자열을 분해해서 받기
* 3. 문자열을 순회
* 4. 새로운 문자열에 지금 순회하는 문자를 지정 횟수만큼 뒤에 붙이기 (`String.valueOf(s.charAt(index)).repeat(r)`)
* */