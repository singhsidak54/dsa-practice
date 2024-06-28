package Scaler.DesignPatterns.Adapter.Insurance.external;

import Scaler.DesignPatterns.Adapter.Insurance.ApiUtils;

public class AutoProtectApi {

    public void addClaim(Double amount) {
        ApiUtils.logAutoProtectClaimCall();
    }

    public AutoProtectStatus getStatus(String id) {
        ApiUtils.logAutoProtectStatusCall();
        return AutoProtectStatus.APPROVED;
    }
}