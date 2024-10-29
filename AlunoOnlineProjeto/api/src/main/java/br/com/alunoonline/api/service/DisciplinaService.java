package br.com.alunoonline.api.service;

import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    // Criar disciplina
    public void criarDisciplina(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
    }

    // Listar todas as disciplinas
    public List<Disciplina> listarTodasDisciplinas() {
        return disciplinaRepository.findAll();
    }

    // Buscar disciplina por ID
    public Optional<Disciplina> buscarDisciplinaPorId(Long id) {
        return disciplinaRepository.findById(id);
    }

    // Deletar disciplina por ID
    public void deletarDisciplinaPorId(Long id) {
        disciplinaRepository.deleteById(id);
    }

    // Atualizar disciplina por ID
    public void atualizarDisciplinaPorId(Long id, Disciplina disciplinaDetalhes) {
        Optional<Disciplina> disciplinaExistente = disciplinaRepository.findById(id);

        if (disciplinaExistente.isPresent()) {
            Disciplina disciplina = disciplinaExistente.get();
            disciplina.setNome(disciplinaDetalhes.getNome());
            disciplinaRepository.save(disciplina);
        } else {
            throw new RuntimeException("Disciplina com ID " + id + " não encontrada.");
        }
    }
}
