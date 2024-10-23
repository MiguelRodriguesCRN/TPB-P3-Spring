package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Matricula;
import br.com.alunoonline.api.service.MatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matriculas_alunos")
public class MatriculaAlunoController {

    @Autowired
    MatriculaAlunoService matriculaAlunoService;

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarMatricula(@ResponseStatus Matricula matriculaAluno) {
        matriculaAlunoService.criarMatricula(Matricula);
    }
}
