package AandD.AandD.strategy;


public class AggressiveStrategy implements InvestmentStrategy {
    @Override
    public void execute(String investorName, String stock, int priceChange, String event) {
        if (priceChange > 0) {
            System.out.println("🔥 " + investorName + " (Агрессивный) ПОКУПАЕТ " + stock + " (+ " + priceChange + "%)");
        } else {
            System.out.println("⚠️ " + investorName + " (Агрессивный) ПРОДАЁТ " + stock + " (-" + priceChange + "%)");
        }
    }
}
