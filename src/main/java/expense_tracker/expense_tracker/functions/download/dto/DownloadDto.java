package expense_tracker.expense_tracker.functions.download.dto;

import expense_tracker.expense_tracker.functions.account.dto.AccountMasterDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DownloadDto {

    private AccountMasterDto accountMaster;
}
