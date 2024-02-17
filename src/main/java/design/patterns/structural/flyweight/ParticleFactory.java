package design.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ParticleFactory {
    private static Map<ParticleType, Sprite> particleTypebySprite = new HashMap<>();


    static Particle getParticle(ParticleType type) {
        Sprite sprite = particleTypebySprite.get(type);
        if(sprite == null) {
            if(type == ParticleType.BULLET) {
                System.out.println("Creating heavy resource for bullet....only once");
                sprite = new Sprite("path to bullet resource");
            }
            if(type == ParticleType.FIREWORK) {
                System.out.println("Creating heavy resource for firework....only once");
                sprite = new Sprite("path to firework resource");
            }
            particleTypebySprite.put(type, sprite);
        }

        return createParticle(type, sprite);
    }

    static Particle createParticle(ParticleType type, Sprite sprite) {
        if(type == ParticleType.BULLET) {
            return new Bullet(sprite);
        }
        if(type == ParticleType.FIREWORK) {
            return new FireWork(sprite);
        }

        return null;
    }

    static enum ParticleType {
        BULLET,
        FIREWORK
    }
}
