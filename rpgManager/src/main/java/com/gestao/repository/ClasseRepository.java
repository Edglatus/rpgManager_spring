package com.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestao.models.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Long>{}
