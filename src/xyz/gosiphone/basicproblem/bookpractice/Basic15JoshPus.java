package xyz.gosiphone.basicproblem.bookpractice;

import java.util.ArrayDeque;

/**
 * n명의 사람이 원 형태로 서 있습니다. 각 사람은 1부터 n까지 번호표를 갖고 있습니다.
 * 그리고 임의의 숫자 k가 주어졌을 때 아래와 같이 사람을 없앱니다.
 * <p/>
 * - 1번 번호표를 가진 사람을 기준으로 k번째 사람을 없앱니다.
 * - 없앤 사람 다음 사람을 기준으로 하고 다시 k번째 사람을 없앱니다.
 * <p/>
 * n과 k가 주어질 때, 마지막에 살아있는 사람의 번호를 반환하는 `solution()` 메소드를 구현하세요.
 * <p/>
 * 제약 조건: n, k는 1 이상 1000 이하의 자연수입니다.
 * e.g. n=5, k=2 -> return 3
 * 권장 풀이 시간: 30분
 */
public class Basic15JoshPus {
    public static void main(String[] args) {
        int result1 = solution(5, 2);
        System.out.println(result1);
        int result2 = solution(30, 450);
        System.out.println(result2);
        int result3 = solution(999, 999);
        System.out.println(result3);
    }

    private static int solution(int n, int k) {
        ArrayDeque<Integer> circularDeque = new ArrayDeque<>();

        for (int idx = 1; idx <= n; idx++) {
            circularDeque.addFirst(idx);
        }

        int removeIteration = 1;
        while (circularDeque.size() > 1) {
            int nowRemover = circularDeque.pollLast();
            if (removeIteration != k) {
                circularDeque.addFirst(nowRemover);
                removeIteration += 1;
            } else {
                removeIteration = 1;
            }
        }

        try {
            return circularDeque.pollLast();
        } catch (NullPointerException e) {
            return -1;
        }
    }
}
