package br.com.desafioMv.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.engine.spi.Resolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.desafioMv.model.Cliente;
import br.com.desafioMv.model.Conta;
import br.com.desafioMv.repository.ClienteRepository;
import br.com.desafioMv.repository.ContaRepository;

@Service
public class ContaServices {

	@Autowired
	ContaRepository repository;
	
	@Autowired
	ClienteRepository clienteRepository;

	public ResponseEntity<Conta> adicionar(Conta c, Long idcilente) throws Exception {
		Optional<Cliente> clienteLocalizado = clienteRepository.findById(idcilente);
		Conta conta = new Conta();
		if(clienteLocalizado.isPresent()) {
			c.setCliente(clienteLocalizado.get());
			conta = repository.save(c);			
		}else {
			throw new Exception("Cliente não Localizado!");
		}
		return ResponseEntity.ok(conta);
	}

	public ResponseEntity<Conta> localizar(Long idconta) throws Exception {
		Optional<Conta> contaLocalizada = repository.findById(idconta);
		if (contaLocalizada.isPresent()) {
			return ResponseEntity.ok(contaLocalizada.get());
		}else {
			throw new Exception("Conta não localizada!");			
		}
		
	}

	public ResponseEntity<Conta> excluir(Long id) throws Exception {
		Optional<Conta> conta = repository.findById(id);
		if(conta.isPresent()) {
			repository.delete(conta.get());
			return ResponseEntity.noContent().build();
		}else {
			throw new Exception("Conta não localizada");
		}
		
	}

	public ResponseEntity<Conta> creditar(BigDecimal valor, Long idconta) throws Exception {
		
		Optional<Conta> contaLocalizada = repository.findById(idconta);
		if(contaLocalizada.isPresent()) {
			//se o valor for maior que zero = 1
			//se o valor for igual retorna 0
			//se o valor for menor retorna -1
			if (valor.compareTo(BigDecimal.ZERO)==1) {
				BigDecimal saldoAtual = contaLocalizada.get().getSaldo();				
				saldoAtual = saldoAtual.add(valor);
				contaLocalizada.get().setSaldo(saldoAtual);
				Conta contaSalva = repository.save(contaLocalizada.get());
				return ResponseEntity.ok(contaSalva);
			}else if (valor.compareTo(BigDecimal.ZERO)==0) {
				throw new Exception("Valor inválido " + valor);
			}else if (valor.compareTo(BigDecimal.ZERO)==-1) {
				throw new Exception("Valor inválido " + valor);
			}
			System.out.println(valor.compareTo(BigDecimal.ZERO));
		}else {
			throw new Exception("Conta não localizada");
		}
		return null;
		
		
	}

	public ResponseEntity<Conta> debitar( @PathVariable BigDecimal valor, @PathVariable Long idconta) throws Exception {
		
		Optional<Conta> contaLocalizada = repository.findById(idconta);
		if(contaLocalizada.isPresent()) {			
			//se o valor for maior que zero = 1
			//se o valor for igual retorna 0
			//se o valor for menor retorna -1
			if (contaLocalizada.get().getSaldo().compareTo(valor)==-1) {
				throw new Exception("Saldo Insuficiente: Saldo atual->  " + contaLocalizada.get().getSaldo());
			}else 
			if (valor.compareTo(BigDecimal.ZERO)==1) {
				BigDecimal saldoAtual = contaLocalizada.get().getSaldo();				
				saldoAtual = saldoAtual.subtract(valor);
				contaLocalizada.get().setSaldo(saldoAtual);
				Conta contaSalva = repository.save(contaLocalizada.get());
				return ResponseEntity.ok(contaSalva);
			}else if (valor.compareTo(BigDecimal.ZERO)==0) {
				throw new Exception("Valor inválido " + valor);
			}else if (valor.compareTo(BigDecimal.ZERO)==-1) {
				throw new Exception("Valor inválido " + valor);
			}
			System.out.println(valor.compareTo(BigDecimal.ZERO));
		}else {
			throw new Exception("Conta não localizada");
		}
		return null;
	}
	
	@GetMapping("/transferir/{idcontaorigem}/{idcontadestino}")
	public ResponseEntity<String> transferir(@PathVariable  Long idcontaorigem, @PathVariable Long idcontadestino, @PathVariable BigDecimal valor) throws Exception {
		
		Optional<Conta> contaOrigem = repository.findById(idcontaorigem);
		Optional<Conta> contaDestino = repository.findById(idcontadestino);
		//Verifica se existe saldo suficiente para a transferencia
		if (contaOrigem.get().getSaldo().compareTo(valor)==-1) {
			throw new Exception("Saldo Insuficiente: Saldo atual->  " + contaOrigem.get().getSaldo());
		}else {
			BigDecimal saldoOrigem = contaOrigem.get().getSaldo();
			saldoOrigem = saldoOrigem.subtract(valor);
			contaOrigem.get().setSaldo(saldoOrigem);
			
			BigDecimal saldoDestino = contaDestino.get().getSaldo();
			saldoDestino = saldoDestino.add(valor);
			contaDestino.get().setSaldo(saldoDestino);
			
			List<Conta>listaDeContas = new ArrayList<>();
			listaDeContas.add(contaOrigem.get());
			listaDeContas.add(contaDestino.get());
			
			repository.saveAll(listaDeContas);
			
			return ResponseEntity.ok("Operação realizada com sucesso! Saldo Atual->" + saldoDestino);
		}
			
		
	
	}
}
