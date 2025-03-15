package expense_tracker.expense_tracker.functions.transaction.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionGetAllDto {

    private Long accountMasterId;

    @JsonProperty("note")
    private String note;

    @JsonProperty("transactionType")
    private String transactionType;

}
