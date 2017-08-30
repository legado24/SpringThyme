package com.servifact.app.repository;

import com.servifact.app.modelo.Cerveja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long> {

}
