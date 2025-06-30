package com.example.demo.domain.consulta;

import java.time.LocalDateTime;


public record DadosLembreteConsulta(String nomePaciente, String emailPaciente, LocalDateTime dataHoraConsulta) {
    public DadosLembreteConsulta(Consulta consulta) {
        this(consulta.getPaciente().getNome(), consulta.getPaciente().getEmail(), consulta.getData());
    }
}