package design.patterns.creational.abstractfactory.mac;

import design.patterns.creational.abstractfactory.CheckBox;

public class MacCheckBox implements CheckBox {
    @Override
    public void onSelect() {
        System.out.println("I am a mac checkbox");
    }
}
