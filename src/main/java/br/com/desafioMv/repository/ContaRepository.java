package br.com.desafioMv.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioMv.model.Conta;

@Repository
public interface ContaRepository extends CrudRepository<Conta, Long>{

}
