package br.com.vitorcsouza.betgenerator.dto;

import java.util.List;

public record Bet2Dto(
        List<Integer> numbers1,
        List<Integer> numbers2
) {
}
