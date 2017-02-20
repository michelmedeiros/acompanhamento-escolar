package br.com.acompanhamento.gateways.http;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.acompanhamento.domains.Aluno;
import br.com.acompanhamento.gateways.AlunoGateway;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/api/v1/alunos")
public class AcompanhamentoController {

    private final AlunoGateway alunoGateway;

    @Autowired
    public AcompanhamentoController(AlunoGateway alunoGateway) {
        this.alunoGateway = alunoGateway;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Aluno> buscarAlunos() {
        log.info("Busca de alunos");
        return alunoGateway.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Aluno inserirAlunos(@RequestBody @Valid Aluno aluno) {
        log.info("Cadastro de aluno: {} ", aluno.getNome());
        return alunoGateway.save(aluno);
    }

}
