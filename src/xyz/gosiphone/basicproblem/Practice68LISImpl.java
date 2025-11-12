package xyz.gosiphone.basicproblem;

/**
 * <h5>주어진 정수 배열에 대해 최장 증가 부분 수열의 길이를 계산하시오.</h5>
 * <p>
 * 제약 조건
 * <ul>
 *   <li>정수 배열의 길이는 1000 이하이다.</li>
 *   <li>정수 배열의 각 원소는 -1000 이상 1000 이하의 정수이다.</li>
 * </ul>
 * </p>
 * */
public class Practice68LISImpl {
    private static int solution(int[] nums){

        return -1;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[] {1, 4, 2, 3, 1, 5, 7, 3})); // 5
        System.out.println(solution(new int[] {3, 2, 1})); // -1
    }
}
