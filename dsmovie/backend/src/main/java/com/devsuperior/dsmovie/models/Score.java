package com.devsuperior.dsmovie.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_score") // Atribuindo nome da tabela
public class Score {
    @EmbeddedId
    private ScorePrimaryKey id = new ScorePrimaryKey();

    private Double value;

    public Score(){}

    public void SetMovie(Movie movie){
        id.setMovie(movie);
    }

    public void SetUser(User user){
        id.setUser(user);
    }

    public ScorePrimaryKey getId() {
        return id;
    }

    public void setId(ScorePrimaryKey id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
