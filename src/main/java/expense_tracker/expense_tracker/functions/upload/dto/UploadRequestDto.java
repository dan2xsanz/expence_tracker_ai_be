package expense_tracker.expense_tracker.functions.upload.dto;

import expense_tracker.expense_tracker.functions.account.dto.AccountMasterDto;
import expense_tracker.expense_tracker.functions.expensecategory.dto.ExpenseCategoryDto;
import expense_tracker.expense_tracker.functions.incomecategory.dto.IncomeCategoryDto;
import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
import expense_tracker.expense_tracker.model.SystemSetting;
import lombok.*;

import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UploadRequestDto {

    private AccountMasterDto accountMaster;

    private Set<TransactionDto> transactionMaster;

    private SystemSetting systemSetting;

    private Set<ExpenseCategoryDto> expenseCategories;

    private Set<IncomeCategoryDto> incomeCategories;
}
