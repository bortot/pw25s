package br.edu.utfpr.pb.pw25s.server.model;

import br.edu.utfpr.pb.pw25s.server.enums.TransactionStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_expense")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 256)
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_status", nullable = false)
    private TransactionStatusEnum transactionStatus;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "expense_type", nullable = false)
    private ExpenseTypeEnum transactionType;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    @Getter @Setter
    private Account account;

    @ManyToOne
    @JoinColumn(name = "account_transfer_id", referencedColumnName = "id")
    @Getter @Setter
    private Account accountTransfer;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
