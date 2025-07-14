package xyz.gosiphone.basicproblem;

import java.util.Arrays;

/**
 * 이진 트리를 표현한 배열 nodes를 인자로 받습니다.
 * 해당 이진 트리에 대해 전위, 중위, 후위 순회 결과를 반환하는 solution() 메소드를 구현하세요.
 * <p></p>
 * 제약 조건
 * - 입력 노드의 개수는 1개 이상 1000개 이하이다.
 * 노드값은 정수이며, 중복되지 않는다.
 * 권장 풀이 시간: 40분
 */
public class Basic25TreeTravel {
    public static void main(String[] args) {
        String[] result1 = solution(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(Arrays.toString(result1));
    }

    private static String[] solution(int[] nodes) {
        // 전위
        StringBuilder firstTravelBuilder = new StringBuilder();
        preOrder(nodes, 0, firstTravelBuilder);

        // 중위
        StringBuilder secondTravelBuilder = new StringBuilder();
        inOrder(nodes, 0, secondTravelBuilder);

        // 후위
        StringBuilder thirdTravelBuilder = new StringBuilder();
        postOrder(nodes, 0, thirdTravelBuilder);

        return new String[]{firstTravelBuilder.toString(), secondTravelBuilder.toString(), thirdTravelBuilder.toString()};
    }

    /// 전위순회
    private static void preOrder(int[] nodes, int startIndex, StringBuilder stringBuilder) {
        // 중앙 방문
        stringBuilder.append(nodes[startIndex]);

        // 왼쪽 방문
        int leftNodeIndex = startIndex * 2 + 1;
        if (leftNodeIndex < nodes.length) {
            preOrder(nodes, leftNodeIndex, stringBuilder);
        }

        // 오른쪽 방문
        int rightNodeIndex = startIndex * 2 + 2;
        if (rightNodeIndex < nodes.length) {
            preOrder(nodes, rightNodeIndex, stringBuilder);
        }
    }

    /// 중위순회
    private static void inOrder(int[] nodes, int startIndex, StringBuilder stringBuilder) {
        // 왼쪽 방문
        int leftNodeIndex = startIndex * 2 + 1;
        if (leftNodeIndex < nodes.length) {
            inOrder(nodes, leftNodeIndex, stringBuilder);
        }

        // 중앙 방문
        stringBuilder.append(nodes[startIndex]);

        // 오른쪽 방문
        int rightNodeIndex = startIndex * 2 + 2;
        if (rightNodeIndex < nodes.length) {
            inOrder(nodes, rightNodeIndex, stringBuilder);
        }
    }

    /// 후위순회
    private static void postOrder(int[] nodes, int startIndex, StringBuilder stringBuilder) {
        // 왼쪽 방문
        int leftNodeIndex = startIndex * 2 + 1;
        if (leftNodeIndex < nodes.length) {
            postOrder(nodes, leftNodeIndex, stringBuilder);
        }

        // 오른쪽 방문
        int rightNodeIndex = startIndex * 2 + 2;
        if (rightNodeIndex < nodes.length) {
            postOrder(nodes, rightNodeIndex, stringBuilder);
        }

        // 중앙 방문
        stringBuilder.append(nodes[startIndex]);
    }
}
