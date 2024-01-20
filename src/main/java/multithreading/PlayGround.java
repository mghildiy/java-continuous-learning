package multithreading;

import multithreading.reentrantlock.ReentrantLockDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class PlayGround {

    PlayGround() {}
    static final Logger logger = LoggerFactory.getLogger(PlayGround.class);

    public static void main(String[] args) throws InterruptedException {
        //runningAThreadDemo();
        //daemonDemo();
        //priorityDemo();
        //uncaughtExceptionHandlerDemo();
        //interruptThreadDemo1();
        //interruptThreadDemo2();
        //joinDemo();
        //resourceSharingProblem();
        //lockingDemo();
        //dataRaceDemo();
    }

    static void reEntrantLockDemo() {
        Lock lock = new ReentrantLock();
        //lock.lock();
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(lock.tryLock()) {
            try {
                // perform operations
            }
            finally {
                lock.unlock();
            }
        } else {
            // perform alternate operations
        }

        ReentrantLockDemo demo = new ReentrantLockDemo();
    }

    static void dataRaceDemo() {
        DataRaceProne shared = new DataRaceProne();
        Thread t1 = new Thread(() -> {
            IntStream.range(0, Integer.MAX_VALUE)
                    .forEach(i -> shared.update());
        });
        Thread t2 = new Thread(() -> {
            IntStream.range(0, Integer.MAX_VALUE)
                    .forEach(i -> shared.checkForDataConsistency());
        });
        t1.start();
        t2.start();
    }

    static class DataRaceProne {
        volatile private int x = 0;
        volatile private int y = 0;

        void update() {
            x++;
            y++;
        }

        void checkForDataConsistency() {
            if(y > x) {
                logger.info("Unexpected state of data");
            }
        }
    }

    static void lockingDemo() throws InterruptedException {
        var userCounter = new SynchronizedCounter();
        simulateUserLogin(userCounter);
    }

    private static class SynchronizedCounter extends Counter {
        public synchronized void increment() {
            this.counter++;
        }

        public synchronized void decrement() {
            counter--;
        }
    }

    private static class UnSynchronizedCounter extends Counter {
        public void increment() {
            counter++;
        }

        public void decrement() {
            counter--;
        }
    }

    static void resourceSharingProblem() throws InterruptedException {
        var userCounter = new UnSynchronizedCounter();
        simulateUserLogin(userCounter);

    }

    static void simulateUserLogin(Counter userCounter) throws InterruptedException {
        var random = new Random();
        Thread userIncrementer = new Thread(() -> {
            for(var i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(random.nextInt(1));
                    userCounter.increment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread userDecrementer = new Thread(() -> {
            for(var i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(random.nextInt(1));
                    userCounter.decrement();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        userIncrementer.start();
        userDecrementer.start();
        userIncrementer.join();
        userDecrementer.join();
        logger.info("Number of users logged in:" + userCounter.counter);
    }

    // join API gives us a way for threads coordination
    // It ensures that calling thread waits(and thus dont consume resources) for thread to finish
    // This is fit for a scenario when a thread needs result from another thread
    static void joinDemo() throws InterruptedException{
        var num = 10000;
        List<BigInteger> result = new ArrayList<>();
        var longRunningThread = new Thread(() -> {
            BigInteger factorial = BigInteger.ONE;
            int counter = 1;
            while(!Thread.currentThread().isInterrupted()) {
                factorial = factorial.multiply(new BigInteger(Integer.toString(counter)));
                if(counter == num) {
                    result.add(factorial);
                    break;
                }
                counter += 1;
            }
        }, "LongRunning-Thread");

        longRunningThread.start();
        // wait for thread to complete, but only for period of time
        longRunningThread.join(10);
        // interrupt the thread so that it exits, dont use stop()
        longRunningThread.interrupt();
        if(result.size() > 0) {
            logger.info("Factorial for "+ num + " is " + result.get(0).toString());
        } else {
            logger.info("Thread was terminated before it could compute factorial");
        }

        logger.info(Thread.currentThread().getName() + " exits");
    }

    // A non-daemon thread can be interrupted by calling interrupt method. What thread must do on being interrupted
    // is developer's prerogative, but a very common scenario is to terminate it by throwing a run time exception
    // Daemon threads get terminated automatically when main thread terminates
    // Interrupt mechanism works if:
    // 1. thread is executing a method that throws InterruptedException
    static void interruptThreadDemo1() {
        Thread blockingThread = new Thread(() -> {
            try {
                Thread.sleep(40000);
            } catch (InterruptedException e) {
                throw new RuntimeException("Let me sleep, you moron!");
            }
        }, "Blocking-Thread");

        blockingThread.start();
        blockingThread.interrupt();
    }
    // 2. thread's code explicitly handles interrupt signal
    static void interruptThreadDemo2() {
        Thread eternalThread = new Thread(() -> {
            while(true) {
                if(Thread.currentThread().isInterrupted())
                    throw new RuntimeException("I, " + Thread.currentThread().getName()+ ", am being asked to stop doing my work, so would quit.");
            }
        }, "Eternal-Thread");

        eternalThread.start();
        eternalThread.interrupt();
    }

    static void uncaughtExceptionHandlerDemo() {
        var erroneousThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            throw new RuntimeException("asteroid is upon us");
        }, "Adventurous");

        erroneousThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread var1, Throwable var2) {
                logger.info("Thread "+ var1.getName() + " has error as expected: " + var2.getMessage());
            }
        });

        erroneousThread.start();

        logger.info(Thread.currentThread().getName());
    }

    // priority is inherited from parent thread(main thread is NORM_PRIORITY)
    static void priorityDemo() {
        var lowerPriorityThread = new Thread(() -> {
            logger.info("Enter "+ Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logger.info("Exit " + Thread.currentThread().getName());
        }, "LowerPriority-Thread");
        lowerPriorityThread.setDaemon(true);
        var higherPriorityThread = new Thread(() -> {
            logger.info("Enter "+ Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logger.info("Exit " + Thread.currentThread().getName());
        }, "HigherPriority-Thread");

        logger.info(Thread.currentThread().getName());
        higherPriorityThread.setPriority(Thread.MAX_PRIORITY);
        lowerPriorityThread.setPriority(Thread.MIN_PRIORITY);
        higherPriorityThread.start();
        lowerPriorityThread.start();

        logger.info(Thread.currentThread().getName());
    }

    // daemon/non-daemon nature is inherited from parent thread(main is non-daemon), if not explicitly set
    static void daemonDemo() {
        var daemonThread = new Thread(() -> {
            logger.info("Enter "+ Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logger.info("Exit " + Thread.currentThread().getName());
        }, "Daemon-Thread");
        daemonThread.setDaemon(true);
        var nonDaemonThread = new Thread(() -> {
            logger.info("Enter "+ Thread.currentThread().getName());
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logger.info("Exit " + Thread.currentThread().getName());
        }, "NonDaemon-Thread");

        logger.info(Thread.currentThread().getName());
        daemonThread.start();
        nonDaemonThread.start();
        logger.info(Thread.currentThread().getName());
    }

    static void runningAThreadDemo() {
        Runnable task = () -> {
            System.out.println("Lambda for Runnable:"+ Thread.currentThread().getName());
        };

        Thread t = new Thread(task, "Runnable-By-lambda");
        t.start();
    }
}
