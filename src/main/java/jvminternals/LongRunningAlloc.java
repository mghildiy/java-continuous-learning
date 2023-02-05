package jvminternals;

import java.util.ArrayDeque;

public class LongRunningAlloc {

    public static void main(String[] args) throws InterruptedException {
        ArrayDeque blocks = new ArrayDeque<byte[]>();
        while (true) {
            System.out.println("Loop on....");
            blocks.add(new byte[1024 * 1024]);
            Thread.sleep(1);
            if (blocks.size() > 150) {
                for (int i = 0; i < 25; i++) {
                    blocks.pop();
                }
            }
        }
    }
}
