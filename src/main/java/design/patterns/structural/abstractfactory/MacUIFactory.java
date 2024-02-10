package design.patterns.structural.abstractfactory;

import design.patterns.structural.abstractfactory.mac.MacButton;
import design.patterns.structural.abstractfactory.mac.MacCheckBox;

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
