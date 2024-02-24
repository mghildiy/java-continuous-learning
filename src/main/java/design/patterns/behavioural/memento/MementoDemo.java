package design.patterns.behavioural.memento;

public class MementoDemo {

    public static void main(String[] args) {
        SuperHero superHero = new SuperHero();
        SuperHeroCaretaker caretaker = new SuperHeroCaretaker(superHero);
        superHero.updatePosition(10.5f, -20.23f);
        caretaker.save();
        superHero.updatePower(14);
        caretaker.save();
        caretaker.undo();
        if(superHero.getPower() != 100.0) {
            throw new RuntimeException("Correct state not restored");
        }
    }
}
