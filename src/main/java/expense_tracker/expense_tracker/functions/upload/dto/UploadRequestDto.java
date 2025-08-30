package expense_tracker.expense_tracker.functions.upload.dto;

import expense_tracker.expense_tracker.functions.account.dto.AccountMasterDto;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UploadRequestDto {

    private AccountMasterDto accountMaster;
}
