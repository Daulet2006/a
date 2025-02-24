package AandD.AandD.repository;


import AandD.AandD.model.Investor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestorRepository extends JpaRepository<Investor, Long> {
}

