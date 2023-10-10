package br.edu.utfpr.pb.pw25s.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "PaymentStatusHistory")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class PaymentStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "pending_date", nullable = false)
    private LocalDate pendingDate;

    @Column(name = "paid_received_date", nullable = false)
    private LocalDate paidReceivedDate;

    @NotNull
    @OneToOne
    @JoinColumn(name = "expense_id", referencedColumnName = "id", nullable = false)
    @Getter @Setter
    private Expense expense;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

