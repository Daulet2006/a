package AandD.AandD.controller;

import AandD.AandD.model.Investor;
import AandD.AandD.observer.StockMarket;
import AandD.AandD.service.InvestorService;
import AandD.AandD.strategy.InvestmentStrategyType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/investors")
public class InvestorController {
    private final InvestorService investorService;
    private final StockMarket stockMarket;

    public InvestorController(InvestorService investorService, StockMarket stockMarket) {
        this.investorService = investorService;
        this.stockMarket = stockMarket;
    }

    @GetMapping
    public String getInvestors(Model model) {
        List<Investor> investors = investorService.getAllInvestors();
        model.addAttribute("investors", investors);
        return "market";
    }

    @PostMapping("/add")
    public String addInvestor(@RequestParam String name, @RequestParam InvestmentStrategyType strategy) {
        Investor investor = investorService.addInvestor(name, strategy);
        stockMarket.addObserver(investor);
        return "redirect:/investors";
    }

    @PostMapping("/delete")
    public String deleteInvestor(@RequestParam Long id) {
        Investor investor = investorService.getInvestorById(id);
        stockMarket.removeObserver(investor);
        investorService.removeInvestor(id);
        return "redirect:/investors";
    }
}
