package br.com.acompanhamento.usecases;

import br.com.acompanhamento.domains.Aluno;
import br.com.acompanhamento.gateways.AlunoGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by miche on 20/02/2017.
 */
@Component
@Slf4j
public class ManterAluno {

    private final AlunoGateway alunoGateway;

    @Autowired
    public ManterAluno(AlunoGateway alunoGateway) {
        this.alunoGateway = alunoGateway;
    }

    public Aluno execute(Aluno aluno) {
        if(Optional.ofNullable(aluno.getId()).isPresent()) {
            log.info("Aluno {} atualizado com sucesso", aluno.getNome());
        }else {
            log.info("Aluno {} salvo com sucesso", aluno.getNome());
        }
        return alunoGateway.save(aluno);
    }
}
