package br.com.acompanhamento.gateways;

import br.com.acompanhamento.domains.Aluno;

import java.util.List;

public interface AlunoGateway {
    List<Aluno> findAlunos();
}
