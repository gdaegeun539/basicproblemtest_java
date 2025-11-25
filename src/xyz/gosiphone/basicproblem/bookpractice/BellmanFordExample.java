package xyz.gosiphone.basicproblem.bookpractice;

import java.util.*;
import java.util.stream.IntStream;

public class BellmanFordExample {

    static class Edge {
        int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return String.format("%c→%c (가중치: %d)",
                (char)('A' + from), (char)('A' + to), weight);
        }
    }

    public static void main(String[] args) {
        // 정점 개수 (A=0, B=1, C=2, D=3, E=4)
        int V = 5;

        // 그래프의 간선들
        List<Edge> edges = Arrays.asList(
            new Edge(0, 1, 4), // A→B (가중치 4)
            new Edge(0, 2, 2), // A→C (가중치 2)
            new Edge(1, 2, 3), // B→C (가중치 3)
            new Edge(1, 3, 2), // B→D (가중치 2)
            new Edge(1, 4, 4), // B→E (가중치 4)
            new Edge(2, 3, 4), // C→D (가중치 4)
            new Edge(2, 4, 5), // C→E (가중치 5)
            new Edge(3, 4, 1)  // D→E (가중치 1)
        );

        bellmanFord(edges, V, 0); // A(0)에서 시작
    }

    public static void bellmanFord(List<Edge> edges, int V, int start) {
        // 거리 배열 초기화
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        System.out.println("=== 벨만-포드 알고리즘 실행 ===");
        System.out.println("시작점: " + (char)('A' + start));
        printDistances("초기화", dist);

        // V-1번 반복 (최대 4번)
        for (int i = 1; i <= V - 1; i++) {
            System.out.println("\n--- " + i + "번째 이터레이션 ---");
            boolean hasUpdate = false;

            for (Edge edge : edges) {
                if (dist[edge.from] != Integer.MAX_VALUE) {
                    int newDist = dist[edge.from] + edge.weight;
                    if (newDist < dist[edge.to]) {
                        System.out.printf("간선 %s: dist[%c] = min(%s, %d+%d) = %d%n",
                            edge,
                            (char)('A' + edge.to),
                            dist[edge.to] == Integer.MAX_VALUE ? "∞" : String.valueOf(dist[edge.to]),
                            dist[edge.from],
                            edge.weight,
                            newDist);
                        dist[edge.to] = newDist;
                        hasUpdate = true;
                    } else {
                        System.out.printf("간선 %s: dist[%c] = min(%s, %d+%d) = %s (변화없음)%n",
                            edge,
                            (char)('A' + edge.to),
                            dist[edge.to] == Integer.MAX_VALUE ? "∞" : String.valueOf(dist[edge.to]),
                            dist[edge.from],
                            edge.weight,
                            dist[edge.to] == Integer.MAX_VALUE ? "∞" : String.valueOf(dist[edge.to]));
                    }
                }
            }

            printDistances(i + "번째 이터레이션 후", dist);

            // 더 이상 업데이트가 없으면 조기 종료
            if (!hasUpdate) {
                System.out.println("더 이상 거리 갱신이 없어 조기 종료합니다.");
                break;
            }
        }

        // 최종 결과 출력
        System.out.println("\n=== 최단 거리 결과 ===");
        IntStream.range(0, V)
            .forEach(i -> System.out.printf("%c에서 %c까지: %s%n",
                (char)('A' + start),
                (char)('A' + i),
                dist[i] == Integer.MAX_VALUE ? "∞" : String.valueOf(dist[i])));
    }

    private static void printDistances(String phase, int[] dist) {
        System.out.print(phase + ": [");
        for (int i = 0; i < dist.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.printf("%c: %s",
                (char)('A' + i),
                dist[i] == Integer.MAX_VALUE ? "∞" : String.valueOf(dist[i]));
        }
        System.out.println("]");
    }
}
