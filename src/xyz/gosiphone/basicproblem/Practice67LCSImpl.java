package xyz.gosiphone.basicproblem;

/**
 * <h5>주어진 두 개의 문자열에 대해 최장 공통 부분 수열의 길이을 계산하시오.</h5>
 * <p>
 * 제약 조건
 * <ul>
 *   <li>각 문자열의 길이는 1 이상 1000 이하이다.</li>
 *   <li>문자열은 알파벳 대문자와 소문자로만 구성되어 있다.</li>
 * </ul>
 * </p>
 * */
public class Practice67LCSImpl {

    private static int solution(String str1, String str2){

        return -1;
    }

    public static void main(String[] args){
        System.out.println(solution("ABCBDAB", "BDCAB")); // 4
        System.out.println(solution("AGGTAB", "GXTXAYB")); // 4
    }
}
