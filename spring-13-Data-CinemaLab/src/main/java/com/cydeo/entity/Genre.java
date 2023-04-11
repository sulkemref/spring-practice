package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Genre extends BaseEntity{

    private String name;
    @ManyToMany(mappedBy = "genreList")
    private List<Movie> movieList;

    public Genre(String name, List<Movie> movieList) {
        this.name = name;
        this.movieList = movieList;
    }
}
