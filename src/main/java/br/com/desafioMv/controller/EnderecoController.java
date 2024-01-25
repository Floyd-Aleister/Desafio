package br.com.desafioMv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.desafioMv.model.Cliente;
import br.com.desafioMv.model.Endereco;
import br.com.desafioMv.services.EnderecoServices;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	EnderecoServices enderecoServices;
	
	@GetMapping("/adicionar/{endereco}")
	@ResponseBody
	public String cadastrarEndereco(@PathVariable("endereco")  String endereco) {
		
		Endereco enderecoSalvo = new Endereco();
		enderecoSalvo.setRua("Rua B");
		enderecoSalvo.setNumero(50);
		enderecoSalvo.setBairro("Candeias");
		enderecoSalvo.setCep("54456477");
		enderecoSalvo.setComplemento("Apartamento");
		enderecoSalvo.setCidade(endereco);
		enderecoSalvo.setUf("PE");
		
		//Rua C, 50, Candeias, null, casa, cabo de Santo Agostinho, PE
		return enderecoServices.cadastrar(enderecoSalvo);
	}
	
	@GetMapping("/listar")
	@ResponseBody
	public List<Endereco> listarTodos() {
		List<Endereco> enderecos = enderecoServices.listarTodos();
		return enderecos;
	}
}
