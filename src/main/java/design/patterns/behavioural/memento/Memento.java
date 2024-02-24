package design.patterns.behavioural.memento;

// Represents saved state of originator
public class Memento {
    private SuperHero.Position pos;
    private float power;

    Memento(SuperHero.Position pos, float power) {
        this.pos = pos;
        this.power = power;
    }

    SuperHero.Position getPosition() {
        return this.pos;
    }

    float getPower() {
        return this.power;
    }
}
