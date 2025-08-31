package expense_tracker.expense_tracker.functions.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TransactionDto {

    private Long id;

    @JsonProperty("transactionType")
    private String transactionType;

    @JsonProperty("amountValue")
    private BigDecimal amountValue;

    @JsonProperty("categoryType")
    private Integer categoryType;

    @JsonProperty("note")
    private String note;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("time")
    private LocalTime time;

    @JsonProperty("paymentType")
    private Integer paymentType;

    private Long accountMasterId;

    @JsonProperty("isArchiveTransaction")
    private boolean isArchiveTransaction;

    @JsonProperty("isRecurringTransaction")
    private boolean isRecurringTransaction;

    @JsonProperty("frequency")
    private String frequency;

    @JsonProperty("recurringFrom")
    private LocalDate recurringFrom;

    @JsonProperty("recurringTo")
    private LocalDate recurringTo;

    @JsonProperty("isNoRecurringEnd")
    private boolean isNoRecurringEnd;

    @JsonProperty("isDeleted")
    private boolean isDeleted;

    @JsonProperty("trn")
    private String trn;

    @JsonProperty("trxGuid")
    private String trxGuid;


}
