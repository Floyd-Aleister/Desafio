package br.com.desafioMv.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioMv.repository.ContaRepository;

@Service
public class ContaServices {

	@Autowired
	ContaRepository repository;
}
