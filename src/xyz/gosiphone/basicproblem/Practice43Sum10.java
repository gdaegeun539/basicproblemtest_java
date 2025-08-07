package xyz.gosiphone.basicproblem;

import java.util.ArrayList;

/**
 * 정수 n을 입력받아 1부터 n까지의 숫자 합 중에서 10이 되는 조합을 리스트로 반환하는 solution() 메소드를 반환하세요.
 * <p></p>
 * ### 제약 조건
 * - n은 1 이상 10 이하의 정수입니다.
 * - 백트래킹 활용(백트래킹 연습문제)
 * - 숫자 조합은 오름차순으로 정렬되어야 합니다.
 * - 같은 숫자는 한 번만 선택 가능합니다.
 */
public class Practice43Sum10 {
    private static ArrayList<ArrayList<Integer>> solution(int n) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println(solution(5)); // [[1,2,3,4],[1,4,5],[2,3,5]]
        System.out.println(solution(2)); // []
        System.out.println(solution(7)); // [[1,2,3,4],[1,2,7],[1,3,6],[1,4,5],[2,3,5],[3,7],[4,6]]
    }
}
