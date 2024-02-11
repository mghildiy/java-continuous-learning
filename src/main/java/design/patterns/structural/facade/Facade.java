package design.patterns.structural.facade;

import java.util.Random;

public class Facade {

    void doTask() {
        ComplexSystem cs = new ComplexSystem();
        if(complexLogicToWorkWithComplexSystem())
            cs.doTask1();
        else
            if(complexLogicToWorkWithComplexSystem())
                cs.doTask4();
            else cs.doTask3();
    }

    private boolean complexLogicToWorkWithComplexSystem() {
        System.out.println("Performing complex logic on how to deal with complex system");
        Random rd = new Random();
        if(rd.nextInt(100) > 50)
            return false;
        else return true;
    }
}
