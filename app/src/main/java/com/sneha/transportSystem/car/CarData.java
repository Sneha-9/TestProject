package com.sneha.transportSystem.car;

import com.sneha.transportSystem.Rate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CarData {
    private Car car;
    private Rate rate;
}
