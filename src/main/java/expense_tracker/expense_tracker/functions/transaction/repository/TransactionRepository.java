package expense_tracker.expense_tracker.functions.transaction.repository;

import expense_tracker.expense_tracker.model.TransactionMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionMaster, Long> {

    @Query(value = "SELECT * FROM TransactionMaster " +
            "WHERE trxGuid =:trxGuid ", nativeQuery = true)
    Optional<TransactionMaster> findTransactionByGuid(@Param("trxGuid") String trxGuid);


    @Query(value = "SELECT tm.* FROM TransactionMaster tm " +
            "LEFT JOIN AccountMaster am ON am.id = tm.accountMasterId " +
            "WHERE am.email =:email", nativeQuery = true)
    List<TransactionMaster> findAllTransactionByAccounts(@Param("email") String email);

}
