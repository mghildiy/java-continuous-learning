package design.patterns.structural.abstractfactory.mac;

import design.patterns.structural.abstractfactory.Button;

public class MacButton implements Button {
    @Override
    public void onClick() {
        System.out.println("I am a mac button");
    }
}
