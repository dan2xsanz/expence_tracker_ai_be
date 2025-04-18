package expense_tracker.expense_tracker.functions.transaction.dto.reports;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MonthlyExpenseDto {

    private Integer expenseId;

    private String expenseName;

    private Long totalExpense;
}
