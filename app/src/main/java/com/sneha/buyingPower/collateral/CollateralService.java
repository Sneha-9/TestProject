package com.sneha.buyingPower.collateral;

import java.util.List;

public class CollateralService {

    private final CollateralDatabase collateralDatabase;

    CollateralService(CollateralDatabase collateralDatabase) {
        this.collateralDatabase = collateralDatabase;
    }

    public List<CollateralEntry> getEnteries(String userId) {
        return collateralDatabase.getEnteries(userId);
    }
}
