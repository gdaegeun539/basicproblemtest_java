package xyz.gosiphone.basicproblem;

import java.util.Arrays;

/**
 * 9*9 스도쿠 보드를 모두 채워 완성된 스도쿠 보드를 반환하는 solution() 메소드를 작성하세요.
 * <p></p>
 * ### 제약 조건
 * - 원래의 스도쿠 규칙을 따릅니다.
 *   - 가로 줄, 세로 줄에는 1에서 9까지의 숫자가 한 번씩 나타나야 한다.
 *   - 9*9 보드를 채울 9개의 작은 박스에도 1에서 9까지의 숫자가 한 번씩 나타나야 한다.
 * - 주어지는 board는 스도쿠를 완성 가능한 보드이다.
 * - 답안은 유일하지 않다.
 *   - 스도쿠 규칙에 맞다면 정답으로 인정한다.
 * */
public class Practice44Sudoku {
    private static int[][] solution(int[][] board){
        return new int[][] {};
    }

    public static void main(String[] args) {
        int[][] board1 = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        System.out.println(Arrays.deepToString(solution(board1)));

        int[][] board2 = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.deepToString(solution(board2)));
    }
}
