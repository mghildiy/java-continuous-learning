package features.virtual.threads;


import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.IntStream;

//import static java.lang.Thread.sleep;

public class VirtualThreadsExp {

    static final Logger logger = LoggerFactory.getLogger(VirtualThreadsExp.class);

    public static void main(String[] args) {

        System.out.println("Hello Virtual Threads!");

        //concurrentMorningRoutine();
        //concurrentMorningRoutineWithExecutors();
        viewCarrierThreadPoolSize();

    }

    static void viewCarrierThreadPoolSize() {
        final ThreadFactory factory = Thread.ofVirtual().name("routine-", 0).factory();
        try (var executor = Executors.newThreadPerTaskExecutor(factory)) {
            IntStream.range(0, numberOfCores() + 1)
                    .forEach(i -> executor.submit(() -> {
                        log("Hello, I'm a virtual thread number " + i);
                        sleep(Duration.ofSeconds(1L));
                    }));
        }
    }

    static int numberOfCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    private static Thread virtualThread(String name, Runnable runnable) {
        return Thread.ofVirtual()
                .name(name)
                .start(runnable);
    }

    @SneakyThrows
    static void concurrentMorningRoutine() {
        var bathTime = bathTime();
        var boilingWater = boilingWater();
        bathTime.join();
        boilingWater.join();
    }

    @SneakyThrows
    static void concurrentMorningRoutineWithExecutors() {
        final ThreadFactory factory = Thread.ofVirtual().name("routine-", 0).factory();
        try(var executor = Executors.newThreadPerTaskExecutor(factory)) {
            var bathTime = executor.submit(() -> {
                log("I'm going to take a bath");
                sleep(Duration.ofMillis(500L));
                log("I'm done with the bath");
            });
            var boilingWater = executor.submit(() -> {
                log("I'm going to boil some water");
                sleep(Duration.ofSeconds(1L));
                log("I'm done with the water");
            });
            bathTime.get();
            boilingWater.get();
        }
    }

    static Thread bathTime() {
        return virtualThread(
                "Bath time",
                () -> {
                    log("I'm going to take a bath");
                    sleep(Duration.ofMillis(500L));
                    log("I'm done with the bath");
                });
    }

    static Thread boilingWater() {
        return virtualThread("Boiling water",
                () -> {
                    log("I'm going to boil some water");
                    sleep(Duration.ofSeconds(1L));
                    log("I'm done with the water");
                });
    }

    @SneakyThrows
    private static void sleep(Duration duration) {
        Thread.sleep(duration);
    }

    static void log(String message) {
        logger.info("{} | " + message, Thread.currentThread());
    }
}
