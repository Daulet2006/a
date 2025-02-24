package AandD.AandD.repository;


import AandD.AandD.model.StockEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockEventRepository extends JpaRepository<StockEvent, Long> {
}

