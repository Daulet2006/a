package AandD.AandD.strategy;



public interface InvestmentStrategy {
    void execute(String investorName, String stock, int priceChange, String event);
}

