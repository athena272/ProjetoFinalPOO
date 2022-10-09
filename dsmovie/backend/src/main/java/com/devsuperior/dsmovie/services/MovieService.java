package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.DTO.MovieDTO;
import com.devsuperior.dsmovie.models.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // Registrando classe como componente pois será uma classe customizada
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable){ // Pageable pois a busca dos filmes é paginada
        Page<Movie> result = repository.findAll(pageable);
        Page<MovieDTO> page = result.map(MovieDTO::new); // Transformando cada movie em movieDTO
        return page;
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id){ // Pageable pois a busca dos filmes é paginada
        Movie result = repository.findById(id).get();
        MovieDTO dto = new MovieDTO(result); // Transformando cada movie em movieDTO
        return dto;
    }
}
