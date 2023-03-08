package by.bsuir.bankSystem.repo;

import by.bsuir.bankSystem.entity.domain.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankCardRepo extends JpaRepository<BankCard, Integer> {
    Optional<BankCard> findByNumber(String number);
}
