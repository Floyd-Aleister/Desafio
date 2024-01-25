package br.com.desafioMv.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioMv.model.Cliente;
import jakarta.transaction.Transactional;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
//	@Transactional
//	@Modifying
//	@Query(value = "CALL PRC_INCLUI_CLIENTE(:nome, )", nativeQuery = true)
//	void incluirCliente (String nome);	

}
