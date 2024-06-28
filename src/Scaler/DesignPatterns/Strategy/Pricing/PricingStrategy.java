package Scaler.DesignPatterns.Strategy.Pricing;

public interface PricingStrategy {
    PricingType supportsType(); // Returns the type of pricing the strategy supports

    Double calculatePrice(RideDetails rideDetails); // Calculates the price based on the ride details
}