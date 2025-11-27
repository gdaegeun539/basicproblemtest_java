package xyz.gosiphone.basicproblem.programmers;

import java.util.Arrays;

// 풀이 소요 시간: 54분 35초

/*
사용자수가 20만 이하니까 두 번 순회하는 것까지만 제약을 해야할 듯
전체 사용자 수를 알려면, 해당 사용자가 위치한 이전 스테이지까지 다 더해버려야 한다.

1. 현재 사용자가 멈춘 스테이지들을 순회한다.
2. 순회하는 사용자마다 아래의 작업을 진행한다.
2-1. 자기가 멈춘 스테이지까지 스테이지를 진행한 유저를 1 누적한다.
2-2. 자기가 멈춘 스테이지에서 실패한 사람을 1 누적한다.
3. 스테이지별 인원과 실패 인원을 모은 데이터를 순회한다.
4. 스테이지별 실패율을 계산해 저장한다. (근데 어디에?)
4-1. 스테이지를 통과한 유저가 없을 경우 실패율을 0으로 저장한다.
5. 실패율을 계산한 데이터를 실패율의 내림차순으로 정렬한다. (정렬 전에 스테이지 번호를 보존해야 함)
6. 5.의 데이터를 스테이지 번호만 추출해 반환한다.
*/
public class Failure42889 {
    private int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        /* [N개(1스테이지 ~ n스테이지)] * [스테이지 실패자 수, 스테이지 도전자 수] */
        int[][] calcUser = new int[N][2];

        for (int user: stages) { // 사용자들이 현재 멈춘 스테이지를 순회한다.
            for (int stage = 0; stage < Math.min(user, N); stage++) { // user가 N+1일 경우 N까지만 순회
                // 사용자가 멈춘 스테이지까지 아래 작업을 진행한다.
                calcUser[stage][1] += 1;
                if (stage == user - 1) {
                    // 지금 순회도는 스테이지 인덱스(-1 감안)와 사용자가 멈춘 스테이지를 확인한다.
                    calcUser[stage][0] += 1;
                }
            }
        }

        /* [N개(1스테이지 ~ n스테이지)] * [스테이지 번호, 실패율] */
        double[][] failureCount = new double[N][2];

        for (int index = 0; index < calcUser.length; index++) {
            failureCount[index][0] = index + 1;
            if (calcUser[index][1] == 0) { // 도달한 유저가 없으면 실패율은 0
                failureCount[index][1] = 0.0;
            } else {
                failureCount[index][1] = (double) calcUser[index][0] / calcUser[index][1];
            }
        }

        Arrays.sort(failureCount, (c1, c2) -> Double.compare(c2[1], c1[1])); // 내림차순 정렬이 필요하다.

        for (int index = 0; index < failureCount.length; index++) {
            answer[index] = (int)(failureCount[index][0]);
        }

        return answer;
    }
}

/*
* 헷갈린 메소드
* Double.compare() `Arrays.sort(failureCount, (c1, c2) -> Double.compare(c2[1], c1[1]));`
* 정수 나눗셈 시 캐스팅 `(double) calcUser[index][0] / calcUser[index][1];`
* double to int 강제형변환 `(int)(failureCount[index][0])`
* */