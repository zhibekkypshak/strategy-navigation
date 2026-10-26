package strategy;

import model.Location;
import model.Route;

public class CycleStrategy implements RouteStrategy {

    private static final double BIKE_LANE_FACTOR = 1.2;
    private static final double SPEED_KM_PER_HOUR = 15;

    @Override
    public Route buildRoute(Location from, Location to) {
        double distance = from.straightLineDistanceKm(to) * BIKE_LANE_FACTOR;
        double minutes = distance / SPEED_KM_PER_HOUR * 60;
        return new Route("Cycle", distance, minutes);
    }
}
