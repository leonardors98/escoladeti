package edu.unicesumar.escoladeti.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.unicesumar.escoladeti.domain.Curso;


public interface CursoRepository extends JpaRepository<Curso, Long> {
    
}

