package design.patterns.structural.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FlyWeightDemo {

    public static void main(String[] args) {
        List<Particle> particles = new ArrayList<>();
        IntStream.range(0, 100)
                .forEach(i -> particles.add(ParticleFactory.getParticle(ParticleFactory.ParticleType.BULLET)));
        if(particles.get(0).sprite != particles.get(99).sprite)
            throw new RuntimeException("Heavy resource created multiple times");
        IntStream.range(0, 100)
                .forEach(i -> particles.add(ParticleFactory.getParticle(ParticleFactory.ParticleType.FIREWORK)));
        if(particles.get(100).sprite != particles.get(199).sprite)
            throw new RuntimeException("Heavy resource created multiple times");
    }
}
