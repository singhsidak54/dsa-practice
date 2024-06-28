package Scaler.DesignPatterns.Strategy.Stock;

public interface TradingIndicatorStrategy {
    TradingStrategyType supportsType();

    Double calculateIndicator(Stock stock); // Calculates the trading indicator based on the stock
}