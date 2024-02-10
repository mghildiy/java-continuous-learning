package design.patterns.structural.abstractfactory.mac;

import design.patterns.structural.abstractfactory.CheckBox;

public class MacCheckBox implements CheckBox {
    @Override
    public void onSelect() {
        System.out.println("I am a mac checkbox");
    }
}
