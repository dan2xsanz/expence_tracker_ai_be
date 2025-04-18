package expense_tracker.expense_tracker.functions.transaction.dto.totals;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionTotalResponseDto {

    @JsonProperty("totalIncome")
    private Long totalIncome;

    @JsonProperty("totalExpense")
    private Long totalExpense;
}
