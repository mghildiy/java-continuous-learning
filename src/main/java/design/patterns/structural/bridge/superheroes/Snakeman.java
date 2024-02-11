package design.patterns.structural.bridge.superheroes;

import design.patterns.structural.bridge.superheroes.MutantSuperHero;
import design.patterns.structural.bridge.weapons.Weapon;

import java.util.List;

public class Snakeman extends MutantSuperHero {

    public Snakeman(List<Weapon> weapons) {
        this.weapons = weapons;
    }
    @Override
    public void transform() {
        System.out.println("I am snakeman and can transform to a snake");
    }

    @Override
    public void showYourCapability() {
        this.weapons.forEach(w -> w.attack());
    }
}
