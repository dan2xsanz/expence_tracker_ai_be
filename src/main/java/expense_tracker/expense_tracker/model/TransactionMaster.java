package expense_tracker.expense_tracker.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TransactionMaster")
public class TransactionMaster extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private LocalDateTime time;

    @JsonProperty("paymentType")
    private Integer paymentType;

    @JsonProperty("isArchiveTransaction")
    private boolean isArchiveTransaction;

    @ManyToOne
    @JoinColumn(name = "accountMasterId", nullable = false)
    @JsonBackReference
    private AccountMaster accountMaster;


}
