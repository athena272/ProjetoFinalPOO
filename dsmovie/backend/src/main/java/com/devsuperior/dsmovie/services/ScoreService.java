package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.DTO.MovieDTO;
import com.devsuperior.dsmovie.DTO.ScoreDTO;
import com.devsuperior.dsmovie.models.Movie;
import com.devsuperior.dsmovie.models.Score;
import com.devsuperior.dsmovie.models.User;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // Registrando classe como componente pois será uma classe customizada
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto){
        User user = userRepository.findByEmail(dto.getEmail());
        if(user == null){
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        Score score = new Score();
        score.SetMovie(movie);
        score.SetUser(user);

        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s: movie.getScores()){
            sum += s.getValue();
        }

        double average = sum / movie.getScores().size();

        movie.setScore(average);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }
}
