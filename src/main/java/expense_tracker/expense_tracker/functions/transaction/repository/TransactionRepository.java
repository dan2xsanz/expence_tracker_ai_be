package expense_tracker.expense_tracker.functions.transaction.repository;

import expense_tracker.expense_tracker.model.TransactionMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionMaster, Long> {
}
