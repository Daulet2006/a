package AandD.AandD.service;

import AandD.AandD.model.StockEvent;
import AandD.AandD.observer.StockMarket;
import AandD.AandD.repository.StockEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockMarketService {
    private final StockEventRepository stockEventRepository;
    private final StockMarket stockMarket;

    public StockMarketService(StockEventRepository stockEventRepository, StockMarket stockMarket) {
        this.stockEventRepository = stockEventRepository;
        this.stockMarket = stockMarket;
    }

    public List<StockEvent> getAllEvents() {
        return stockEventRepository.findAll();
    }

    public StockEvent addMarketEvent(String stockName, int priceChange, String event) {
        StockEvent stockEvent = new StockEvent(null, stockName, priceChange, event, null);
        return stockEventRepository.save(stockEvent);
    }

    public void triggerRandomEvent() {
        stockMarket.marketEvent();
    }
}
