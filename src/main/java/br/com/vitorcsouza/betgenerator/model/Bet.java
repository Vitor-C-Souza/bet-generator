package br.com.vitorcsouza.betgenerator.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "bet_tb")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Jogo jogo;

    @NotNull
    private String bet;

    public Bet(Jogo jogo, String bet) {
        this.jogo = jogo;
        this.bet = bet;
    }
}
