package expense_tracker.expense_tracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AccountMaster")
public class AccountMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    @Column(unique = true, nullable = false)  // makes email unique and not null
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("pin")
    private String pin;

    @JsonProperty("transmitN")
    private String transmitN;

    @JsonProperty("lastTransmit")
    private LocalDateTime lastTransmit;

}
