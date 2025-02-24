package AandD.AandD.controller;


import AandD.AandD.observer.StockMarket;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/market")
public class StockMarketController {
    private final StockMarket stockMarket;

    public StockMarketController(StockMarket stockMarket) {
        this.stockMarket = stockMarket;
    }

    @PostMapping("/simulate")
    public String simulateMarketEvent() {
        stockMarket.marketEvent();
        return "Биржевое событие сгенерировано!";
    }
}
