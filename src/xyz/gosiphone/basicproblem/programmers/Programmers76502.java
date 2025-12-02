package xyz.gosiphone.basicproblem.programmers;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Programmers76502 {
    public int solution(String s) {
        int answer = 0;

        Map<Character, Character> matchBrackets = new HashMap<>();
        matchBrackets.put(']', '[');
        matchBrackets.put('}', '{');
        matchBrackets.put(')', '(');

        for (int start = 0; start < s.length(); start++) { // 1
            ArrayDeque<Character> checkBracket = new ArrayDeque<>();
            boolean isCorrect = true;

            for (int index = 0; index < s.length(); index++) {
                // 보정작업
                int nowIndex = start + index;
                if (nowIndex >= s.length()) {
                    nowIndex -= s.length();
                }

                char bracket = s.charAt(nowIndex);

                if (bracket == '[' || bracket == '{' || bracket == '(') { // 2-1
                    checkBracket.addFirst(bracket);
                } else { // 2-2
                    if (checkBracket.isEmpty()) { // 2-2-1.
                        isCorrect = false;
                        break;
                    }

                    char lastBracket = checkBracket.peekFirst();
                    if (lastBracket == matchBrackets.get(bracket)) {
                        checkBracket.pollFirst();
                    } else {
                        isCorrect = false;
                        break;
                    }
                }
            }

            if (!checkBracket.isEmpty()) { // 3-2
                isCorrect = false;
            }

            if (isCorrect) { // 3-1
                answer += 1;
            }
        }

        return answer;
    }
}

/*
1. 배열의 길이를 기준으로 이터레이션을 인덱스를 돈다.
2. 이터레이션 중 아래의 작업을 진행한다.
2-1. 지금 인덱스의 요소가 여는 괄호일 경우 스택에 괄호를 넣는다.
2-2. 지금 인덱스의 요소가 닫는 괄호일 경우 스택의 맨 마지막 요소를 확인한다.
2-2-1. 맨 마지막 요소가 없는 상황에서 확인할 경우(대응하는 여는 괄호가 없는 경우) 이터레이션을 중단한다. - 대응하는 짝이 오기 전에 확인을 진행하는 경우임
2-3. 맨 마지막 요소가 닫는 괄호에 대응하는 여는 괄호이면 스택의 요소를 하나 뺀다.
2-4. 맨 마지막 요소가 닫는 괄호에 대응하지 않는 여는 괄호이면 이번 이터레이션을 중단하고 스택을 비운다.
3. 문제 없이 한 번의 이터레이션이 완료되면 아래를 확인 및 진행한다.
3-1. 스택이 비었으면 회전 횟수를 하나 추가한다.
3-2. 스택이 차 있으면 회전 회수를 추가하지 않는다.
4. 이터레이션 완료 후 총 회전 횟수를 반환한다.
*/
