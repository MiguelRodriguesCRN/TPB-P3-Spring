package br.com.alunoonline.api.service;


import br.com.alunoonline.api.model.Matricula;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaAlunoService {

    @Autowired
    MatriculaAlunoRepository matriculaAlunoRepository;

    public void criarMatricula(Matricula matriculaAluno) {
        matriculaAlunoRepository.save(matriculaAluno);
    }

}
