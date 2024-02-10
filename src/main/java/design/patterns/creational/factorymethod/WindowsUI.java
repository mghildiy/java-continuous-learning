package design.patterns.creational.factorymethod;

public class WindowsUI extends UI {
    @Override
    protected Button createButton() {
        return new WindowsButton();
    }
}