package system.design.ratelimiter.tokenbucket;

import org.junit.Test;
import system.design.ratelimiter.RateLimiter;
import system.design.ratelimiter.identifiers.APIKey;
import system.design.ratelimiter.identifiers.EmailId;
import system.design.ratelimiter.identifiers.Identifier;
import system.design.ratelimiter.slidingwindow.FixedWindow;

import static junit.framework.TestCase.assertEquals;

public class RateLimiterTest {

    @Test
    public void testTokenBucket() throws Exception {
        RateLimiter rl = new TokenBucket(3, 1);
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

    @Test
    public void testFixedWindow() throws Exception {
        RateLimiter rl = new FixedWindow(10, 4);
        Identifier id = new EmailId("tom@abracadabra.com");
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
        assertEquals(true, rl.allow(id));
    }
}
