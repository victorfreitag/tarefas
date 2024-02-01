package com.tarefa.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarefa.entities.Tarefa;
import com.tarefa.repository.tarefaRepository;
@Service
public class tarefaService {

	private final tarefaRepository tarefaRepository;

	@Autowired
	public tarefaService(tarefaRepository tarefaRepository) {
		this.tarefaRepository = tarefaRepository;
	}
	public List<Tarefa> buscaTodosCliente(){
		return tarefaRepository.findAll();
	}
	public Tarefa buscaClienteId(Long id) {
		Optional <Tarefa> tarefa = tarefaRepository.findById(id);
		return tarefa.orElse(null);
	}
	public Tarefa salvaCliente(Tarefa Cliente) {
		return tarefaRepository.save(Cliente);
	}
	public Tarefa alterarCliente(Long id, Tarefa alterarC) {
		Optional <Tarefa> existeTarefa = tarefaRepository.findById(id);
		if(existeTarefa.isPresent()) {
			alterarC.setId(id);
			return tarefaRepository.save(alterarC);
		}
		return null;
	}
	public boolean apagarCliente(Long id) {
		Optional <Tarefa> existeAluno = tarefaRepository.findById(id);
		if (existeAluno.isPresent()) {
			tarefaRepository.deleteById(id);
			return true;
		}
		return false;
		}
	
	}
