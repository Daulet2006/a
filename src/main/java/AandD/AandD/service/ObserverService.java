package AandD.AandD.service;

import AandD.AandD.model.Investor;
import AandD.AandD.model.StockEvent;
import AandD.AandD.repository.InvestorRepository;
import AandD.AandD.strategy.InvestmentStrategyType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObserverService {
    private final InvestorRepository investorRepository;
    private final SimulationLogService logService;

    public ObserverService(InvestorRepository investorRepository, SimulationLogService logService) {
        this.investorRepository = investorRepository;
        this.logService = logService;
    }

    public void notifyObservers(StockEvent event) {
        logService.clearLogs();
        List<String> messages = new ArrayList<>();

        messages.add("📢 Рыночное событие: " + event.getStockName() + " | " + event.getPriceChange() + "% | " + event.getEvent());

        List<Investor> investors = investorRepository.findAll();
        for (Investor investor : investors) {
            if (investor.getStrategyType() == InvestmentStrategyType.CONSERVATIVE) {
                messages.add(handleConservativeInvestor(investor, event));
            } else {
                messages.add(handleAggressiveInvestor(investor, event));
            }
        }

        logService.addLogs(messages);
    }

    private String handleConservativeInvestor(Investor investor, StockEvent event) {
        if (event.getPriceChange() <= -5) {
            return "🏦 " + investor.getName() + " (Консервативный) покупает " + event.getStockName() + " после падения " + event.getPriceChange() + "%";
        }
        return "🟡 " + investor.getName() + " (Консервативный) ждет изменений.";
    }

    private String handleAggressiveInvestor(Investor investor, StockEvent event) {
        if (event.getPriceChange() < -3) {
            return "🔥 " + investor.getName() + " (Агрессивный) покупает " + event.getStockName() + " после падения " + event.getPriceChange() + "%";
        } else if (event.getPriceChange() > 3) {
            return "🚀 " + investor.getName() + " (Агрессивный) продаёт " + event.getStockName() + " после роста " + event.getPriceChange() + "%";
        }
        return "⚖️ " + investor.getName() + " (Агрессивный) не меняет позицию.";
    }
}
