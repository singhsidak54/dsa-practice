package Scaler.DesignPatterns.Adapter.Insurance;

import Scaler.DesignPatterns.Adapter.Insurance.external.AutoProtectApi;


public class AutoProtectAdapter implements TravelInsuranceAdapter {
    AutoProtectApi api;

    public AutoProtectAdapter() {
        super();
        this.api = new AutoProtectApi();
    }

    @Override
    public void add(String id, Double amount) {
        this.api.addClaim(amount);
    }

    @Override
    public String getStatusOfClaim(String id) {
        return this.api.getStatus(id).toString();
    }
}
