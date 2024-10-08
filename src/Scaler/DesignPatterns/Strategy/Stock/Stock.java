package Scaler.DesignPatterns.Strategy.Stock;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Stock {
    private Double price;
    private Double previousPrice;
}
