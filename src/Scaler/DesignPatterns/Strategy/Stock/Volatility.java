package Scaler.DesignPatterns.Strategy.Stock;

public class Volatility implements TradingIndicatorStrategy {
    @Override
    public TradingStrategyType supportsType() {
        return TradingStrategyType.VOLATILITY;
    }

    @Override
    public Double calculateIndicator(Stock stock) {
        return Math.abs(stock.getPrice() - stock.getPreviousPrice());
    }
}
