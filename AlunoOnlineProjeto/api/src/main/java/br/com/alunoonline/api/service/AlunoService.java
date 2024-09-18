package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public void criarAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodosAlunos() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    public void deletarAlunoPorId(Long id) {
        alunoRepository.deleteById(id);
    }

    public Aluno atualizarAlunoPorId(Long id, Aluno aluno) {
        // Busca o aluno pelo ID e trata o Optional
        Optional<Aluno> alunoDoBancoDeDados = buscarAlunoPorId(id);

        if (alunoDoBancoDeDados.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado");
        }

        Aluno alunoEditado = alunoDoBancoDeDados.get();
        alunoEditado.setNome(aluno.getNome());
        alunoEditado.setCpf(aluno.getCpf());
        alunoEditado.setEmail(aluno.getEmail());

        alunoRepository.save(alunoEditado);

        return alunoEditado; // Retorna o aluno atualizado
    }
}

