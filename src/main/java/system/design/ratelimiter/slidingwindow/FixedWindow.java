package system.design.ratelimiter.slidingwindow;

import system.design.ratelimiter.RateLimiter;
import system.design.ratelimiter.identifiers.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FixedWindow implements RateLimiter {

    private Map<Identifier, Window> idByWindow = new HashMap<>();

    private int max;

    private long windowSize;

    public FixedWindow(int max, long windowSize) {
        this.max = max;
        this.windowSize = windowSize;
    }

    @Override
    public void addId(Identifier id) {
        idByWindow.put(id, new Window());
    }

    @Override
    public boolean allow(Identifier id) {
        Optional<Window> mayBeWindow = Optional.ofNullable(this.idByWindow.get(id));
        if(mayBeWindow.isPresent()) {
            Window window = mayBeWindow.get();
            if(window.startTime / 1_000_000_000.0 + this.windowSize > System.nanoTime() / 1_000_000_000.0 ) {
                if(window.counter < this.max) {
                    window.counter += 1;
                    return true;
                } else {
                    return false;
                }
            } else {
                addOrUpdateWindow(id);
                return true;
            }
        } else {
            addOrUpdateWindow(id);
            return true;
        }
    }

    private void addOrUpdateWindow(Identifier id) {
        Window window = new Window();
        window.counter = 1;
        this.idByWindow.put(id, new Window());
    }

    private static class Window {
        long startTime;
        int counter = 0;

        Window() {
            this.startTime = System.nanoTime();
        }
    }
}
