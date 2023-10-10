package br.edu.utfpr.pb.pw25s.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "AccountType")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class AccountType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(length = 50, nullable = false)
    private String name;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
