package xyz.gosiphone.basicproblem.bookpractice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * BFS로 모든 노드를 순회하는 메소드 `solution()`을 작성하세요.
 * 시작 노드가 매개변수 start로 주어집니다.
 * (출발 노드, 도착 노드)쌍이 들어있는 리스트 graph가 매개변수로 주어집니다.
 * <p></p>
 * ### 제약 조건
 * - 노드는 1개 이상 100개 이하입니다.
 * - n은 노드의 개수입니다.
 * - 고립된 노드는 없습니다.
 * - 그래프의 노드는 숫자로 주어집니다.
 * ### 반환 값
 * - 그래프의 시작 노드부터 모든 노드를 BFS로 진행한 순서대로 노드가 저장된 리스트입니다.
 */
public class Practice35BasicBfs {
    private static Integer[] solution(int[][] graph, int start, int n) {
        ArrayList<Integer> result = new ArrayList<>();

        ArrayList<Integer>[] convertedGraph = new ArrayList[n + 1];
        for (int idx = 0; idx < n + 1; idx++) {
            convertedGraph[idx] = new ArrayList<Integer>();
        }

        for (int[] edge : graph) {
            convertedGraph[edge[0]].add(edge[1]);
        }

        Boolean[] visitedCheck = new Boolean[n + 1];
        ArrayDeque<Integer> bfsOrderQueue = new ArrayDeque<>();
        bfsOrderQueue.addFirst(start);

        while (!bfsOrderQueue.isEmpty()) {
            int node = bfsOrderQueue.pollLast();

            if (visitedCheck[node] == null || visitedCheck[node] == false) { // FIXME: 노드 체크를 이 때 하는게 맞나?
                System.out.println("now node: " + node + "//" + visitedCheck[node]);
                visitedCheck[node] = true;
                result.add(node);
                for (int connectedNode : convertedGraph[node]) {
                    bfsOrderQueue.addFirst(connectedNode);
                }
            }
        }

        return result.toArray(new Integer[]{});
    }

    public static void main(String[] args) {
        int[][] graph1 = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {5, 8}, {6, 9}, {7, 9}};
        System.out.println(Arrays.toString(solution(graph1, 1, 9))); // [1,2,3,4,5,6,7,8,9]
        int[][] graph2 = {{1, 3}, {3, 4}, {3, 5}, {5, 2}};
        System.out.println(Arrays.toString(solution(graph2, 1, 5))); // [1,3,4,5,2]
    }
}
