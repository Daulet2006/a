package AandD.AandD.strategy;

import AandD.AandD.websocket.StockMarketWebSocketHandler;
import org.springframework.stereotype.Component;

@Component
public class ConservativeStrategy implements InvestmentStrategy {

    private StockMarketWebSocketHandler webSocketHandler = new StockMarketWebSocketHandler();

    public ConservativeStrategy() {
        this.webSocketHandler = webSocketHandler;
    }

    @Override
    public void execute(String investorName, String stock, int priceChange, String event) {
        String message;
        if (priceChange > 3) {
            message = "🟢 " + investorName + " ПОКУПАЕТ " + stock + " (+ " + priceChange + "%)";
        } else {
            message = "🟡 " + investorName + " ОЖИДАЕТ изменений.";
        }

        webSocketHandler.broadcast(message);  // Отправка сообщения через WebSocket
    }
}
