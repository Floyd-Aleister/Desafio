package br.com.desafioMv.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioMv.model.Cliente;
import br.com.desafioMv.model.Conta;
import br.com.desafioMv.services.ClienteServices;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteServices services;
	
	@PostMapping("/adicionar")
	@ResponseBody
	public ResponseEntity<Cliente> adicionarCliente(@RequestBody Cliente cliente) {
		Cliente clienteSalvo = services.salvar(cliente);		
		return ResponseEntity.ok(clienteSalvo) ;
	}
	
	@GetMapping("/listar")
	@ResponseBody
	public ResponseEntity<List<Cliente>> listarTodos() {
		List<Cliente> clientes = services.listarTodos();
		return ResponseEntity.ok(clientes);
	}
	
	@DeleteMapping("/excluir/{id}")
	@ResponseBody
	public ResponseEntity<Cliente> excluir(@PathVariable Long id){
		services.excluir(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping("/alterar/{id}")
	@ResponseBody
	public ResponseEntity<Cliente> excluir(@PathVariable Long id, @RequestBody Cliente cliente) throws Exception{
		Cliente clienteSalvo = services.alterar(id, cliente);
		return ResponseEntity.ok(clienteSalvo);
	}
	
}
