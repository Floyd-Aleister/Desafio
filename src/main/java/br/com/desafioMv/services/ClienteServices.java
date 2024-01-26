package br.com.desafioMv.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.desafioMv.model.Cliente;
import br.com.desafioMv.model.Conta;
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

	public void excluir(Long id) {
		Optional<Cliente> clienteLocalizado = repository.findById(id);
		if(clienteLocalizado.isPresent()) {
			repository.delete(clienteLocalizado.get());
		}
	}

	public Cliente alterar(Long id, Cliente cliente) throws Exception {
		Optional<Cliente> clienteLocalizado = repository.findById(id);
		if (clienteLocalizado.isPresent()) {
			cliente.setCdCliente(clienteLocalizado.get().getCdCliente());
			return repository.save(cliente);
		}else {
			throw new Exception("Cliente não Localizado!");
		}
		
	}


}
