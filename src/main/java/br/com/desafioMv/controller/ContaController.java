package br.com.desafioMv.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.desafioMv.model.Conta;
import br.com.desafioMv.services.ContaServices;

@Controller
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	ContaServices services;
	
	@PostMapping("/adicionar/{idcliente}")
	@ResponseBody
	public ResponseEntity<Conta> adicionar(@RequestBody Conta c, @PathVariable Long idcliente) throws Exception{
		
		return services.adicionar(c, idcliente);
	}
	@GetMapping("/localizar/{idconta}")
	@ResponseBody
	public ResponseEntity<Conta> localizar(@PathVariable Long idconta) throws Exception{
		
		return services.localizar(idconta);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Conta> excluir(@PathVariable Long id) throws Exception{
		return services.excluir(id);
	}
	
	@PutMapping("/creditar/{valor}/{idconta}")
	public ResponseEntity<Conta> creditar(@PathVariable BigDecimal valor, @PathVariable Long idconta) throws Exception {
		services.creditar(valor, idconta);
		return null;
	}
	
	@PostMapping("/debitar/{valor}/{idconta}")
	public ResponseEntity<Conta> debitar(@PathVariable BigDecimal valor, @PathVariable Long idconta) throws Exception {
		services.debitar(valor, idconta);
		return null;
	}
	
	@PostMapping("/transferir/{idcontaorigem}/{idcontadestino}/{valor}")
	public ResponseEntity<String> transferir(@PathVariable Long idcontaorigem, @PathVariable Long idcontadestino,  @PathVariable BigDecimal valor) throws Exception {
		
		return services.transferir(idcontaorigem, idcontadestino, valor);
	}

}
