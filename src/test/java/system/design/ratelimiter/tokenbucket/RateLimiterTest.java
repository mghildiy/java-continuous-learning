package system.design.ratelimiter.tokenbucket;

import org.junit.Test;
import system.design.ratelimiter.tokenbucket.identifiers.APIKey;
import system.design.ratelimiter.tokenbucket.identifiers.Identifier;

import static junit.framework.TestCase.assertEquals;

public class RateLimiterTest {

    @Test
    public void test() throws Exception{
        RateLimiter rl = new RateLimiter(3, 1);
        Identifier id = new APIKey("101");
        rl.addId(id);

        assertEquals(true, rl.allow(id));
        Thread.sleep(500);
        assertEquals(true, rl.allow(id));
        Thread.sleep(500);
        assertEquals(true, rl.allow(id));
        Thread.sleep(500);
        assertEquals(true, rl.allow(id));
        Thread.sleep(500);
        assertEquals(true, rl.allow(id));
        Thread.sleep(500);
        assertEquals(false, rl.allow(id));
    }
}
