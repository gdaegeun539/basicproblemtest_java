package xyz.gosiphone.basicproblem;

/**
 * <h3>무게와 가치가 있는 짐이 주어질 때 부분 배낭 문제를 푸는 `solution()`을 작성하시오.</h3>
 * <p>
 *     제약 조건
 *     <ul>
 *         <li>베낭의 무게 제한(weightLimit)은 1 이상 10000 이하의 정수이다.</li>
 *         <li>짐(items)의 수는 1 이상 1000 이하이다.</li>
 *     </ul>
 * </p>
 * */
public class Practice78FractionalKnapsack {
    private static double solution(int[][] items, int weightLimit) {
        return -1.0;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{10, 19}, {7, 10}, {6, 10}}, 15)); // 27.33
        System.out.println(solution(new int[][] {{10, 60}, {20, 100}, {30, 120}}, 50)); // 240
    }
}
