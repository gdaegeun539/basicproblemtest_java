package xyz.gosiphone.basicproblem.sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 표준입력 기억 안나서 내가 보려고 만든 코드 스니펫
 */
public class StdinPlayground {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 그 줄 자료가 통째로 필요할 때
        String line = reader.readLine();
        System.out.println(line);

        // 공백으로 구분한 자료를 받을 때
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        float y = Float.parseFloat(st.nextToken());
        double x = Double.parseDouble(st.nextToken());

        // 공백으로 구분한 자료를 한 줄에서 많이 받을 때
        StringTokenizer st2 = new StringTokenizer(reader.readLine());
        for (int idx = 0; idx < 30; idx++) {
            System.out.println(Integer.parseInt(st2.nextToken()));
        }
    }
}
