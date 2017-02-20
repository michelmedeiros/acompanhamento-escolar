package br.com.acompanhamento.gateways.mongo;

import br.com.acompanhamento.domains.Aluno;
import br.com.acompanhamento.gateways.AlunoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Michel on 19/02/2017.
 */
@Component
public class AlunoGatewayImpl implements AlunoGateway {


    private final AlunoRepository repository;

    @Autowired
    public AlunoGatewayImpl(AlunoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Aluno> findAlunos() {
        return repository.findAll();
    }
}
