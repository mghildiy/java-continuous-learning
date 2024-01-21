package system.design.ratelimiter.tokenbucket;

public class Bucket {

    private int max;
    private double currentNumTokens;
    private long timeLastReFill;

    //private int refillRate;

    Bucket(int max) {
        this.max = max;
        this.currentNumTokens = max;
        this.timeLastReFill = System.nanoTime();
    }

    void useToken() {
        this.currentNumTokens -= 1;
    }

    double tokenCount() {
        return this.currentNumTokens;
    }

    void refill(int refillRate) {
        long now = System.nanoTime();
        long timeElapsed = now - this.timeLastReFill;
        double tokensToAdd = (timeElapsed / 1_000_000_000.0) * refillRate;
        this.currentNumTokens = Math.min(this.currentNumTokens + tokensToAdd, this.max);
        this.timeLastReFill = now;
    }
}
