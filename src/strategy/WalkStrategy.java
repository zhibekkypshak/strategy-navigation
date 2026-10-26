package strategy;

import model.Location;
import model.Route;

public class WalkStrategy implements RouteStrategy {

    private static final double PATH_FACTOR = 1.1;
    private static final double SPEED_KM_PER_HOUR = 5;

    @Override
    public Route buildRoute(Location from, Location to) {
        double distance = from.straightLineDistanceKm(to) * PATH_FACTOR;
        double minutes = distance / SPEED_KM_PER_HOUR * 60;
        return new Route("Walk", distance, minutes);
    }
}
