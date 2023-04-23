package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.enums.State;
import com.cydeo.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
//    List<Movie> findAllByNameNotNull();

    Optional<Movie> findByName(String name);

    //Write a derived query to list all movies between a range of prices
//    List<Movie> findAllByPriceBetween(int startPrice, int endPrice);

    List<Movie> findAllByPriceBetween(BigDecimal priceStart, BigDecimal priceEnd);
    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> findAllByDurationIn(List<Integer> durations);

    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> findAllByReleaseDateAfter(LocalDateTime dateTime);

    //Write a derived query to list all movies with a specific state and type
    List<Movie> findAllByStateAndType(State state, Type type);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
    @Query("SELECT m FROM Movie m WHERE m.price BETWEEN ?1 AND ?2")
    List<Movie> retrieveAllMoviePricesBetween(@Param("startPrice")BigDecimal startPrice, @Param("endPrice")BigDecimal endPrice);

    //Write a JPQL query that returns all movie names
    @Query("SELECT m.name FROM Movie m")
    List<String> retrieveAllMoviesNames();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(value = "SELECT * FROM movie WHERE name = ?1",nativeQuery = true)
    List<Movie> retrieveMovieByName(String name);

    @Query(value = "SELECT * FROM movie WHERE name = ?1",nativeQuery = true)
    Optional<Movie> retrieveByName(@Param("name")String name);


    //Write a native query that return the list of movies in a specific range of prices
    @Query(value = "SELECT * FROM movie WHERE price BETWEEN ?1 AND ?2",nativeQuery = true)
    List<Movie> retrieveMovieByRangePrice(BigDecimal startPrice, BigDecimal endPrice);

    @Query(value = "SELECT * FROM movie WHERE price BETWEEN ?1 AND ?2",nativeQuery = true)
    List<Movie> retrieveByPriceRange(@Param("startPrice")BigDecimal startPrice, @Param("endPrice")BigDecimal endPrice);
    //Write a native query to return all movies where duration exists in the range of duration
    @Query(value = "SELECT * FROM movie WHERE duration IN ?1",nativeQuery = true)
    List<Movie> retrieveMovieByDurationInList(List<Integer> duration);

    @Query(value = "SELECT * FROM movie WHERE duration IN ?1",nativeQuery = true)
    List<Movie> retrieveByDurationInRange(@Param("durations")List<Integer> durations);

    //Write a native query to list the top 5 most expensive movies
    @Query(value = "SELECT * FROM movie ORDER BY price DESC LIMIT 5",nativeQuery = true)
    List<Movie> retrieveTop5MovieByPriceDesc();

}
