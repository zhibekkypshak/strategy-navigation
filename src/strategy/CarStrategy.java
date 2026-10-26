package strategy;

import model.Location;
import model.Route;

public class CarStrategy implements RouteStrategy {

    private static final double ROAD_FACTOR = 1.3;
    private static final double SPEED_KM_PER_HOUR = 60;

    @Override
    public Route buildRoute(Location from, Location to) {
        double distance = from.straightLineDistanceKm(to) * ROAD_FACTOR;
        double minutes = distance / SPEED_KM_PER_HOUR * 60;
        return new Route("Car", distance, minutes);
    }
}