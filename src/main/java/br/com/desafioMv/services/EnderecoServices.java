package br.com.desafioMv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioMv.model.Cliente;
import br.com.desafioMv.model.Endereco;
import br.com.desafioMv.repository.EnderecoRepository;

@Service
public class EnderecoServices {

	@Autowired
	EnderecoRepository repository;

	public String cadastrar(Endereco endereco) {
		
		Endereco enderecoSalvo = repository.save(endereco);
		return enderecoSalvo.toString();
	}
	
	public List<Endereco> listarTodos() {
		
		List<Endereco> endereco = (List<Endereco>) repository.findAll();
		
		return endereco;
	}
	
}
