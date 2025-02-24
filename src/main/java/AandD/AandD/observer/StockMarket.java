package AandD.AandD.observer;


import AandD.AandD.model.Investor;
import AandD.AandD.strategy.AggressiveStrategy;
import AandD.AandD.strategy.ConservativeStrategy;
import AandD.AandD.strategy.InvestmentStrategy;
import AandD.AandD.strategy.InvestmentStrategyType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class StockMarket {
    private final List<Investor> investors = new ArrayList<>();
    private final String[] stocks = {"AAPL", "TSLA", "GOOGL", "AMZN"};
    private final String[] events = {"скандал", "прорыв", "кризис", "прибыль"};

    public void addObserver(Investor investor) {
        investors.add(investor);
    }

    public void removeObserver(Investor investor) {
        investors.remove(investor);
    }

    public void marketEvent() {
        Random random = new Random();
        String stock = stocks[random.nextInt(stocks.length)];
        int priceChange = random.nextInt(11) - 5; // -5% до +5%
        String event = events[random.nextInt(events.length)];

        System.out.println("\n📢 Новость: " + stock + " " + event + ", изменение: " + priceChange + "%");

        for (Investor investor : investors) {
            InvestmentStrategy strategy = investor.getStrategyType() == InvestmentStrategyType.AGGRESSIVE
                    ? new AggressiveStrategy()
                    : new ConservativeStrategy();
            strategy.execute(investor.getName(), stock, priceChange, event);
        }
    }
}
