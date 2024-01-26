package br.com.desafioMv.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioMv.model.Movimentacao;

@Repository
public interface MovimentacaoRepository extends CrudRepository<Movimentacao, Long>{

}
