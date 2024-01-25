package br.com.desafioMv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.desafioMv.services.ContaServices;

@Controller
@RequestMapping("/Conta")
public class ContaController {

	@Autowired
	ContaServices services;
}
