package expense_tracker.expense_tracker.functions.transaction.repository;

import expense_tracker.expense_tracker.model.TransactionMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionMaster, Long> {

    @Query(value = "SELECT * FROM TransactionMaster", nativeQuery = true)
    List<TransactionMaster> allTransactions();

}
