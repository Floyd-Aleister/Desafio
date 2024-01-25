package br.com.desafioMv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "conta")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "seq_conta", sequenceName = "seq_conta")
	public Long idConta;   //Chave primaria da tabela cliente
	
	private Long cdCliente;
	private Long nrConta;        //Número da conta
	private Long nrAgencia;
	private String dsAgencia;
	private Long dgIdentificador;
	
	public Conta() {
	}
	
	

	public Long getIdConta() {
		return idConta;
	}



	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}



	public Long getCdCliente() {
		return cdCliente;
	}



	public void setCdCliente(Long cdCliente) {
		this.cdCliente = cdCliente;
	}



	public Long getNrConta() {
		return nrConta;
	}



	public void setNrConta(Long nrConta) {
		this.nrConta = nrConta;
	}



	public Long getNrAgencia() {
		return nrAgencia;
	}



	public void setNrAgencia(Long nrAgencia) {
		this.nrAgencia = nrAgencia;
	}



	public String getDsAgencia() {
		return dsAgencia;
	}



	public void setDsAgencia(String dsAgencia) {
		this.dsAgencia = dsAgencia;
	}



	public Long getDgIdentificador() {
		return dgIdentificador;
	}



	public void setDgIdentificador(Long dgIdentificador) {
		this.dgIdentificador = dgIdentificador;
	}



	public Conta(Long idConta, Long cdCliente, Long nrConta, Long nrAgencia, String dsAgencia, Long dgIdentificador) {
		super();
		this.idConta = idConta;
		this.cdCliente = cdCliente;
		this.nrConta = nrConta;
		this.nrAgencia = nrAgencia;
		this.dsAgencia = dsAgencia;
		this.dgIdentificador = dgIdentificador;
	}



	@Override
	public String toString() {
		return "Conta [idConta=" + idConta + ", cdCliente=" + cdCliente + ", nrConta=" + nrConta + ", nrAgencia="
				+ nrAgencia + ", dsAgencia=" + dsAgencia + ", dgIdentificador=" + dgIdentificador + "]";
	}
	
	
	
}
