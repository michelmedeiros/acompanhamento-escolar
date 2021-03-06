package br.com.acompanhamento.gateways;

import br.com.acompanhamento.domains.Aluno;

import java.util.List;

public interface AlunoGateway {
    List<Aluno> findAll();
    Aluno save(Aluno aluno);
    Aluno findById(String id);
    void delete(String id);
    Aluno update(Aluno aluno);
}
