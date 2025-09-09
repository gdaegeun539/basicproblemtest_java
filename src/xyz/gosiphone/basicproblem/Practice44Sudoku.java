package xyz.gosiphone.basicproblem;

import java.util.Arrays;

/**
 * 틀림(다시 풀 것)
 * 9*9 스도쿠 보드를 모두 채워 완성된 스도쿠 보드를 반환하는 solution() 메소드를 작성하세요.
 * <p></p>
 * ### 제약 조건
 * - 백트래킹 활용(백트래킹 연습문제)
 * - 원래의 스도쿠 규칙을 따릅니다.
 * - 가로 줄, 세로 줄에는 1에서 9까지의 숫자가 한 번씩 나타나야 한다.
 * - 9*9 보드를 채울 9개의 작은 박스에도 1에서 9까지의 숫자가 한 번씩 나타나야 한다.
 * - 주어지는 board는 스도쿠를 완성 가능한 보드이다.
 * - 답안은 유일하지 않다.
 * - 스도쿠 규칙에 맞다면 정답으로 인정한다.
 * ### 권장 풀이 시간, 시간 복잡도
 * 60분, O(9^n)
 *
 */
public class Practice44Sudoku {
    private static int[][] solution(int[][] board) {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                backTrack(x, y, board);
            }
        }
        return board;
    }

    private static void backTrack(int x, int y, int[][] board) {
        if (board[x][y] != 0) {
            return;
        }

        for (int placeNum = 1; placeNum <= 9; placeNum++) {
            if (!checkRow(placeNum, board[x]) || !checkCol(placeNum, y, board) || !checkBox(placeNum, x, y, board)) {
                continue;
            }

//            System.out.println("placeNum: " + placeNum);
            board[x][y] = placeNum;
        }

    }

    private static boolean checkRow(int value, int[] board) {
        for (int checker : board) {
            if (checker == value) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkCol(int value, int y, int[][] board) {
        for (int idx = 0; idx < 9; idx++) {
            if (board[idx][y] == value) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkBox(int value, int x, int y, int[][] board) {
        int[] xIndices, yIndices;
        int modX = (x + 1) % 3;
        int modY = (y + 1) % 3;

        if (modX == 1) {
            xIndices = new int[]{x, x + 1, x + 2};
        } else if (modX == 2) {
            xIndices = new int[]{x - 1, x, x + 1};
        } else {
            xIndices = new int[]{x - 2, x - 1, x};
        }
        if (modY == 1) {
            yIndices = new int[]{y, y + 1, y + 2};
        } else if (modY == 2) {
            yIndices = new int[]{y - 1, y, y + 1};
        } else {
            yIndices = new int[]{y - 2, y - 1, y};
        }

        for (int xIndex : xIndices) {
            for (int yIndex : yIndices) {
                if (board[x][y] == value) {
                    return false;
                }
            }
        }
        return true;
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

/*
 * 숫자를 고르는게 먼저인가, 인덱스를 고르는게 먼저인가?
 * */

/* 조건 1: x 인덱스에 같은 숫자가 없어야 함
 * 조건 2: y 인덱스에 같은 숫자가 없어야 함
 * 조건 3: x, y +-2 이내에 같은 숫자가 없어야 함
 * 조건 3-x: +1 했을 때 나머지가
 * 3-1: 1이면 n+2의 인덱스 내에서 뒤져야 함
 * 3-2: 2이면 n-1, n+1의 인덱스 내에서 뒤져야 함
 * 3-3: 0이면 n-2의 인덱스 내에서 뒤져야 함
 * 조건 4: 이미 숫자가 놓인 인덱스일 경우 새로 놓지 않음
 * */