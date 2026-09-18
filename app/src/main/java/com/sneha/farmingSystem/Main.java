package com.sneha.farmingSystem;

public class Main {
    public static void main(String[] args) {
        Money wheatCostPrice = new Money(10);
        Money wheatSellingPrice = new Money(20);

        Crop wheat = new Crop(wheatCostPrice, wheatSellingPrice,PlantationTool.SAW,CropType.WHEAT,3);

        Money riceCostPrice = new Money(20);
        Money riceSellingPrice = new Money(40);

        Crop rice = new Crop(riceCostPrice, riceSellingPrice,PlantationTool.SAW,CropType.RICE,2);

        SingleDimensionalFarmland singleDimensionalFarmLand = new SingleDimensionalFarmland(5);

        singleDimensionalFarmLand.addCrop(0,wheat);
        singleDimensionalFarmLand.addCrop(1,wheat);
        singleDimensionalFarmLand.addCrop(2,rice);
        singleDimensionalFarmLand.addCrop(3,rice);

        ProfitCostCalculator profitCostCalculator = new ProfitCostCalculator();
        CropValueEstimator cropValueEstimator = new CropValueEstimator(2);
        SingleDimensionalFarmingSystem singleDimensionalFarmingSystem = new SingleDimensionalFarmingSystem(singleDimensionalFarmLand,profitCostCalculator);
        CropData  cropData = singleDimensionalFarmingSystem.getCropData(cropValueEstimator);
        System.out.println(cropData.getCostIncurred().getValue()+ " "+ cropData.getProfit().getValue());




    }
}
