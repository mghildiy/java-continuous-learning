package design.patterns.creational.abstractfactory;

public class UIFactoryProducer {

    static UIFactory getFactory(OSType os) {
        if(os == OSType.Windows)
            return new WindowsUIFactory();
        if(os == OSType.Mac)
            return new MacUIFactory();
        throw new RuntimeException("Incompatible OS");
    }
}
