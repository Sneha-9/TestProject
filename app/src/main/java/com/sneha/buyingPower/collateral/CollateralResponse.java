package com.sneha.buyingPower.collateral;

import java.util.List;

public class CollateralResponse {
    private List<CollateralEntry> collateralEntries;
    CollateralResponse(List<CollateralEntry> collateralEntries){
        this.collateralEntries = collateralEntries;
    }

    public List<CollateralEntry> getCollateralEntries() {
        return collateralEntries;
    }
}
