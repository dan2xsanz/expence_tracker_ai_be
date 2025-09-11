package expense_tracker.expense_tracker.functions.incomecategory.repository;

import expense_tracker.expense_tracker.model.IncomeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IncomeCategoryRepository extends JpaRepository<IncomeCategory, Long> {

    @Query(value = "SELECT * FROM IncomeCategory " +
            "WHERE incomeGuid =:incomeGuid ", nativeQuery = true)
    Optional<IncomeCategory> findIncomeCategoryByGuid(@Param("incomeGuid") String incomeGuid);


    @Query(value = "SELECT inc.* FROM IncomeCategory inc " +
            "LEFT JOIN AccountMaster am ON am.id = inc.accountMasterId " +
            "WHERE am.email =:email", nativeQuery = true)
    List<IncomeCategory> findAllIncomeCategoryByAccounts(@Param("email") String email);

}
