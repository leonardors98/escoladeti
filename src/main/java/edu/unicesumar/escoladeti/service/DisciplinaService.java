package edu.unicesumar.escoladeti.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.unicesumar.escoladeti.domain.Disciplina;
import edu.unicesumar.escoladeti.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;
    
    public Page<Disciplina> buscarDisciplinaPaginado(Pageable pageable){
        return disciplinaRepository.findAll(pageable);
    }

    public Optional<Disciplina> obterDisciplinaPorId(Long id){
        return disciplinaRepository.findById(id);
    }

    public Disciplina salvarDisciplina(Disciplina disciplina){
        return disciplinaRepository.save(disciplina);
    }
	
    public Disciplina atualizarDisciplina(Disciplina disciplina){
        return disciplinaRepository.save(disciplina);
    }
	
	public void deletarDisciplinaPorId(Long id) {
		disciplinaRepository.deleteById(id);
	}
}
