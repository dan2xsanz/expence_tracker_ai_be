package expense_tracker.expense_tracker.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "IncomeCategory")
public class IncomeCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("isDeleted")
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "accountMasterId", nullable = false)
    @JsonBackReference
    private AccountMaster accountMaster;

}
