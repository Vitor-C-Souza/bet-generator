package br.com.vitorcsouza.betgenerator.service;

import br.com.vitorcsouza.betgenerator.dto.BetDto;
import br.com.vitorcsouza.betgenerator.dto.Bet2Dto;
import br.com.vitorcsouza.betgenerator.model.Bet;
import br.com.vitorcsouza.betgenerator.model.Jogo;
import br.com.vitorcsouza.betgenerator.repository.BetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class BetService {

    @Autowired
    BetRepository repository;

    private List<Integer> generatorNumbers(Integer randomNumbers, Integer howMuch) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= randomNumbers; i++) {
            int randomNumber = random.nextInt(howMuch);
            if(randomNumber == 0 || list.contains(randomNumber)){
                i--;
            } else{
                list.add(randomNumber);
            }
        }
        return list.stream().sorted().toList();
    }

    private String betString(List<Integer> numbers) {
        return numbers.stream().map(Objects::toString).collect(Collectors.joining(", "));
    }

    public BetDto megasena() {
        BetDto dto = new BetDto(generatorNumbers(6, 61));
        Bet bet = new Bet(
                Jogo.MEGASENA,
                betString(dto.numbers())
        );

        repository.save(bet);

        return dto;
    }



    public Bet2Dto milionaria() {
        Bet2Dto dto = new Bet2Dto(
                generatorNumbers(6, 51), generatorNumbers(2, 7)
        );
        Bet bet = new Bet(
                Jogo.MILIONARIA,
                "Matriz de Números: " + betString(dto.numbers1()) + ", Matriz de Trevos Numerados: " + betString(dto.numbers2())
        );

        repository.save(bet);
        return dto;
    }

    public BetDto lotofacil(Integer randomNumbers) {
        BetDto dto = new BetDto(generatorNumbers(randomNumbers, 26));
        Bet bet = new Bet(
                Jogo.LOTOFACIL,
                betString(dto.numbers())
        );

        repository.save(bet);
        return dto;
    }


    public BetDto quina(Integer randomNumbers) {
        BetDto dto = new BetDto(generatorNumbers(randomNumbers, 81));

        Bet bet = new Bet(
                Jogo.QUINA,
                betString(dto.numbers())
        );
        repository.save(bet);

        return dto;
    }

    public BetDto lotomania() {
        BetDto dto = new BetDto(generatorNumbers(50, 100));
        Bet bet = new Bet(
                Jogo.LOTOMANIA,
                betString(dto.numbers())
        );
        repository.save(bet);

        return dto;
    }

    public BetDto duplasena(Integer randomNumbers) {
        BetDto dto = new BetDto(generatorNumbers(randomNumbers, 51));
        Bet bet = new Bet(
                Jogo.DUPLASENA,
                betString(dto.numbers())
        );
        repository.save(bet);

        return dto;
    }

    public Bet2Dto diadesorte(Integer randomNumbers) {
        Bet2Dto dto = new Bet2Dto(
                generatorNumbers(randomNumbers, 32),
                generatorNumbers(1,13)
        );

        Bet bet = new Bet(
                Jogo.DIADESORTE,
                "Números: " + betString(dto.numbers1()) + ", Mês de Sorte: " + betString(dto.numbers2())
        );

        repository.save(bet);

        return dto;
    }
}
