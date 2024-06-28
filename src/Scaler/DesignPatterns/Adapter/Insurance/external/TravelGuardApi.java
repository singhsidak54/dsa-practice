package Scaler.DesignPatterns.Adapter.Insurance.external;

import Scaler.DesignPatterns.Adapter.Insurance.ApiUtils;

public class TravelGuardApi {

    public void submitClaim(String id, Double amount) {
        ApiUtils.logTravelGuardClaimCall();
    }

    public String getClaimStatus(String id) {
        ApiUtils.logTravelGuardStatusCall();
        return "SUCCESS";
    }
}