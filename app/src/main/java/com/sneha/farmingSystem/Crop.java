package com.sneha.farmingSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Crop {
    private Money costPrice;
    private Money sellingPrice;
    private PlantationTool plantationTool;
    private CropType cropType;
    private int duration;


}
