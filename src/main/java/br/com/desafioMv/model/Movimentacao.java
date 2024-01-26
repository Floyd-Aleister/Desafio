package br.com.desafioMv.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "moviementacao")
public class Movimentacao {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	@SequenceGenerator(name = "seq_movimentacao", sequenceName = "seq_movimentacao")
	private Long cdMovimentacao;
	private LocalDate dtMovimentacao;
	private BigDecimal valor;
	private Long idConta;
	private String nrConta;
	private String tpMovimentacao;
	
	public Movimentacao() {
		
	}

	public Movimentacao(Long cdMovimentacao, BigDecimal valor, Long idConta, String nrConta,
			String tpMovimentacao) {
		super();
		this.cdMovimentacao = cdMovimentacao;
		this.dtMovimentacao = LocalDate.now();;
		this.valor = valor;
		this.idConta = idConta;
		this.nrConta = nrConta;
		this.tpMovimentacao = tpMovimentacao;
	}

	public Long getCdMovimentacao() {
		return cdMovimentacao;
	}

	public void setCdMovimentacao(Long cdMovimentacao) {
		this.cdMovimentacao = cdMovimentacao;
	}

	public LocalDate getDtMovimentacao() {
		return dtMovimentacao;
	}

	public void setDtMovimentacao(LocalDate dtMovimentacao) {
		this.dtMovimentacao = dtMovimentacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public String getNrConta() {
		return nrConta;
	}

	public void setNrConta(String nrConta) {
		this.nrConta = nrConta;
	}

	public String getTpMovimentacao() {
		return tpMovimentacao;
	}

	public void setTpMovimentacao(String tpMovimentacao) {
		this.tpMovimentacao = tpMovimentacao;
	}

	@Override
	public String toString() {
		return "Movimentacao [cdMovimentacao=" + cdMovimentacao + ", dtMovimentacao=" + dtMovimentacao + ", valor="
				+ valor + ", idConta=" + idConta + ", nrConta=" + nrConta + ", tpMovimentacao=" + tpMovimentacao + "]";
	}
	
	
	
}
