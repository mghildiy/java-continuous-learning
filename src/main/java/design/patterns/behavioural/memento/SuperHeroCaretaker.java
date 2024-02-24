package design.patterns.behavioural.memento;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// Caretaker for superhero to save and undo superhero state
public class SuperHeroCaretaker {
    SuperHero originator = new SuperHero();
    Deque<Memento> states = new ArrayDeque();

    SuperHeroCaretaker(SuperHero superHero) {
        this.originator = superHero;
    }

    void save() {
        states.add(originator.save());
    }

    void undo() {
        this.states.removeLast(); // first we remove last state as it is same as current state of originator
        this.originator.reStore(this.states.getLast()); // then we set state of originator to state at end
    }
}
