package br.com.desafioMv.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioMv.model.Cliente;
import br.com.desafioMv.repository.ClienteRepository;

@Service
public class ClienteServices {
	
	@Autowired
	ClienteRepository repository;

	public Cliente salvar(Cliente cliente) {
		
		return repository.save(cliente);
	}
	
	public void salvarTodos(List<Cliente> clientes) {
		 repository.saveAll(clientes);	
	}

	public List<Cliente> listarTodos() {
		
		List<Cliente> cliente = (List<Cliente>) repository.findAll();
		
		return cliente;
	}

}
