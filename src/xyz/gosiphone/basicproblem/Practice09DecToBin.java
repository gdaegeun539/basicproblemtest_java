package xyz.gosiphone.basicproblem;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 10진수를 입력받아 2진수로 변환하는 Solution 메소드를 작성하세요.
 * <p/>
 * 조건: decimal은 1 이상 10억 미만의 자연수
 * <p/>
 * 10 -> 1010
 * 27 -> 11011
 * 12345 -> 11000000111001
 * */
public class Practice09DecToBin {
    public static void main(String[] args){
        String result = solution(10L);
        System.out.println(result);
        String result2 = solution(100L);
        System.out.println(result2);
    }

    private static String solution(long decimal){
        return Long.toBinaryString(decimal);
    }
}
