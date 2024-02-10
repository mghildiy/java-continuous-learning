package design.patterns.creational.abstractfactory.windows;

import design.patterns.creational.abstractfactory.Button;

public class WindowsButton implements Button {
    @Override
    public void onClick() {
        System.out.println("I am a windows button");
    }
}
