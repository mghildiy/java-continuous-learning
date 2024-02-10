package design.patterns.structural.abstractfactory.windows;

import design.patterns.structural.abstractfactory.Button;

public class WindowsButton implements Button {
    @Override
    public void onClick() {
        System.out.println("I am a windows button");
    }
}
