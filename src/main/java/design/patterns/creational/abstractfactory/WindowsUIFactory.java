package design.patterns.creational.abstractfactory;

import design.patterns.creational.abstractfactory.windows.WindowsButton;
import design.patterns.creational.abstractfactory.windows.WindowsCheckBox;

public class WindowsUIFactory implements UIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
