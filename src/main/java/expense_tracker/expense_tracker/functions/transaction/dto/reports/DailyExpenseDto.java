package expense_tracker.expense_tracker.functions.transaction.dto.reports;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class DailyExpenseDto {

    private Integer categoryId;

    private Long amountValue;
}
