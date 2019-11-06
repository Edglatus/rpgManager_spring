package com.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.models.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long>{}