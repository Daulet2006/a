package AandD.AandD.service;

import AandD.AandD.model.Investor;
import AandD.AandD.model.StockEvent;
import AandD.AandD.repository.InvestorRepository;
import AandD.AandD.strategy.InvestmentStrategyType;
import org.springframework.stereotype.Service;

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
        logService.clearLogs(); // Очищаем логи перед новой симуляцией
        logService.addLog("📢 Рыночное событие: " + event.getStockName() + " | " + event.getPriceChange() + "% | " + event.getEvent());

        List<Investor> investors = investorRepository.findAll();
        for (Investor investor : investors) {
            if (investor.getStrategyType() == InvestmentStrategyType.CONSERVATIVE) {
                handleConservativeInvestor(investor, event);
            } else {
                handleAggressiveInvestor(investor, event);
            }
        }

        handleTradingBot(event);
    }

    private void handleConservativeInvestor(Investor investor, StockEvent event) {
        if (event.getPriceChange() <= -5) {
            logService.addLog("🏦 " + investor.getName() + " (Консервативный) покупает " + event.getStockName() + " после падения " + event.getPriceChange() + "%");
        }
    }

    private void handleAggressiveInvestor(Investor investor, StockEvent event) {
        if (event.getPriceChange() < -3) {
            logService.addLog("🔥 " + investor.getName() + " (Агрессивный) покупает " + event.getStockName() + " после падения " + event.getPriceChange() + "%");
        } else if (event.getPriceChange() > 3) {
            logService.addLog("🚀 " + investor.getName() + " (Агрессивный) продаёт " + event.getStockName() + " после роста " + event.getPriceChange() + "%");
        }
    }

    private void handleTradingBot(StockEvent event) {
        if (event.getEvent().contains("скандал") || event.getEvent().contains("⚠️")) {
            logService.addLog("🤖 Бот продаёт все акции " + event.getStockName() + " из-за " + event.getEvent());
        } else if (event.getEvent().contains("прорыв") || event.getEvent().contains("🚀")) {
            logService.addLog("🤖 Бот покупает " + event.getStockName() + " после " + event.getEvent());
        }
    }
}
