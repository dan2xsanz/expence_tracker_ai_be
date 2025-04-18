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
public class TransactionTotalRequestDto {

    private Long accountMasterId;

    @JsonProperty("filterType")
    private String filterType;

}
