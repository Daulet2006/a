package AandD.AandD.observer;

import AandD.AandD.model.StockEvent;
import AandD.AandD.repository.InvestorRepository;
import AandD.AandD.repository.StockEventRepository;
import AandD.AandD.service.ObserverService;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class StockMarket {
    private final StockEventRepository stockEventRepository;
    private final InvestorRepository investorRepository;
    private final ObserverService observerService;

    private final String[] stocks = {"AAPL", "TSLA", "GOOGL", "AMZN"};
    private final String[] events = {"скандал", "прорыв", "кризис", "прибыль"};

    public StockMarket(StockEventRepository stockEventRepository, InvestorRepository investorRepository, ObserverService observerService) {
        this.stockEventRepository = stockEventRepository;
        this.investorRepository = investorRepository;
        this.observerService = observerService;
    }

    public void marketEvent() {
        Random random = new Random();
        String stock = stocks[random.nextInt(stocks.length)];
        int priceChange = random.nextInt(11) - 5; // -5% до +5%
        String event = events[random.nextInt(events.length)];

        System.out.println("\n📢 Новость: " + stock + " " + event + ", изменение: " + priceChange + "%");

        StockEvent stockEvent = new StockEvent(null, stock, priceChange, event, null);
        stockEventRepository.save(stockEvent);

        observerService.notifyObservers(stockEvent);
    }
}
