package design.patterns.behavioural.strategy;

public class Context {

    PathStrategy strategy;

    void setStrategy(PathStrategy pathStrategy) {
        this.strategy = pathStrategy;
    }

    public Path findPath(Point a, Point b) {
        return this.strategy.calculatePath(a, b);
    }
}
