package edu.unicesumar.escoladeti.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;


@Data
@Entity
public class Disciplina {

    @Id
	@GeneratedValue(generator="my_seq")
	@SequenceGenerator(name="my_seq",sequenceName="seq_disciplina_id", allocationSize=1)
	private Long id;
	
	private String nome;
	
	@Column(name = "carga_horaria")
	private Long cargaHoraria;

	private String tipo;

	private String modelo;


}
