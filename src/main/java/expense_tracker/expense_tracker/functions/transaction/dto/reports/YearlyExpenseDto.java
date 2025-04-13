package expense_tracker.expense_tracker.functions.transaction.dto.reports;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class YearlyExpenseDto {

    private String transactionMonth;

    private Long transactionIn;

    private Long transactionOut;
}
