package xyz.gosiphone.basicproblem.bookpractice;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * DFS로 모든 그래프의 노드를 순회하는 메소드 `solution()`을 작성하세요.
 * 시작 노드는 start로 주어집니다.
 * graph는 [출발 노드, 도착 노드] 쌍들이 들어있는 리스트입니다.
 * <p></p>
 * ### 제약 조건
 * - 노드의 개수는 1 이상 100개 이하입니다.
 * - n은 노드의 개수입니다.
 * - 고립된 노드는 없습니다.
 * - 그래프의 노드는 문자열입니다.
 * <p></p>
 * ### 반환 값
 * - 그래프의 시작 노드부터 모든 노드를 DFS로 진행한 순서대로 노드가 저장된 리스트입니다.
 */
public class Practice34BasicDfs {

    private static Integer[] solution(char[][] graph, char start, int n) {
        Boolean[] visitCheck = new Boolean[n + 1];
        ArrayDeque<Integer> calcWaitStack = new ArrayDeque<>();
        calcWaitStack.addFirst(Character.getNumericValue(start));

        ArrayList<Integer> result = new ArrayList<>();

        while (!calcWaitStack.isEmpty()) {
            int pollNode = calcWaitStack.pollFirst();
            if (visitCheck[pollNode] == null) {
                visitCheck[pollNode] = true;
                result.add(pollNode);
            }

            // 효율적으로 인접 노드를 넣는 방법?
            for (char[] subGraph : graph) {
                if (subGraph[0] == Character.forDigit(pollNode, 10)) {
                    calcWaitStack.addFirst(Character.getNumericValue(subGraph[1]));
                }
            }

            System.out.println(calcWaitStack);
        }

        return result.toArray(new Integer[]{});
    }

    public static void main(String[] args) {
        char[][] graph1 = {{'1', '2'}, {'2', '3'}, {'3', '4'}, {'4', '5'}};
        System.out.println(Arrays.toString(solution(graph1, '1', 5)));
        char[][] graph2 = {{'1', '2'}, {'1', '3'}, {'2', '4'}, {'2', '5'}, {'3', '6'}, {'5', '6'}};
        System.out.println(Arrays.toString(solution(graph2, '1', 6)));
    }
}
