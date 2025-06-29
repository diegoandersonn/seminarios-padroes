package com.example.demo.domain.paciente;

public record DadosListagemPacientes(String nome, String cpf, String email) {
    public DadosListagemPacientes(Paciente paciente) {
        this(paciente.getNome(), paciente.getCpf(), paciente.getEmail());
    }
}
