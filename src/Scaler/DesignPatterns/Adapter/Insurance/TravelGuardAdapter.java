package Scaler.DesignPatterns.Adapter.Insurance;

import Scaler.DesignPatterns.Adapter.Insurance.external.TravelGuardApi;

public class TravelGuardAdapter implements TravelInsuranceAdapter {

    TravelGuardApi api;

    public TravelGuardAdapter() {
        this.api = new TravelGuardApi();
    }

    @Override
    public void add(String id, Double amount) {
        this.api.submitClaim(id, amount);
    }

    @Override
    public String getStatusOfClaim(String id) {
        return this.api.getClaimStatus(id);
    }
}
