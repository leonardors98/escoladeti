package edu.unicesumar.escoladeti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unicesumar.escoladeti.domain.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
    
}
