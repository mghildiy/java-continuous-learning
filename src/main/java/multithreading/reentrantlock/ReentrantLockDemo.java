package multithreading.reentrantlock;

public class ReentrantLockDemo {

    public static void main(String[] args) {
        PriceContainer pc = new PriceContainer();
        PriceUpdater pu = new PriceUpdater(pc);

        Thread updatePriceThread = new Thread(pu);
        updatePriceThread.start();

        while(true) {
            if (pc.getLock().tryLock()) {
                System.out.println("Would print prices");
                try {
                    System.out.println(pc.bitCoinPrice);
                    System.out.println(pc.etherPrice);
                    System.out.println(pc.ripplePrice);
                } finally {
                    System.out.println("Done printing prices");
                    pc.getLock().unlock();
                }
            }
        }
    }
}
