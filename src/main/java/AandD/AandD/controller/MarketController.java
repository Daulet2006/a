package AandD.AandD.controller;

import AandD.AandD.model.StockEvent;
import AandD.AandD.service.StockMarketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/market")
public class MarketController {
    private final StockMarketService stockMarketService;

    public MarketController(StockMarketService stockMarketService) {
        this.stockMarketService = stockMarketService;
    }

    @GetMapping
    public String showMarketPage(Model model) {
        List<StockEvent> marketEvents = stockMarketService.getAllEvents();
        model.addAttribute("marketEvents", marketEvents);
        return "market";
    }

    @PostMapping("/simulate-run")
    public String simulateMarketEvent(@RequestParam String stockName,
                                      @RequestParam int priceChange,
                                      @RequestParam String event) {
        stockMarketService.addMarketEvent(stockName, priceChange, event);
        return "redirect:/market";
    }
}
