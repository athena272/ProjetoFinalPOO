package com.devsuperior.dsmovie.repositories;

import com.devsuperior.dsmovie.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository  extends JpaRepository<Movie, Long> { // Classe de comunicação com o banco de dados, herda JpaRepository parametrizado com Movie e Long
}
