package projetoXD.locadora;

import java.util.List;

import javax.persistence.Entity;

import projetoXD.BaseEntity;

@Entity
public class Locadora extends BaseEntity{

	private String nomeLocadora;
	private List<String> veiculos;
	private String endereco;
	private String cnpj;
	
	
	public Locadora() {}
	
	public Locadora(String nomeLocadora, String veiculo, String endereco, String cnpj) {
		this.nomeLocadora = nomeLocadora;
		this.veiculos.add(veiculo);
		this.endereco = endereco;
		this.cnpj = cnpj;
	}
	
	public String getNomeLocadora() {
		return nomeLocadora;
	}
	public List<String> getVeiculos() {
		return veiculos;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getCnpj() {
		return cnpj;
	}
	
	

}
