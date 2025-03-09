package expense_tracker.expense_tracker.functions.transaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TransactionDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("transactionType")
    private String transactionType;

    @JsonProperty("amountValue")
    private BigDecimal amountValue;

    @JsonProperty("amount")
    private Integer categoryType;

    @JsonProperty("note")
    private String note;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("time")
    private LocalDateTime time;

    @JsonProperty("paymentType")
    private Integer paymentType;

}
