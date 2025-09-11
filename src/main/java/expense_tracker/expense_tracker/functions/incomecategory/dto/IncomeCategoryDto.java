package expense_tracker.expense_tracker.functions.incomecategory.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomeCategoryDto {


    @JsonProperty("name")
    private String name;

    @JsonProperty("categoryName")
    private String categoryName;

    @JsonProperty("incomeGuid")
    private String incomeGuid;

    @JsonProperty("isDeleted")
    private boolean isDeleted;

    private Long accountMasterId;
}
