package AandD.AandD.service;


import AandD.AandD.model.Investor;
import AandD.AandD.repository.InvestorRepository;
import AandD.AandD.strategy.InvestmentStrategyType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestorService {
    private final InvestorRepository investorRepository;

    public InvestorService(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }

    public Investor addInvestor(String name, InvestmentStrategyType strategy) {
        Investor investor = new Investor(null, name, strategy);
        return investorRepository.save(investor);
    }

    public void changeStrategy(Long id, InvestmentStrategyType newStrategy) {
        Investor investor = investorRepository.findById(id).orElseThrow();
        investor.setStrategyType(newStrategy);
        investorRepository.save(investor);
    }

    public void removeInvestor(Long id) {
        investorRepository.deleteById(id);
    }

    public Investor getInvestorById(Long id) {
        return investorRepository.findById(id).orElseThrow();
    }
}

