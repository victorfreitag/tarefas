package com.tarefa.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarefa.entities.Tarefa;
import com.tarefa.service.tarefaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Tarefa", description = "API REST DE GERENCIAMENTO DE CLIENTE")
@RestController
@RequestMapping("/tarefa")
public class tarefaController {

	private final tarefaService tarefaService;

	@Autowired
	public tarefaController(tarefaService tarefaservice) {
		this.tarefaService = tarefaservice;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza Tarefa por ID")
	public ResponseEntity<Tarefa> buscaTarefaControlId(@PathVariable Long id) {
		Tarefa tarefa = tarefaService.buscaClienteId(id);
		if (tarefa != null) {
			return ResponseEntity.ok(tarefa);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Apresenta todos os Tarefa")
	public ResponseEntity<List<Tarefa>> buscaTodosTarefaControl() {
		List<Tarefa> Tarefa = tarefaService.buscaTodosCliente();
		return ResponseEntity.ok(Tarefa);
	}

	@PostMapping
	@Operation(summary = "Cadastra um Tarefa")
	public ResponseEntity<Tarefa> salvaTarefaControl(@RequestBody Tarefa tarefa) {
		Tarefa salvaTarefa = tarefaService.salvaCliente(tarefa);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaTarefa);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Altera um Tarefa")
	public ResponseEntity<Tarefa> alteraTarefaControl(@PathVariable Long id, @RequestBody @Valid Tarefa Tarefa) {
		Tarefa alteraTarefa = tarefaService.alterarCliente(id, Tarefa);
		if (alteraTarefa != null) {
			return ResponseEntity.ok(Tarefa);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Exclui um Tarefa")
	public ResponseEntity<Tarefa> apagaTarefaControl(@PathVariable Long id) {
		boolean apagar = tarefaService.apagarCliente(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}