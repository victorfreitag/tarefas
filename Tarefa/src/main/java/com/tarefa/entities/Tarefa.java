package com.tarefa.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "Tarefa")
public class Tarefa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@NotBlank
	@NotNull
	private String nome;
	
	@NotBlank
	@NotNull
	private String dataFinalExecucao;
	
	@NotBlank
	@NotNull
	private String descricaoTarefa;
	
	@NotBlank
	@NotNull
	private String statusTarefa;

	
	
}