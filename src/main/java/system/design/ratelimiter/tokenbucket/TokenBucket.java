package system.design.ratelimiter.tokenbucket;

import system.design.ratelimiter.RateLimiter;
import system.design.ratelimiter.identifiers.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TokenBucket implements RateLimiter {

    private Map<Identifier, Bucket> idByBucket = new HashMap<>();
    private int max;

    private int refillRate;

    TokenBucket(int max, int refillRate) {
        this.max = max;
        this.refillRate = refillRate;
    }

    public void addId(Identifier id) {
        this.idByBucket.put(id, new Bucket(this.max));
    }

    public boolean allow(Identifier id) {
        Optional<Bucket> mayBeBucket = Optional.ofNullable(this.idByBucket.get(id));
        if(mayBeBucket.isPresent()) {
            boolean allow = false;
            Bucket bucket = mayBeBucket.get();
            bucket.refill(this.refillRate);
            if(bucket.tokenCount() >=1) {
                allow = true;
                bucket.useToken();
            }
            return allow;
        } else {
            Bucket bucket = new Bucket(this.max);
            bucket.useToken();
            this.idByBucket.put(id, bucket);
            return true;
        }
    }

    private static class Bucket {

        private int max;
        private double currentNumTokens;
        private long timeLastReFill;

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
}
