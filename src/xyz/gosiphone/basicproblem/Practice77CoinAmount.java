package xyz.gosiphone.basicproblem;

import java.util.Arrays;

/**
 * <p>
 *     당신은 거스름돈을 돌려받고 싶어졌습니다. 다만 거스름돈을 최소한의 화폐 수로 받고 싶어졌습니다.
 *     거스름돈(amount)이 있을 때 화폐 단위를 최소한으로 사용한 화폐 리스트를 반환하는 메소드 `solution()`을 작성하시오.
 * </p>
 * <h5>제약조건</h5>
 * <ul>
 *     <li>반환하는 값의 화폐 단위는 내림차순이어야 한다.</li>
 *     <li>거스름돈(amount)는 1 이상의 정수이다. (문제에 없긴 한데 O(n) 시간복잡도이면 100만 이하로 잡아야 할듯?)</li>
 *     <li>거스를 돈의 화폐 단위는 1, 10, 50, 100이다.</li>
 *     <li>거스를 돈의 개수는 무한하다.</li>
 * </ul>
 * */
public class Practice77CoinAmount {
    private static int[] solution(int amount) {
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(123))); // [100, 10, 10, 1, 1]
        System.out.println(Arrays.toString(solution(350))); // [100, 100, 100, 50]
    }
}
