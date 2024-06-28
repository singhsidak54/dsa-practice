package Scaler.DesignPatterns.Strategy.Stock;

public class StockTradingManager {

    private TradingIndicatorStrategy tradingIndicatorStrategy;

    public StockTradingManager(TradingIndicatorStrategy tradingIndicatorStrategy) {
        this.tradingIndicatorStrategy = tradingIndicatorStrategy;
    }

    public Double calculateIndicator(Stock stock) {
        return tradingIndicatorStrategy.calculateIndicator(stock);
    }
}