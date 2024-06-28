package Scaler.DesignPatterns.Adapter.Insurance;

public interface TravelInsuranceAdapter {

    void add(String id, Double amount);

    String getStatusOfClaim(String id);
}