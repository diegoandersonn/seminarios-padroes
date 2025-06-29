package com.example.demo.domain.medico;

import com.example.demo.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(@NotNull Long id, String telefone, String nome, DadosEndereco endereco) {}
