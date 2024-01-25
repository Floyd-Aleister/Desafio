package br.com.desafioMv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.desafioMv.model.Cliente;
import br.com.desafioMv.services.ClienteServices;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteServices services;
	
	@GetMapping("/adicionar")
	@ResponseBody
	public String adicionarCliente() {
		
		Cliente maria = new Cliente();
		maria.setNomeCliente("Maria Helena dos dos Santos");
		maria.setCpf("123456");
		maria.setTelefone("92997345");
		maria.setTpCliente("PF");
		
		Cliente clienteSalvo = services.salvar(maria);
		
		return clienteSalvo.toString();
	}
	
	@GetMapping("/listar")
	@ResponseBody
	public List<Cliente> listarTodos() {
		List<Cliente> clientes = services.listarTodos();
		return clientes;
	}
	

}
