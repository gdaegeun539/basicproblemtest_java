package xyz.gosiphone.basicproblem.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Boj4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] triangle = new int[3];
        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int index = 0; index < 3; index++) {
                triangle[index] = Integer.parseInt(st.nextToken());
            }

            if (triangle[0] == 0 && triangle[1] == 0 && triangle[2] == 0) {
                break;
            }

            int maxLen = Math.max(Math.max(triangle[0], triangle[1]), triangle[2]);

            int maxSquare;
            int othersSquare;

            if (maxLen == triangle[0]) {
                maxSquare = maxLen * maxLen;
                othersSquare = (triangle[1] * triangle[1]) + (triangle[2] * triangle[2]);
            } else if (maxLen == triangle[1]) {
                maxSquare = maxLen * maxLen;
                othersSquare = (triangle[0] * triangle[0]) + (triangle[2] * triangle[2]);
            } else {
                maxSquare = maxLen * maxLen;
                othersSquare = (triangle[0] * triangle[0]) + (triangle[1] * triangle[1]);
            }

            if (maxSquare == othersSquare) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}

/*
* 900000
* 21억 42억
* 시간 복잡도나 공간 복잡도를 크게 신경 쓸 문제는 아닌 듯 하다.
* 테케 개수는 안 알려줬네 이를 신경쓰지 않는 방향으로 흐름을 짜 보자
* */
/*
* 1. 세 수를 입력받는다.
* 1-1. 세 수가 모두 0이라면 프로그램을 끝낸다.
* 2. 세 수 중 제일 큰 수를 구한다.
* 2-1. 여기서 나머지 두 수를 어떻게 접근할 지를 생각한다. (근데 3개면 노가다로 해도 될 지도)
* 2-2. 값이 무한하면 패턴매칭이나 다른 방법을 시도할 수 있지만, 3개이면 조건문 비교가 빠르다고 생각한다.
* 3. 나머지 두 수의 제곱과 제일 큰 수의 제곱의 값을 비교한다.
* 4. 결과를 출력한다.
* */
