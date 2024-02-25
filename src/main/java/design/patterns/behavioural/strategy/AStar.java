package design.patterns.behavioural.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class AStar implements PathStrategy {
    @Override
    public Path calculatePath(Point start, Point end) {
        List<Point> path = new ArrayList<>();
        path.add(start);
        Random rnd = new Random();
        IntStream
                .of(rnd.nextInt(10))
                .forEach(i -> path.add(new Point(rnd.nextDouble(0, 100.0), rnd.nextDouble(0,100.0))));
        path.add(end);

        return new Path(path);
    }
}
