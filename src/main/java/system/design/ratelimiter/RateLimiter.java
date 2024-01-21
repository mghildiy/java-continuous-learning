package system.design.ratelimiter;

import system.design.ratelimiter.identifiers.Identifier;

public interface RateLimiter {

    public void addId(Identifier id);

    public boolean allow(Identifier id);
}
