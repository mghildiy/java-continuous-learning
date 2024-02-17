package design.patterns.structural.proxy;

public class ProxyDemo {

    public static void main(String[] args) {
        CriticalTask proxy = new CriticalComponentProxy();
        proxy.task();
    }
}
