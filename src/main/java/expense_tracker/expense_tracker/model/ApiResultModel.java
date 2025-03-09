package expense_tracker.expense_tracker.model;


import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class ApiResultModel {

    private Boolean isSuccess;

    private String message;

    private Object messageParams;

    private Object resultData;

    private List<String> errorMessages;

    private Object errorCodes;

    private String exceptionType;

}
