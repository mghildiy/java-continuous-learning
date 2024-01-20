package multithreading.reentrantlock;

import java.util.Random;

public class PriceUpdater implements Runnable {

    private PriceContainer pc;
    private Random random = new Random();

    public PriceUpdater(PriceContainer input) {
        pc = input;
    }

    @Override
    public void run() {
        while(true) {
            pc.getLock().lock();
            try{
                try {
                    Thread.sleep(10);
                    System.out.println("Would update prices");
                    pc.setEtherPrice(random.nextInt(2000));
                    pc.setBitCoinPrice(random.nextInt(1500));
                    pc.setRipplePrice(random.nextInt(1000));
                } catch (InterruptedException e) {
                }
            }
            finally {
                System.out.println("Done updating prices");
                pc.getLock().unlock();
            }

            try{
                Thread.sleep(1000);
            } catch(InterruptedException e) {

            }
        }
    }

}
