package design.patterns.structural.bridge;

import design.patterns.structural.bridge.superheroes.*;
import design.patterns.structural.bridge.weapons.BoomingGun;
import design.patterns.structural.bridge.weapons.Sword;
import java.util.List;

public class BridgeDemo {

    public static void main(String[] args) {
        FlyingSuperHero supermanWithSword = new Superman(List.of(new Sword(), new BoomingGun()));
        supermanWithSword.fly();
        supermanWithSword.showYourCapability();
        MutantSuperHero snakemanWithBoomingGun = new Snakeman(List.of(new BoomingGun()));
        snakemanWithBoomingGun.transform();
        snakemanWithBoomingGun.showYourCapability();
    }
}
