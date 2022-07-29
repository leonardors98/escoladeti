package edu.unicesumar.escoladeti.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unicesumar.escoladeti.domain.Disciplina;
import edu.unicesumar.escoladeti.service.DisciplinaService;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;
	
	@GetMapping
	public ResponseEntity<Page<Disciplina>> buscarDisciplinaPaginado(Pageable pageable) {
		return ResponseEntity.ok(disciplinaService.buscarDisciplinaPaginado(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Disciplina> buscarDisciplinaPorId(@PathVariable(name = "id") Long id){
		Optional<Disciplina> disciplinaOpt = disciplinaService.obterDisciplinaPorId(id);
		
		if(disciplinaOpt.isPresent()) {
			return ResponseEntity.ok(disciplinaOpt.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarDisciplinaPorId(@PathVariable(name = "id") Long id){
		Optional<Disciplina> disciplinaOpt = disciplinaService.obterDisciplinaPorId(id);
		
		if(disciplinaOpt.isPresent()) {
			disciplinaService.deletarDisciplinaPorId(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Disciplina> salvarDisciplina(@RequestBody Disciplina disciplina) {
		return ResponseEntity.ok(disciplinaService.salvarDisciplina(disciplina));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Disciplina> atualizarDisciplina(@PathVariable(name = "id") Long id, @RequestBody Disciplina disciplina){
		return ResponseEntity.ok(disciplinaService.atualizarDisciplina(disciplina));
	}
	
}
