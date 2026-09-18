package com.sneha.farmingSystem;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SingleDimensionalFarmingSystem implements FarmingSystem{
    private SingleDimensionalFarmland singleDimensionalFarmland;
    private ProfitCostCalculator profitCostCalculator;

    @Override
    public CropData getCropData(CropValueEstimator cropValueEstimator) {
        return profitCostCalculator.calculate(singleDimensionalFarmland, cropValueEstimator);
    }
}
