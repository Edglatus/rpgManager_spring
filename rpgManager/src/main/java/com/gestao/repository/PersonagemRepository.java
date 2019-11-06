package com.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.models.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long>{}