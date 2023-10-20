package br.edu.utfpr.pb.pw25s.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "tb_account")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @Column(name = "account_number")
    private Integer accountNumber;

    @Column(name = "account_agency")
    private Integer acconuntAgency;

    @ManyToOne
    @JoinColumn(name = "account_type_id", referencedColumnName = "id")
    @Getter @Setter
    private AccountType accountType;

    @ManyToOne
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    @Getter @Setter
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    @Getter @Setter
    private User user;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
