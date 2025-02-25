package AandD.AandD.strategy;

import AandD.AandD.websocket.StockMarketWebSocketHandler;
import org.springframework.stereotype.Component;

@Component
public class AggressiveStrategy implements InvestmentStrategy {
    private StockMarketWebSocketHandler webSocketHandler = new StockMarketWebSocketHandler();

    public AggressiveStrategy() {
        this.webSocketHandler = webSocketHandler;
    }

    @Override
    public void execute(String investorName, String stock, int priceChange, String event) {
        String message;
        if (priceChange > 0) {
            message = "🔥 " + investorName + " ПОКУПАЕТ " + stock + " (+ " + priceChange + "%)";
        } else {
            message = "⚠️ " + investorName + " ПРОДАЁТ " + stock + " (-" + priceChange + "%)";
        }

        webSocketHandler.broadcast(message);
    }
}
