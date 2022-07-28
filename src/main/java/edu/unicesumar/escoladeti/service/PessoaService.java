package edu.unicesumar.escoladeti.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.unicesumar.escoladeti.domain.Pessoa;
import edu.unicesumar.escoladeti.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Page<Pessoa> buscarPessoaPaginado(Pageable pageable) {
		return pessoaRepository.findAll(pageable);
	}
	
	public Optional<Pessoa> obterPessoaPorId(Long id) {
		return pessoaRepository.findById(id);
	}
	
	public Pessoa salvarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa atualizarPessoa(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	public void deletarPessoaPorId(Long id) {
		pessoaRepository.deleteById(id);
	}
	
}
