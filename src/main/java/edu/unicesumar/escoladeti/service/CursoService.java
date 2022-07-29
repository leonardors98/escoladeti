package edu.unicesumar.escoladeti.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.unicesumar.escoladeti.domain.Curso;
import edu.unicesumar.escoladeti.repository.CursoRepository;

@Service
public class CursoService {
    @Autowired
	private CursoRepository cursoRepository;
	
	public Page<Curso> buscarCursoPaginado(Pageable pageable) {
		return cursoRepository.findAll(pageable);
	}
	
	public Optional<Curso> obterCursoPorId(Long id) {
		return cursoRepository.findById(id);
	}
	
	public Curso salvarCurso(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public Curso atualizarCurso(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public void deletarCursoPorId(Long id) {
		cursoRepository.deleteById(id);
	}
	
}
