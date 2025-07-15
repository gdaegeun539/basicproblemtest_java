package xyz.gosiphone.basicproblem;

import java.util.Arrays;

/**
 * 상호배타적 연산을 표현하고 관리하는데 다음 두 연산이 필요합니다.
 * - union(x,y): x와 y가 속한 두 집합을 합칩니다.
 * - find(x): x가 속한 집합의 대표 원소를 찾습니다.
 * operations라는 연산은 수행할 연산을 의미합니다. 연산 종류는 2개입니다.
 * [0,1,2]: 노드 1과 노드 2에 대해 union 연산 수행
 * [1,1,3]: 노드 1과 3이 같은 집합에 속해 있으면 true, 아니면 false를 반환하는 equals 연산
 * 초기의 노드는 부모 노드를 자신의 값으로 설정했다고 가정하며,
 * operations에 있는 연산에 대한 결과를 순서대로 담은 boolean 배열을 반환하는 solution() 메소드를 구현하세요.
 * <p></p>
 * 제약 조건
 * - 노드의 개수 k는 0 이상 1000 이하이다.
 * - operations의 길이(len(operations))는 1 이상 100,000 이하의 정수이다.
 * - operations[i][0]는 정수 0 혹은 1이다. (단, i는 0 이상 100,000 미만)
 * - 0은 union 연산이며, union 연산 뒤로는 두 개의 정수 x, y가 나온다.
 * - 1은 equals 연산이며, equals 연산 뒤로는 두 개의 정수 x, y가 나온다.
 * - x와 y는 0 이상 k-1 이하의 정수이다.
 * - 연산은 항상 유효하다.
 *   - 즉, union, find 연산의 인수는 상호배타적 집합 내에 있는 노드 번호이다.
 * */
public class Practice30BasicUnionFind {
    public static void main(String[] args){
        boolean[] result1 = solution(new int[][]{{0,0,1}, {0,1,2}, {1,1,2}});
        System.out.println(Arrays.toString(result1)); // [true]
        boolean[] result2 = solution(new int[][]{{0,0,1}, {1,1,2}, {0,1,2}, {1,0,2}});
        System.out.println(Arrays.toString(result2)); // [false, true]
    }

    private static boolean[] solution(int[][] operations){
        return new boolean[] {};
    }
}
