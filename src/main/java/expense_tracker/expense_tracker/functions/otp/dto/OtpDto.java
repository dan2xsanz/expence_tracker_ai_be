package expense_tracker.expense_tracker.functions.otp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OtpDto {

    private Long id;

    private String otp;

    private String username;

    private LocalDateTime expiryDateTime;
}
