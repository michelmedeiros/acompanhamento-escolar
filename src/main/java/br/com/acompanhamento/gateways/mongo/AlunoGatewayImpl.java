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
    public List<Aluno> findAll() {
        return repository.findAll();
    }

    @Override
    public Aluno save(Aluno aluno) {
        return repository.save(aluno);
    }

    @Override
    public Aluno findById(String id) {
        return repository.findOne(id);
    }

    @Override
    public void delete(String id) {
        repository.delete(id);
    }

    @Override
    public Aluno update(Aluno aluno) {
        return repository.save(aluno);
    }
}
