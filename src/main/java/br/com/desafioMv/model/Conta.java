package br.com.desafioMv.model;

import java.math.BigDecimal;

import org.hibernate.id.BulkInsertionCapableIdentifierGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "conta")
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "seq_conta", sequenceName = "seq_conta")
	public Long idConta;   //Chave primaria da tabela cliente
	@ManyToOne	
	private Cliente cliente;
	private Long nrConta;        //Número da conta
	private Long nrAgencia;
	private String dsAgencia;
	private Long dgIdentificador;
	private BigDecimal saldo;
	
	
	public Conta() {
	}
	
	

	public Long getIdConta() {
		return idConta;
	}



	public void setIdConta(Long idConta) {
		this.idConta = idConta;
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

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}

	public Conta(Long idConta, Long cdCliente, Long nrConta, Long nrAgencia, String dsAgencia, Long dgIdentificador, Cliente c) {
		super();
		this.idConta = idConta;		
		this.nrConta = nrConta;
		this.nrAgencia = nrAgencia;
		this.dsAgencia = dsAgencia;
		this.dgIdentificador = dgIdentificador;
		this.cliente = c;
		this.saldo = BigDecimal.ZERO;
	}



	@Override
	public String toString() {
		return "Conta [idConta=" + idConta + ", cliente=" + cliente + ", nrConta=" + nrConta + ", nrAgencia="
				+ nrAgencia + ", dsAgencia=" + dsAgencia + ", dgIdentificador=" + dgIdentificador + ", saldo=" + saldo
				+ "]";
	}





	
	
}
