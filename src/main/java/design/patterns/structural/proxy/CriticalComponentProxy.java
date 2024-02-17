package design.patterns.structural.proxy;

public class CriticalComponentProxy implements CriticalTask {

    private CriticalTask component;

    CriticalComponentProxy() {
        this.component = new SomeCriticalComponent();
    }

    @Override
    public void task() {
        additionalTask();
        this.component.task();
    }

    private void additionalTask() {
        System.out.println("Performing additional task that main component doesn't do...like caching, logging, user authorization etc");
    }
}
