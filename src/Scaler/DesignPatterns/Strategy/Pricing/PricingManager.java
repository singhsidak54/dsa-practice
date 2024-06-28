package Scaler.DesignPatterns.Strategy.Pricing;

public class PricingManager {

    static final double BASE_FARE = 5.0; // Base fare amount

    private PricingStrategy pricingStrategy;

    public PricingManager(PricingType pricingType, PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public Double calculatePrice(RideDetails rideDetails) {
        return pricingStrategy.calculatePrice(rideDetails);
    }
}