package design.patterns.structural.facade;

public class Client {

    void doTask() {
        Facade facade = new Facade();
        // we delegate complex handling to facade
        facade.doTask();
    }
}
