package system.design.ratelimiter.slidingwindow;

import system.design.ratelimiter.RateLimiter;
import system.design.ratelimiter.identifiers.Identifier;

import java.util.Deque;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;

public class SlidingWindow implements RateLimiter {

    private static long NANO_SECONDS_PER_SECOND = 1_000_000_000;

    private ConcurrentMap<Identifier, Deque<Long>> idByHistoricalTimeStamps = new ConcurrentHashMap();

    private int fixedTimeWindow;

    private int max;

    public SlidingWindow(int max, int fixedTimeWindow) {
        this.max = max;
        this.fixedTimeWindow = fixedTimeWindow;
    }

    @Override
    public void addId(Identifier id) {
        this.idByHistoricalTimeStamps.put(id, new ConcurrentLinkedDeque<>());
    }

    @Override
    public boolean allow(Identifier id) {
        Optional<Deque<Long>> mayBeTimeStamps = Optional.ofNullable(this.idByHistoricalTimeStamps.get(id));
        if(mayBeTimeStamps.isPresent()) {
            return checkHistoricalTimeStamps(mayBeTimeStamps);
        } else {
            Deque<Long> timeStamps = new ConcurrentLinkedDeque<>();
            timeStamps.add(System.nanoTime());
            this.idByHistoricalTimeStamps.put(id, timeStamps);
            return true;
        }
    }

    private boolean checkHistoricalTimeStamps(Optional<Deque<Long>> mayBeTimeStamps) {
        Deque<Long> historicalTimeStamps = mayBeTimeStamps.get();
        long currentTime = System.nanoTime();
        Long slidingWindowStart = currentTime - this.fixedTimeWindow * NANO_SECONDS_PER_SECOND;

        // remove those timestamps older than current sliding window
        while(!historicalTimeStamps.isEmpty()) {
            if(historicalTimeStamps.peekFirst() < slidingWindowStart) {
                historicalTimeStamps.pollFirst();
            }
        }

        if(historicalTimeStamps.size() < this.max) {
            historicalTimeStamps.addLast(currentTime);
            return true;
        } else {
            return false;
        }
    }
}
