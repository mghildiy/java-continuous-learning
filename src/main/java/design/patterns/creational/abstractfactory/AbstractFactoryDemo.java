package design.patterns.creational.abstractfactory;

/*
creational design pattern that lets you produce families of related objects without specifying their concrete classes
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        UIFactory factory = UIFactoryProducer.getFactory(OSType.Windows);
        factory.createButton().onClick();
        factory.createCheckBox().onSelect();
    }
}
