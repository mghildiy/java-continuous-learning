package design.patterns.behavioural.memento;

// Originator for superhero: whose state has to be saved and restored
public class SuperHero {

    private Position pos = new Position();
    private float power = 100.0f;

    void updatePosition(float x, float y) {
        this.pos.x = x;
        this.pos.y = y;
    }

    void updatePower(float power) {
        this.power = power;
    }

    Memento save() {
        return new Memento(this.pos, this.power);
    }

    void reStore(Memento restoreTo) {
        if(restoreTo != null) {
            this.pos = restoreTo.getPosition();
            this.power = restoreTo.getPower();
        }
    }

    float getPower() {
        return this.power;
    }

    Position getPosition() {
        return this.pos;
    }

    static class Position {
        private float x,y;

        Position() {
            this.x = 0.0f;
            this.y = 0.0f;
        }
    }
}
