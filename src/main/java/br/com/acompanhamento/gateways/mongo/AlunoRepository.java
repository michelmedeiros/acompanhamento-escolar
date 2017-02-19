package br.com.acompanhamento.gateways.mongo;

import br.com.acompanhamento.domains.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by miche on 19/02/2017.
 */

public interface AlunoRepository extends MongoRepository<Aluno, String> {
}
