package design.patterns.structural.abstractfactory;

public class UIFactoryProducer {

    static UIFactory getFactory(OSType os) {
        if(os == OSType.Windows)
            return new WindowsUIFactory();
        if(os == OSType.Mac)
            return new MacUIFactory();
        throw new RuntimeException("Incompatible OS");
    }
}
