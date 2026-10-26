package app;

import context.Navigator;
import model.Location;
import strategy.CarStrategy;
import strategy.CycleStrategy;
import strategy.RouteStrategy;
import strategy.WalkStrategy;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<String, RouteStrategy> strategies = Map.of(
                "car", new CarStrategy(),
                "walk", new WalkStrategy(),
                "cycle", new CycleStrategy()
        );

        Location from = new Location("Home", 0, 0);
        Location to = new Location("University", 6, 8);

        Navigator navigator = new Navigator(strategies.get("car"));
        System.out.println("Default: " + navigator.planRoute(from, to));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Choose mode (car / walk / cycle / exit): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (choice.equals("exit")) {
                break;
            }
            RouteStrategy selected = strategies.get(choice);
            if (selected == null) {
                System.out.println("Unknown mode.");
                continue;
            }
            navigator.setStrategy(selected);
            System.out.println(navigator.planRoute(from, to));
        }
    }
}