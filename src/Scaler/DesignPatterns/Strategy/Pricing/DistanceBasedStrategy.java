package Scaler.DesignPatterns.Strategy.Pricing;

import static Scaler.DesignPatterns.Strategy.Pricing.PricingManager.BASE_FARE;

public class DistanceBasedStrategy implements PricingStrategy {
    private static final double PER_KILOMETER_RATE = 2.0; // Rate per kilometer

    @Override
    public PricingType supportsType() {
        return PricingType.DISTANCE_BASED;
    }

    @Override
    public Double calculatePrice(RideDetails rideDetails) {
        return BASE_FARE + PER_KILOMETER_RATE * rideDetails.getDistance();
    }
}
