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

import edu.unicesumar.escoladeti.domain.Curso;
import edu.unicesumar.escoladeti.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@GetMapping
	public ResponseEntity<Page<Curso>> buscarCursoPaginado(Pageable pageable) {
		return ResponseEntity.ok(cursoService.buscarCursoPaginado(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Curso> buscarCursoPorId(@PathVariable(name = "id") Long id){
		Optional<Curso> cursoOpt = cursoService.obterCursoPorId(id);
		
		if(cursoOpt.isPresent()) {
			return ResponseEntity.ok(cursoOpt.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCursoPorId(@PathVariable(name = "id") Long id){
		Optional<Curso> cursoOpt = cursoService.obterCursoPorId(id);
		
		if(cursoOpt.isPresent()) {
			cursoService.deletarCursoPorId(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Curso> salvarCurso(@RequestBody Curso curso) {
		return ResponseEntity.ok(cursoService.salvarCurso(curso));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Curso> atualizarCurso(@PathVariable(name = "id") Long id, @RequestBody Curso curso){
		return ResponseEntity.ok(cursoService.atualizarCurso(curso));
	}
	
}
