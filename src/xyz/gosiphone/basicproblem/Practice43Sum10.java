package xyz.gosiphone.basicproblem;

import java.util.ArrayList;

/**
 * """틀림(다시풀것)"""
 * 정수 n을 입력받아 1부터 n까지의 숫자 합 중에서 10이 되는 조합을 리스트로 반환하는 solution() 메소드를 반환하세요.
 * <p></p>
 * ### 제약 조건
 * - n은 1 이상 10 이하의 정수입니다.
 * - 백트래킹 활용(백트래킹 연습문제)
 * - 숫자 조합은 오름차순으로 정렬되어야 합니다.
 * - 같은 숫자는 한 번만 선택 가능합니다.
 * ### 권장 풀이 시간, 시간 복잡도
 * 60분, O(n!)
 */
public class Practice43Sum10 {
    private static ArrayList<ArrayList<Integer>> solution(int n) {
        ArrayList<ArrayList<Integer>> answers = new ArrayList<>();
        int sum;
        ArrayList<Integer> tester = new ArrayList<>();

        for (int startNode = 1; startNode <= n; startNode++) {
            sum = 0;
            tester.clear();
            tester.add(startNode);
            sum += startNode;

            for (int nextNode = startNode + 1; nextNode <= n; nextNode++) {
                testFunc(nextNode, sum, n, tester, answers);
            }
        }
        return answers;
    }

    private static void testFunc(int node, int sum, int lastValue, ArrayList<Integer> tester, ArrayList<ArrayList<Integer>> answers) {
        if (node > lastValue) {
            // 혹여나 범위를 넘은 경우에는 나오도록 함
            return;
        }

        sum += node;
        tester.add(node);
        System.out.println("node: " + node + " sum: " + sum);

        if (sum > 10) {
            // 1. 지금까지의 합이 10보다 크면 return
            sum -= node;
//            tester.remove(Integer.valueOf(node));
            tester.clear();
        } else if (sum == 10) {
            // 2. 지금까지의 합이 10과 같으면 결과에 추가하고 retrun
            answers.add((ArrayList<Integer>) tester.clone());
            sum -= node;
//            tester.remove(Integer.valueOf(node));
            tester.clear();
        } else if (sum < 10) {
            // 3. 지금까지의 합이 10보다 작으면 계속 들어가기
            testFunc(node + 1, sum, lastValue, tester, answers);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(5)); // [[1,2,3,4],[1,4,5],[2,3,5]]
        System.out.println("=======================");
        System.out.println(solution(2)); // []
        System.out.println("=======================");
        System.out.println(solution(7)); // [[1,2,3,4],[1,2,7],[1,3,6],[1,4,5],[2,3,5],[3,7],[4,6]]
    }
}
