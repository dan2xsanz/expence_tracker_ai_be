package expense_tracker.expense_tracker.functions.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountMasterDto {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

}
