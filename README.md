# Strategy Pattern — Navigation / Route Planning

Java 17 implementation of the Strategy pattern. A `Navigator` (Context) plans a route
using an interchangeable `RouteStrategy` (Car, Walk, Cycle).

## Build and run
```
javac -d out src/model/*.java src/strategy/*.java src/context/*.java src/app/*.java
java -cp out app.Main
```
Type `car`, `walk` or `cycle` to switch the strategy at runtime, `exit` to quit.

## How to add a new strategy
1. Create `src/strategy/BusStrategy.java` implementing `RouteStrategy`.
2. Register it in the `Map` in `Main`: `"bus", new BusStrategy()`.
   No existing class (Navigator, other strategies) needs to be changed.

```java
public class BusStrategy implements RouteStrategy {
    public Route buildRoute(Location from, Location to) {
        double distance = from.straightLineDistanceKm(to) * 1.4;
        return new Route("Bus", distance, distance / 25 * 60);
    }
}
```

## Structure
- `model` — Location, Route
- `strategy` — RouteStrategy and concrete strategies
- `context` — Navigator
- `app` — Main (client)