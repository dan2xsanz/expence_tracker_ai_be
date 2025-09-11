package expense_tracker.expense_tracker.functions.expensecategory.service;

import expense_tracker.expense_tracker.functions.expensecategory.dto.ExpenseCategoryDto;
import expense_tracker.expense_tracker.model.AccountMaster;

import java.util.List;

public interface ExpenseCategoryService {

    void uploadExpenseCategory(ExpenseCategoryDto expenseCategoryDto, AccountMaster accountMaster);

    List<ExpenseCategoryDto> downloadExpenseCategory(AccountMaster accountMaster);
}
