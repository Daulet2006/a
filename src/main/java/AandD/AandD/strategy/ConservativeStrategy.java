package AandD.AandD.strategy;

public class ConservativeStrategy implements InvestmentStrategy {
    @Override
    public void execute(String investorName, String stock, int priceChange, String event) {
        if (priceChange > 3) {
            System.out.println("🟢 " + investorName + " (Консервативный) ПОКУПАЕТ " + stock + " (+ " + priceChange + "%)");
        } else {
            System.out.println("🟡 " + investorName + " (Консервативный) ОЖИДАЕТ изменений.");
        }
    }
}
