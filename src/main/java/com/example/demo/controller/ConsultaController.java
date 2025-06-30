package com.example.demo.controller;

import com.example.demo.domain.consulta.*;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agenda;

    @Autowired
    private ConsultaRepository consultaRepository;

    @GetMapping("/lembretes")
    public ResponseEntity<List<DadosLembreteConsulta>> listarConsultasParaLembrete() {
        LocalDateTime amanha = LocalDateTime.now().plusDays(1).withHour(0).withMinute(0);
        LocalDateTime fimAmanha = amanha.plusDays(1);

        var consultas = consultaRepository.findAllByDataBetweenAndMotivoCancelamentoIsNull(amanha, fimAmanha);
        var resultado = consultas.stream().map(DadosLembreteConsulta::new).toList();

        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
        var dto = agenda.agendar(dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {
        System.out.println(dados);
        agenda.cancelar(dados);
        return ResponseEntity.noContent().build();
    }

}
