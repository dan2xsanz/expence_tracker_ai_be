package expense_tracker.expense_tracker.functions.account.repository;

import expense_tracker.expense_tracker.model.AccountMaster;
import expense_tracker.expense_tracker.model.TransactionMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMasterRepository extends JpaRepository<AccountMaster, Long> {

    @Query(value = "SELECT * FROM AccountMaster " +
            "WHERE id =:accountMasterId ", nativeQuery = true)
    AccountMaster findAccountById(@Param("accountMasterId") Long accountMasterId);
}
