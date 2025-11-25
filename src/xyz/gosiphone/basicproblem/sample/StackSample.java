package xyz.gosiphone.basicproblem.sample;

import java.util.ArrayDeque;

public class StackSample {
    public static void main(String[] args) {
//        String s = "";
//        char cch = s.charAt(0);
//        boolean isFalse = cch == '(';


        ArrayDeque<Integer> sampleStack = new ArrayDeque<>();
        sampleStack.pop();

        sampleStack.push(3);
        sampleStack.push(345);

        System.out.println(sampleStack.isEmpty());
        System.out.println(sampleStack.peek());
        System.out.println(sampleStack.size());

        sampleStack.push(423);
        sampleStack.push(6578);
        sampleStack.push(657678);
        sampleStack.push(135423);

        System.out.println(sampleStack.pop());
        System.out.println(sampleStack.pop());
        System.out.println(sampleStack.isEmpty());

        System.out.println(sampleStack.size());
    }
}
