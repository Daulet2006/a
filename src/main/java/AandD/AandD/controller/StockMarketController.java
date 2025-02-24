package AandD.AandD.controller;

import AandD.AandD.model.StockEvent;
import AandD.AandD.service.StockMarketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/market")
public class StockMarketController {
    private final StockMarketService stockMarketService;

    public StockMarketController(StockMarketService stockMarketService) {
        this.stockMarketService = stockMarketService;
    }

    @GetMapping("/events")
    public  List<StockEvent> getAllEvents() {
        return stockMarketService.getAllEvents();
    }

    @PostMapping("/event")
    public StockEvent addMarketEvent(@RequestParam String stockName, @RequestParam int priceChange, @RequestParam String event) {
        return stockMarketService.addMarketEvent(stockName, priceChange, event);
    }
}
