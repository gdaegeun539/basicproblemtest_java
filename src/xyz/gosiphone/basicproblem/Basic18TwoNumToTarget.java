package xyz.gosiphone.basicproblem;

import java.util.HashSet;

/**
 * n개의 양의 정수로 이루어진 배열 arr과 정수 target이 주어졌을 때,
 * 이 중에서 합이 target인 두 정수가 arr에 있는지 찾고, 없으면 false를 반환하는 solution() 메소드를 작성하세요.
 * <p></p>
 * 제약 조건
 * - n은 2 이상 10000 이하의 자연수입니다.
 * - arr의 각 원소는 1 이상 10000 이하의 자연수입니다.
 * - arr의 원소 중 중복되는 원소는 없습니다.
 * - target은 1 이상 20000 이하의 자연수입니다.
 * <p></p>
 * 권장 풀이 시간: 30분
 */
public class Basic18TwoNumToTarget {
    public static void main(String[] args) {
        boolean result1 = solution(new int[]{1, 2, 3, 4, 8}, 6);
        System.out.println(result1);
        boolean result2 = solution(new int[]{2, 3, 5, 9}, 10);
        System.out.println(result2);
    }

    private static boolean solution(int[] arr, int target) {
        HashSet<Integer> sampleHashSet = new HashSet<>();

        for (int n : arr) {
            if (sampleHashSet.contains(target - n)) {
                return true;
            }
            sampleHashSet.add(n);
        }

        return false;
    }
}
