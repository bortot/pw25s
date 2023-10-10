package br.edu.utfpr.pb.pw25s.server.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "Bank")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
