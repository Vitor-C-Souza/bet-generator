package br.com.vitorcsouza.betgenerator.service;

import br.com.vitorcsouza.betgenerator.dto.BetDto;
import br.com.vitorcsouza.betgenerator.dto.Bet2Dto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BetService {

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

    public BetDto megasena() {
        return new BetDto(generatorNumbers(6, 61));
    }


    public Bet2Dto milionaria() {
        return new Bet2Dto(
          generatorNumbers(6, 51), generatorNumbers(2, 7)
        );
    }

    public BetDto lotofacil(Integer randomNumbers) {
        return new BetDto(generatorNumbers(randomNumbers, 26));
    }


    public BetDto quina(Integer randomNumbers) {
        return new BetDto(generatorNumbers(randomNumbers, 81));
    }

    public BetDto lotomania() {
        return new BetDto(generatorNumbers(50, 100));
    }

    public BetDto duplasena(Integer randomNumbers) {
        return new BetDto(generatorNumbers(randomNumbers, 51));
    }

    public Bet2Dto diadesorte(Integer randomNumbers) {
        return new Bet2Dto(
                generatorNumbers(randomNumbers, 32),
                generatorNumbers(1,13)
        );
    }
}
