package xyz.gosiphone.basicproblem;

public class TimeTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        StringBuffer s = new StringBuffer();
        for (int i = 0; i < 100001; i++) {
            s.append(i);
        }

        long end = System.currentTimeMillis();

        System.out.println((end - start) / 1000.0);

        s.insert(3244, "newString");
        System.out.println(s +"\n\n\n");
        s.deleteCharAt(84656);
        System.out.println(s+"\n\n\n");
    }
}
