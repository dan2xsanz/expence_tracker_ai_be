package expense_tracker.expense_tracker.functions.incomecategory.service;

import expense_tracker.expense_tracker.functions.incomecategory.dto.IncomeCategoryDto;
import expense_tracker.expense_tracker.model.AccountMaster;

import java.util.List;

public interface IncomeCategoryService {

    void uploadIncomeCategory(IncomeCategoryDto incomeCategoryDto, AccountMaster accountMaster);

    List<IncomeCategoryDto> downloadIncomeCategory(AccountMaster accountMaster);
}
