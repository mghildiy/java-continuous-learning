package design.patterns.creational.abstractfactory;

import design.patterns.creational.abstractfactory.mac.MacButton;
import design.patterns.creational.abstractfactory.mac.MacCheckBox;

public class MacUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}
