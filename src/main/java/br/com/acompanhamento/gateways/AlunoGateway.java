package br.com.acompanhamento.gateways;

import br.com.acompanhamento.domains.Aluno;

import java.util.List;

/**
 * Created by miche on 19/02/2017.
 */
public interface AlunoGateway {
    List<Aluno> findAlunos();
}
