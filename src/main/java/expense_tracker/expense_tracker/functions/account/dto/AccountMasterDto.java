package expense_tracker.expense_tracker.functions.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountMasterDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String currency;

    private String pin;

    private String transmitN;

    private LocalDateTime lastTransmit;

}