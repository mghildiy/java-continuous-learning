package design.patterns.structural.abstractfactory.windows;

import design.patterns.structural.abstractfactory.CheckBox;

public class WindowsCheckBox implements CheckBox {
    @Override
    public void onSelect() {
        System.out.println("I am a windows checkbox");
    }
}
