package design.patterns.creational.factorymethod;

/*
design pattern that provides an interface for creating objects of same type OR
provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.
Client code is not coupled with object creation as object creation is now done by responsible classes(S of SOLID).
Any new type to be added to the system can be done with only modifying factory emthod code(O, L of SOLID).
 */
public class FactoryMethodDemo {

    public static void main(String[] args) {
        UI ui = UIFactory.createUI("Mac");
        ui.render();
    }

     class UIFactory {
        // UI factory method
        static UI createUI(String osType) {
            if(osType.equals("Windows"))
                return new WindowsUI();
            else if(osType.equals("Mac")) {
                return new MacUI();
            } else
                throw new RuntimeException("Incompatible OS");
        }
    }
}
