package design.patterns.creational.abstractfactory.windows;

import design.patterns.creational.abstractfactory.CheckBox;

public class WindowsCheckBox implements CheckBox {
    @Override
    public void onSelect() {
        System.out.println("I am a windows checkbox");
    }
}
