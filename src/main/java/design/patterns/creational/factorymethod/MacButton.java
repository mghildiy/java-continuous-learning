package design.patterns.creational.factorymethod;

public class MacButton implements Button {

    @Override
    public void onClick() {
        System.out.println("I am a mac button.");
    }
}
