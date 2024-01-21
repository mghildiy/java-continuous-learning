package system.design.ratelimiter.tokenbucket;

import system.design.ratelimiter.tokenbucket.identifiers.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RateLimiter {

    private Map<Identifier, Bucket> idByBucket = new HashMap<>();
    private int max;

    private int refillRate;

    RateLimiter(int max, int refillRate) {
        this.max = max;
        this.refillRate = refillRate;
    }

    public void addId(Identifier id) {
        this.idByBucket.put(id, new Bucket(this.max));
    }

    public boolean allow(Identifier id) {
        Optional<Bucket> mayBeBucket = Optional.of(this.idByBucket.get(id));
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
}
