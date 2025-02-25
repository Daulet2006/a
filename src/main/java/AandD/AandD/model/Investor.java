package AandD.AandD.model;

import AandD.AandD.observer.Observer;
import AandD.AandD.strategy.InvestmentStrategy;
import AandD.AandD.strategy.InvestmentStrategyType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Investor implements Observer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private InvestmentStrategyType strategyType;

    @Transient // Поле не сохраняется в БД
    private InvestmentStrategy strategy;

    // ✅ Новый конструктор для создания инвесторов без id
    public Investor(String name, InvestmentStrategyType strategyType) {
        this.name = name;
        this.strategyType = strategyType;
    }

    @Override
    public void update(String stock, int priceChange, String event) {
        if (strategy != null) {
            strategy.execute(name, stock, priceChange, event);
        }
    }
}
