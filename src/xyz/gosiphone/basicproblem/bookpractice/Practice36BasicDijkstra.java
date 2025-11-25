package xyz.gosiphone.basicproblem.bookpractice;

import java.util.Arrays;
import java.util.ArrayList;

// FIXME: 오답

/**
 * 주어진 그래프와 시작 노드를 이용하여 다익스트라 알고리즘을 구현하는 solution() 메소드를 작성하세요.
 * 인수는 graph, start, n 3개입니다.
 * graph는 노드의 연결 정보와 가중치가 저장되어 있습니다.
 * e.g. [[1,3,2], [2,3,4]]라면 1번에서 3번 노드로 가중치 2로 연결, 2번 노드에서 3번 노드로 가중치 4로 연결되어 있는 것입니다.
 * start는 시작 노드입니다.
 * n은 노드 수입니다.
 * <p></p>
 * ### 제약 조건
 * - 그래프의 노드 수는 1 이상 10000 이하입니다.
 * - 각 노드는 0 이상 10000 이하의 정수입니다.
 * - 각 가중치는 0 이상 10000 이하의 자연수입니다.
 * <p></p>
 * ### 반환값
 * - 시작 노드부터 모든 노드(시작 노드 포함)까지의 최단 거리를 순서대로 저장한 배열입니다.
 */
public class Practice36BasicDijkstra {
    /**
     * 인접 리스트로 변환한 그래프
     */
    private static ArrayList<Edge>[] convertedGraph;

    /**
     * 노드 방문 확인용 배열
     */
    private static Boolean[] visitedInfo;

    /**
     * 노드 간 거리 저장 배열
     */
    private static DestinationInfo[] dists;

    /**
     * 연산 시 확인할 이전 노드
     */
    private static int previousNode = -1;

    public static int[] solution(int[][] graph, int start, int n) {
        // 그래프 인접 리스트로 변환
        convertedGraph = new ArrayList[n + 1];
        for (int idx = 0; idx < n + 1; idx++) {
            convertedGraph[idx] = new ArrayList<>();
        }
        for (int[] subGraph : graph) {
            convertedGraph[subGraph[0]].add(new Edge(subGraph[1], subGraph[2]));
        }

        // 방문 확인용 배열 초기화
        visitedInfo = new Boolean[n + 1];

        // 거리 저장용 배열 초기화
        dists = new DestinationInfo[n + 1];
        for (int idx = 0; idx < n + 1; idx++) {
            dists[idx] = new DestinationInfo(Integer.MAX_VALUE, -1);
        }

        // 시작 노드에 대한 거리 설정 및 거리 확인 시작
        visitedInfo[start] = true;
        dists[start] = new DestinationInfo(0, start);
        distCheck(start);

        ArrayList<Integer> result = new ArrayList<>();
        for (DestinationInfo dest : dists) {
            result.add(dest.destination);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void distCheck(int node) {
        visitedInfo[node] = true;

        // FIXME: 이 노드에서 갈 수 있는 노드까지의 거리를 일괄 갱신해야 함
        // 일단 현 노드까지의 거리 갱신
        if (previousNode != -1) {
            //min(dist(v), dist(w) + (w+v))
            int previousDist = dists[node].destination;
            int newDist = Integer.MAX_VALUE;

            for (Edge edge : convertedGraph[previousNode]) {
                if (edge.destinationNode == node) {
                    newDist = dists[previousNode].destination + edge.weight;
                }
            }

            if (newDist != Integer.MAX_VALUE) {
                dists[node] = new DestinationInfo(Math.min(previousDist, newDist), previousDist > newDist ? previousNode : node);
            }

        }

        // 다음에 확인할 노드로 dive
        // FIXME: 최소 비용이 제일 적은 노드를 선택해야 함
        for (Edge edge : convertedGraph[node]) {
            if (visitedInfo[edge.destinationNode] == null || visitedInfo[edge.destinationNode] == false) {
                previousNode = node;
                distCheck(edge.destinationNode);
            }
        }
    }

    private static class Edge {
        int destinationNode;
        int weight;

        Edge(int destinationNode, int weight) {
            this.destinationNode = destinationNode;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node[dest: " + destinationNode + " ]" + "[weight: " + weight + " ]";
        }
    }

    private static class DestinationInfo {
        int destination;
        int previousNode;

        DestinationInfo(int destination, int previousNode) {
            this.destination = destination;
            this.previousNode = previousNode;
        }

        @Override
        public String toString() {
            return "DestinationInfo[dest: " + destination + " ]" + "[previous: " + previousNode + " ]";
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{0, 1, 9}, {0, 2, 3}, {1, 0, 5}, {2, 1, 1}};
        System.out.println(Arrays.toString(solution(graph, 0, 3))); // [0,4,3]
        int[][] graph2 = {{0, 1, 1}, {1, 2, 5}, {2, 3, 1}};
        System.out.println(Arrays.toString(solution(graph2, 0, 4))); // [0,1,6,7]
    }
}
