package expense_tracker.expense_tracker.functions.expensecategory.repository;

import expense_tracker.expense_tracker.model.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory, Long> {

    @Query(value = "SELECT * FROM ExpenseCategory " +
            "WHERE expenseGuid =:expenseGuid ", nativeQuery = true)
    Optional<ExpenseCategory> findExpenseCategoryByGuid(@Param("expenseGuid") String expenseGuid);


    @Query(value = "SELECT ex.* FROM ExpenseCategory ex " +
            "LEFT JOIN AccountMaster am ON am.id = ex.accountMasterId " +
            "WHERE am.email =:email", nativeQuery = true)
    List<ExpenseCategory> findAllExpenseCategoryByAccounts(@Param("email") String email);

}
