package com.cydeo.entity;

import com.cydeo.enums.State;
import com.cydeo.enums.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Movie extends BaseEntity{

    private String name;
    @Enumerated(EnumType.STRING)
    private State state;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime releaseDate;
    private BigDecimal price;
    private Integer duration;
    @Column(columnDefinition = "text")
    private String summary;
    @ManyToMany
    @JoinTable(name = "movie_genre_rel",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genreList;

}
