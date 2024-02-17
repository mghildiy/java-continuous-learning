package design.patterns.structural.proxy;

public class SomeCriticalComponent implements CriticalTask {

    @Override
    public void task() {
        System.out.println("Performing critical task");
    }
}
