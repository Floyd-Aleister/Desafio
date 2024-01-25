package br.com.desafioMv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco")
	public Long cdEndereco;
	
	private String rua;
	private int numero;
	private String cep;
	private String bairro;
	private String cidade;
	private String complemento;
	private String uf;
	
	public Endereco() {
	}

	
	
	public Endereco(Long cdEndereco, String cep, String bairro, String rua, int numero, String cidade, String complemento, String uf) {
		super();
		this.cdEndereco = cdEndereco;
		this.rua = rua;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.complemento = complemento;
		this.uf = uf;
		this.numero = numero;
	}



	public int getNumero() {
		return numero;
	}



	public void setNumero(int numero) {
		this.numero = numero;
	}



	public Long getCdEndereco() {
		return cdEndereco;
	}

	public void setCdEndereco(Long cdEndereco) {
		this.cdEndereco = cdEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}


	@Override
	public String toString() {
		return "Endereco [cdEndereco=" + cdEndereco + ", cep=" + cep + ", bairro=" + bairro + ", rua=" + rua   + ", numero=" + numero +  ", cidade=" + cidade
				+ ", complemento=" + complemento + ", uf=" + uf + "]";
	}



	public String getRua() {
		return rua;
	}



	public void setRua(String rua) {
		this.rua = rua;
	}
	
	
}
