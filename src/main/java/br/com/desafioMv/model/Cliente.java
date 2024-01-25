package br.com.desafioMv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente")
	private Long cdCliente;
	private String nomeCliente;
	private String cnpj;
	private String cpf;
	private String tpCliente;
	private String telefone;
	
	public Cliente () {
	}

	public Cliente(Long cdCliente, String nomeCliente, String cnpj, String cpf, String tpCliente, String telefone) {
		super();
		this.cdCliente = cdCliente;
		this.nomeCliente = nomeCliente;
		this.cnpj = cnpj;
		this.cpf = cpf;
		this.tpCliente = tpCliente;
		this.telefone = telefone;
	}

	public Long getCdCliente() {
		return cdCliente;
	}

	public void setCdCliente(Long cdCliente) {
		this.cdCliente = cdCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTpCliente() {
		return tpCliente;
	}

	public void setTpCliente(String tpCliente) {
		this.tpCliente = tpCliente;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Cliente [cdCliente=" + cdCliente + ", nomeCliente=" + nomeCliente + ", cnpj=" + cnpj + ", cpf=" + cpf
				+ ", tpCliente=" + tpCliente + ", telefone=" + telefone + "]";
	}

	
	
}
