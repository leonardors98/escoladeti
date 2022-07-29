package edu.unicesumar.escoladeti.domain;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;


@Data
@Entity
public class Curso {
    @Id
	@GeneratedValue(generator="my_seq")
	@SequenceGenerator(name="my_seq",sequenceName="seq_curso_id", allocationSize=1)
	private Long id;
	
	private String nome;
	
	@Column(name = "carga_horaria_maxima")
	private Long cargaHorariaMaxima;

	@Column(name = "carga_horaria_minima")
	private Long cargaHorariaMinima;

	@Column(name = "data_provacao_curso")
    private LocalDate dataAprovacaoCurso;

}
