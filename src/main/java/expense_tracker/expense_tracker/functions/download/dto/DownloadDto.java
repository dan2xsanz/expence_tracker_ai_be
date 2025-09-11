package expense_tracker.expense_tracker.functions.download.dto;

import expense_tracker.expense_tracker.functions.account.dto.AccountMasterDto;
import expense_tracker.expense_tracker.functions.expensecategory.dto.ExpenseCategoryDto;
import expense_tracker.expense_tracker.functions.incomecategory.dto.IncomeCategoryDto;
import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.model.SystemSetting;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DownloadDto {

    private AccountMasterDto accountMaster;

    private List<TransactionDto> transactionMaster;

    private SystemSetting systemSetting;

    private List<ExpenseCategoryDto> expenseCategories;

    private List<IncomeCategoryDto> incomeCategories;
}
