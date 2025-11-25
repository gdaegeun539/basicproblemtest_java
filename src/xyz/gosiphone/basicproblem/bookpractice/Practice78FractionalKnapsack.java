package xyz.gosiphone.basicproblem.bookpractice;

import java.util.ArrayList;

/**
 * <h3>무게와 가치가 있는 짐이 주어질 때 부분 배낭 문제를 푸는 `solution()`을 작성하시오.</h3>
 * <p>
 *     제약 조건
 *     <ul>
 *         <li>베낭의 무게 제한(weightLimit)은 1 이상 10000 이하의 정수이다.</li>
 *         <li>짐(items)의 수는 1 이상 1000 이하이다.</li>
 *         <li>한 개의 짐은 무게와 가치 순서로 주어진다.</li>
 *     </ul>
 * </p>
 * <p>
 *     권장 풀이 시간: 50분
 *     권장 시간 복잡도: O(n*lgn)
 * </p>
 * */
public class Practice78FractionalKnapsack {
    private static double solution(int[][] items, int weightLimit) {
        ArrayList<Item> itemsWithValue = new ArrayList<>();

        for (int[] item : items) {
            double valueByUnit = (double) item[1] / item[0];
            itemsWithValue.add(new Item(item[0], item[1], valueByUnit));
        }

        itemsWithValue.sort((p1, p2) -> Double.compare(p2.valueByUnit, p1.valueByUnit));

        double totalWeight = 0.0;
        for (Item item: itemsWithValue) {
            while (item.weight > 0 && weightLimit > 0) {
                totalWeight += item.valueByUnit;
                item.weight -= 1;
                weightLimit -= 1;
            }

            if (weightLimit <= 0) {
                break;
            }
        }

        return totalWeight;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{10, 19}, {7, 10}, {6, 10}}, 15)); // 27.33
        System.out.println(solution(new int[][] {{10, 60}, {20, 100}, {30, 120}}, 50)); // 240
    }

    private static class Item {
        int weight;
        int value;
        double valueByUnit;

        Item(int weight, int value, double valueByUnit){
            this.weight = weight;
            this.value = value;
            this.valueByUnit = valueByUnit;
        }
    }
}

/*
* 0. 전체 무게 단위당 가치를 먼저 구한다.
* 1. 제일 가치가 큰 짐을 고른다.
* 2. 해당 짐을 아래 기준에 따라 넣는다.
* 2-1. 해당 짐이 가방에 다 들어갈 때 까지
* 2-2. 가방 안에 짐이 꽉 찰 때까지
* 2-a. 단위무게의 짐이 들어갈 수 있는 지 확인
* 2-b. 단위무게의 짐을 넣음
* 2-c. 넣은 무게만큼 짐을 줄임
* 2-d. 넣은 무게만큼 가방의 무게를 증가(넣은 만큼 가능한 무게를 줄임)
* 3. 가방이 꽉 찰 때까지 위의 과정을 반복한다.
* */