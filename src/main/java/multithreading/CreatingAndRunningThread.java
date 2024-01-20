package multithreading;

// Implementing Runnable vs inheriting Thread class
// Programming to interface hence less coupling, class can inherit from another class, same runnable instance shared between multiple threads
// hence memory savings, easy to manage a group of instances like to queue them up while waiting for an ideal thread from a pool
// If we want to execute more than 1 task, we can extend Thread class to override run()
// as well as pass a Runnable to constructor. In run() method, we can thus have custom task, as well as Runnable to execute
public class CreatingAndRunningThread {

    private static void threadFromThreadClass() {
        Thread notSoUsefulThread = new Thread("My Awesome Thread");
        notSoUsefulThread.start();
    }

    private static void threadFromCustomClass() {
        MyDummyThread myThread = new MyDummyThread("My Awesome Dummy Thread");
        // run() makes thread execute in same current thread, can be called any number of times
        myThread.run();
        // start() schedules thread to run its execution
        myThread.start();
        myThread.run();
        myThread.run();
        try {
            myThread.start();
        } catch(IllegalThreadStateException e) {
            System.out.println("start() method can't be called more than once on a thread");
        }
    }

    private static void threadFromRunnable() {
        Runnable task = () -> {
            System.out.println("Lambda for Runnable:"+ Thread.currentThread().getName());
        };

        Thread t = new Thread(task, "Runnable-By-lambda");
        t.start();
    }

    public static void main(String[] args) {
        System.out.println("Parent thread:"+ Thread.currentThread().getName());

        threadFromThreadClass();

        threadFromCustomClass();

        threadFromRunnable();

        Thread immortalThread = new Thread(() -> {
            while(true) {
                System.out.println("I am immortal!");
            }
        });
        // make it mortal
        immortalThread.setDaemon(true);
        immortalThread.start();
    }
}

class MyDummyThread extends Thread {

    MyDummyThread() {}

    MyDummyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("My thread that does nothing special:"+ Thread.currentThread().getName());
    }
}
