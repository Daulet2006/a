package MiniProject.controller;

import AandD.AandD.service.StockMarketService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/market")
public class MarketSimulationController {
    private final StockMarketService stockMarketService;

    public MarketSimulationController(StockMarketService stockMarketService) {
        this.stockMarketService = stockMarketService;
    }

    @PostMapping("/simulate-event") // Изменили маршрут!
    public String simulateMarketEvent(@RequestParam String stockName,
                                      @RequestParam int priceChange,
                                      @RequestParam String event) {
        stockMarketService.addMarketEvent(stockName, priceChange, event);
        return "redirect:/market";
    }
}
