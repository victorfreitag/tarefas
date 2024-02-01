package com.tarefa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarefa.entities.Tarefa;

public interface tarefaRepository extends JpaRepository<Tarefa, Long> {
	
}