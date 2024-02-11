package design.patterns.structural.bridge.superheroes;

import design.patterns.structural.bridge.weapons.Weapon;

import java.util.List;

public abstract class SuperHero {

    // use composition to aggregate weapons
    List<Weapon> weapons;

    public abstract void showYourCapability();
}
