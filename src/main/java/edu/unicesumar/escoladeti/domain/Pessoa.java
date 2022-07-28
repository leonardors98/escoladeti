package edu.unicesumar.escoladeti.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;


@Data
@Entity
public class Pessoa {

	@Id
	@GeneratedValue(generator="my_seq")
	@SequenceGenerator(name="my_seq",sequenceName="seq_pessoa_id", allocationSize=1)
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
}
