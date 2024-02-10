package design.patterns.structural.factorymethod;

public abstract class UI {
    void render() {
        Button b = createButton();
        b.onClick();
    }

    protected abstract Button createButton();
}
