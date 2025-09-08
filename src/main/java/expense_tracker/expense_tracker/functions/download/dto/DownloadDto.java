package expense_tracker.expense_tracker.functions.download.dto;

import expense_tracker.expense_tracker.functions.account.dto.AccountMasterDto;
import expense_tracker.expense_tracker.functions.transaction.dto.TransactionDto;
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
}
