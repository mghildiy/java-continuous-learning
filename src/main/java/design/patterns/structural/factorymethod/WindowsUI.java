package design.patterns.structural.factorymethod;

public class WindowsUI extends UI {
    @Override
    protected Button createButton() {
        return new WindowsButton();
    }
}