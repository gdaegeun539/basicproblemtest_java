package xyz.gosiphone.basicproblem.bookpractice;

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
        int[][] memoizationSize = new int[str1.length() + 1][str2.length() + 1];

        for(int outIndex = 0; outIndex < str1.length(); outIndex++) {
            for(int inIndex = 0; inIndex < str2.length(); inIndex++) {
                if(str1.charAt(outIndex) == str2.charAt(inIndex)) {
                    memoizationSize[outIndex + 1][inIndex + 1] = memoizationSize[outIndex][inIndex] + 1;
                } else {
                    memoizationSize[outIndex + 1][inIndex + 1] = Math.max(memoizationSize[outIndex][inIndex + 1], memoizationSize[outIndex + 1][inIndex]);
                }
            }
        }

        return memoizationSize[str1.length()][str2.length()];
    }

    public static void main(String[] args){
        System.out.println(solution("ABCBDAB", "BDCAB")); // 4
        System.out.println(solution("AGGTAB", "GXTXAYB")); // 4
    }
}

/*
 * 0 둘이 같은 지 순회 돌 시간에 그냥 dp 테이블 채우는 거 구현하는 게 나을듯?
 *
 * - 초기값은 두 문자열이 다를 경우 0 같을 경우 1
 * - 둘이 다를 경우에는 최대(lcs(지금인덱스 -1, 지금인덱스), lcs(지금인덱스, 지금인덱스 - 1))
 * - 둘이 같을 경우에는 lcs(지금인덱스 -1, 지금인덱스 -1) + 1
 * 0-1 길이 메모이제이션용 배열 초기화
 * 1 str1 인덱스 순회 시작
 * 2 str2 인덱스 순회 시작
 * 3 지금 인덱스끼리 값 비교해서 상단 알고리즘 적용
 * 3-1 나온 값으로 배열에 값 저장
 * 4 순회 끝나면 메모이제이션 맨 마지막 원소 반환
 * */