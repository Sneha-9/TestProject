package com.sneha.farmingSystem;

public class ProfitCostCalculator implements CostCalculator{

    CropData calculate(SingleDimensionalFarmland singleDimensionalFarmland, CropValueEstimator cropValueEstimator){
        int durationMonths = cropValueEstimator.getMonths();
        int totalCostIncurred=0;
        int totalProfit =0 ;
        int  totalProfitAfterCostIncurred=0;

        for(Crop crop: singleDimensionalFarmland.getFarm()) {
            if (crop != null) {
                if (durationMonths == crop.getDuration()) {
                    totalProfit = totalProfit + (crop.getSellingPrice().getValue() * crop.getDuration() - crop.getCostPrice().getValue() * crop.getDuration());

                }
                if (durationMonths < crop.getDuration()) {
                    totalCostIncurred = totalCostIncurred + crop.getCostPrice().getValue() * durationMonths;
                }
                totalProfitAfterCostIncurred = totalProfit - totalCostIncurred;
            }
        }
        return  new CropData(new Money(totalCostIncurred), new Money(totalProfitAfterCostIncurred));
    }
}
