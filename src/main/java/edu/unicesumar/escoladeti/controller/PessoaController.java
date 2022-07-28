package edu.unicesumar.escoladeti.controller;

import java.util.Optional;

import javax.annotation.PostConstruct;

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

import edu.unicesumar.escoladeti.domain.Pessoa;
import edu.unicesumar.escoladeti.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<Page<Pessoa>> buscarPessoaPaginado(Pageable pageable) {
		return ResponseEntity.ok(pessoaService.buscarPessoaPaginado(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable(name = "id") Long id){
		Optional<Pessoa> pessoaOpt = pessoaService.obterPessoaPorId(id);
		
		if(pessoaOpt.isPresent()) {
			return ResponseEntity.ok(pessoaOpt.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarPessoaPorId(@PathVariable(name = "id") Long id){
		Optional<Pessoa> pessoaOpt = pessoaService.obterPessoaPorId(id);
		
		if(pessoaOpt.isPresent()) {
			pessoaService.deletarPessoaPorId(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> salvarPessoa(@RequestBody Pessoa pessoa) {
		return ResponseEntity.ok(pessoaService.salvarPessoa(pessoa));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable(name = "id") Long id, @RequestBody Pessoa pessoa){
		return ResponseEntity.ok(pessoaService.atualizarPessoa(pessoa));
	}
	
}
