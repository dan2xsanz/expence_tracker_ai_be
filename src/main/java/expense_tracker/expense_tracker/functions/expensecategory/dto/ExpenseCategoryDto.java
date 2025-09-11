package expense_tracker.expense_tracker.functions.expensecategory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseCategoryDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("expenceName")
    private String expenceName;

    @JsonProperty("expenseGuid")
    private String expenseGuid;

    @JsonProperty("isDeleted")
    private boolean isDeleted;

    private Long accountMasterId;
}