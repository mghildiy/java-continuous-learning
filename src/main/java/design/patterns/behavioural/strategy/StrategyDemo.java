package design.patterns.behavioural.strategy;

import java.util.random.RandomGenerator;

public class StrategyDemo {

    public static void main(String[] args) {
        Context context = new Context();
        Point start = new Point(0,0);
        Point end = new Point(100,100);
        context.setStrategy(decideStrategy());
        context.findPath(start, end);

        // change strategy
        context.setStrategy(decideStrategy());
        context.findPath(start, end).toString();
    }

    static PathStrategy decideStrategy() {
        int i = RandomGenerator.getDefault().nextInt(0, 100);
        if(i < 40)
            return new AStar();
        else
            if(i < 70)
                return new Dijkstra();
            else return new BellmanFord();
    }
}
