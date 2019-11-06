package com.gestao.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Personagem 
{
	//Attributes
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nome;

	@ManyToOne @JoinColumn(name="fk_player")
	private Jogador jogador;
	
	@ManyToOne @JoinColumn(name="fk_class")
	private Classe classe;
	
	@ManyToOne @JoinColumn(name="fk_campaign")
	private Campanha campanha;
	
	//Get-Set
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	
	public Jogador getJogador() { return jogador; }
	public void setJogador(Jogador jogador) { this.jogador = jogador; }

	public Classe getClasse() { return classe; }
	public void setClasse(Classe classe) { this.classe = classe; }
	
	public Campanha getCampanha() { return campanha; }
	public void setCampanha(Campanha campanha) { this.campanha = campanha; }
}
