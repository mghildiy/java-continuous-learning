package design.patterns.creational.abstractfactory.mac;

import design.patterns.creational.abstractfactory.Button;

public class MacButton implements Button {
    @Override
    public void onClick() {
        System.out.println("I am a mac button");
    }
}
