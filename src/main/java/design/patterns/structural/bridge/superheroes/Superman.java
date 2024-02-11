package design.patterns.structural.bridge.superheroes;

import design.patterns.structural.bridge.superheroes.FlyingSuperHero;
import design.patterns.structural.bridge.weapons.Weapon;

import java.util.List;

public class Superman extends FlyingSuperHero {

    public Superman(List<Weapon> weapons) {
        this.weapons = weapons;
    }
    @Override
    public void fly() {
        System.out.println("I am superman and can fly across universe");
    }

    @Override
    public void showYourCapability() {
        this.weapons.forEach(w -> w.attack());
    }
}
