package br.com.acompanhamento.gateways.http;

import br.com.acompanhamento.domains.Aluno;
import br.com.acompanhamento.gateways.AlunoGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by miche on 19/02/2017.
 */
@Controller
@RequestMapping("/api/v1/alunos")
public class AcompanhamentoController {

    private AlunoGateway alunoGateway;

    @Autowired
    public AcompanhamentoController(AlunoGateway alunoGateway) {
        this.alunoGateway = alunoGateway;
    }

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        return "<h1>Olá. Bem-vindo ao sistema Acompanhamento Escolar</h1>";
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Aluno> buscarAlunos() {

        List<Aluno> alunos = alunoGateway.findAlunos();
        return alunos;
    }

}
