package br.com.vitorcsouza.betgenerator.controller;

import br.com.vitorcsouza.betgenerator.dto.BetDto;
import br.com.vitorcsouza.betgenerator.dto.Bet2Dto;
import br.com.vitorcsouza.betgenerator.service.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bet")
public class BetController {

    @Autowired
    BetService service;

    @GetMapping("/megasena")
    public ResponseEntity<BetDto> MegaSena(){
        BetDto dto = service.megasena();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/+milionaria")
    public ResponseEntity<Bet2Dto> milionaria(){
        Bet2Dto dto = service.milionaria();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/lotofacil/{randomNumbers}")
    public ResponseEntity<BetDto> lotofacil(@PathVariable Integer randomNumbers){
        BetDto dto = service.lotofacil(randomNumbers);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/quina/{randomNumbers}")
    public ResponseEntity<BetDto> quina(@PathVariable Integer randomNumbers){
        BetDto dto = service.quina(randomNumbers);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/lotomania")
    public ResponseEntity<BetDto> lotomania(){
        BetDto dto = service.lotomania();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/duplasena/{randomNumbers}")
    public ResponseEntity<BetDto> duplasena(@PathVariable Integer randomNumbers){
        BetDto dto = service.duplasena(randomNumbers);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/diadesorte/{randomNumbers}")
    public ResponseEntity<Bet2Dto> DiaDeSorte(@PathVariable Integer randomNumbers){
        Bet2Dto dto = service.diadesorte(randomNumbers);
        return ResponseEntity.ok(dto);
    }
}
