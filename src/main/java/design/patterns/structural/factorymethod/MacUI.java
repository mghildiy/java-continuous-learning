package design.patterns.structural.factorymethod;

public class MacUI extends UI {
    @Override
    protected Button createButton() {
        return new MacButton();
    }
}