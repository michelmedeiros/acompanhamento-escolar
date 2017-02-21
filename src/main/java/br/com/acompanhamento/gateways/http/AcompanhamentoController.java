package br.com.acompanhamento.gateways.http;

import java.util.List;

import javax.validation.Valid;

import br.com.acompanhamento.gateways.AlunoGateway;
import br.com.acompanhamento.usecases.ManterAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import br.com.acompanhamento.domains.Aluno;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/api/v1/alunos")
public class AcompanhamentoController {

    private final ManterAluno manterAluno;

    private final AlunoGateway alunoGateway;

    @Autowired
    public AcompanhamentoController(ManterAluno alunoGateway, AlunoGateway alunoGateway1) {
        this.manterAluno = alunoGateway;
        this.alunoGateway = alunoGateway1;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Aluno> buscarAlunos() {
        log.info("Busca de alunos");
        return alunoGateway.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Aluno buscarAluno(@PathVariable final String id) {
        log.info("Busca de alunos");
        return alunoGateway.findById(id);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void excluirAluno(@PathVariable final String id) {
        log.info("Exclusão de aluno");
        alunoGateway.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Aluno inserirAluno(@RequestBody @Valid final Aluno aluno) {
        log.info("Cadastro de aluno: {} ", aluno.getNome());
        return manterAluno.execute(aluno);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Aluno atualizarAluno(@RequestBody @Valid final Aluno aluno) {
        log.info("Cadastro de aluno: {} ", aluno.getNome());
        return manterAluno.execute(aluno);
    }

}
