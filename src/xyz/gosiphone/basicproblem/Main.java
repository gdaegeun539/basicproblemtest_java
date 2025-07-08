package xyz.gosiphone.basicproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4, 5, 6, 7};

        System.out.println(Arrays.toString(testArray));

        ArrayList<Integer> sampleArrayList = new ArrayList<>();

        sampleArrayList.add(23);
        sampleArrayList.add(24);
        sampleArrayList.add(25);
        sampleArrayList.add(26);

        System.out.println(sampleArrayList);
        System.out.println(sampleArrayList.get(2));

        HashMap<String, Integer> sampleHashMap = new HashMap<>();

        sampleHashMap.put("sampleKey", 42);
        sampleHashMap.put("sampleKey2", 64);
        sampleHashMap.put("sampleKey3", 886);

        System.out.println(sampleHashMap);

        if(sampleHashMap.containsKey("sampleKey")){
            System.out.println("키 포함 여부 테스트");
            System.out.println(sampleHashMap.get("sampleKey"));
        }

        sampleHashMap.remove("sampleKey");
        System.out.println(sampleHashMap);

        String sampleString = "뭐야 너 불변객체라면서";
        System.out.println(sampleString);
        System.out.println(sampleString.hashCode());
        System.out.println(System.identityHashCode(sampleString));
        sampleString += " 일단 뭘 더해볼게";
        System.out.println(sampleString);
        System.out.println(sampleString.hashCode());
        System.out.println(System.identityHashCode(sampleString));
        sampleString = sampleString.replace(" ", "");
        System.out.println(sampleString);
        System.out.println(sampleString.hashCode());
        System.out.println(System.identityHashCode(sampleString));


        System.out.println(System.identityHashCode(null));
    }
}
