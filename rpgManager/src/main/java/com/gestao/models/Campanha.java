package com.gestao.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Campanha 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.DATE) @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date cdate;
	private String nome;
	
	//Get-Set
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	
	public Date getCdate() { return cdate; }
	public void setCdate(Date cDate) { this.cdate = cDate; }
	
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
}