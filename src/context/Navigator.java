package context;

import model.Location;
import model.Route;
import strategy.RouteStrategy;

import java.util.Objects;

public class Navigator {

    private RouteStrategy strategy;

    public Navigator(RouteStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy);
    }

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy);
    }

    public Route planRoute(Location from, Location to) {
        return strategy.buildRoute(from, to);
    }
}