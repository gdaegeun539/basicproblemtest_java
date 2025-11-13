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
        int[] memoLength = new int[nums.length];

        for(int now = 0; now < nums.length; now++){
            int prevMaxLength = 0;
            for(int prev = 0; prev < now; prev++){
                if(nums[prev] < nums[now]){
                    prevMaxLength = Math.max(prevMaxLength, memoLength[prev]);
                }
            }
            memoLength[now] = prevMaxLength + 1;
        }

        int maxLength = 0;
        for(int value: memoLength){
            maxLength = Math.max(maxLength, value);
        }

        return maxLength;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[] {1, 4, 2, 3, 1, 5, 7, 3})); // 5
        System.out.println(solution(new int[] {3, 2, 1})); // 1
    }
}

/*
* 0 첫 값을 1로 초기화
* 1 뒤 값을 모두 순회
* 2 내가 제일 크다면 나를 다시 1로 초기화 - 0으로 저장하면 될 듯?
* 3 나보다 작은 값이 있다면 훑으면서 최대값을 저장
* 4 3에서 값이 나왔다면 +1해서 나한테 저장
* 5 메모이제이션 배열에서 최대 값 찾아서 반환
* */