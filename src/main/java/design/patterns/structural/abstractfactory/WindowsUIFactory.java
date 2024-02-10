package design.patterns.structural.abstractfactory;

import design.patterns.structural.abstractfactory.windows.WindowsButton;
import design.patterns.structural.abstractfactory.windows.WindowsCheckBox;

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
