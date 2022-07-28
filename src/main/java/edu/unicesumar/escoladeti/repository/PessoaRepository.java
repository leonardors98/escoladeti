package edu.unicesumar.escoladeti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unicesumar.escoladeti.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
