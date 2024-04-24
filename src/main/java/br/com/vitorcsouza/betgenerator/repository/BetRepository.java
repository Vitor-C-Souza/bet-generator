package br.com.vitorcsouza.betgenerator.repository;

import br.com.vitorcsouza.betgenerator.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long> {
}
