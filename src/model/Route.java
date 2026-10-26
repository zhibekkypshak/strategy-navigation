package model;

public record Route(String mode, double distanceKm, double durationMinutes) {

    @Override
    public String toString() {
        return String.format("%-6s | distance: %.1f km | time: %.0f min",
                mode, distanceKm, durationMinutes);
    }
}
