package AandD.AandD.controller;

import AandD.AandD.model.Investor;
import AandD.AandD.service.InvestorService;
import AandD.AandD.strategy.InvestmentStrategyType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/investors")
public class InvestorController {
    private final InvestorService investorService;

    public InvestorController(InvestorService investorService) {
        this.investorService = investorService;
    }

    @GetMapping
    public List<Investor> getAllInvestors() {
        return investorService.getAllInvestors();
    }

    @PostMapping
    public Investor addInvestor(@RequestParam String name, @RequestParam InvestmentStrategyType strategy) {
        return investorService.addInvestor(name, strategy);
    }

    @PutMapping("/{id}/strategy")
    public void changeStrategy(@PathVariable Long id, @RequestParam InvestmentStrategyType newStrategy) {
        investorService.changeStrategy(id, newStrategy);
    }

    @DeleteMapping("/{id}")
    public void removeInvestor(@PathVariable Long id) {
        investorService.removeInvestor(id);
    }

    @GetMapping("/{id}")
    public Investor getInvestorById(@PathVariable Long id) {
        return investorService.getInvestorById(id);
    }
}