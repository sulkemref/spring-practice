package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    Optional<Cinema> getByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findTop3BySponsoredNameContains(String name);

    List<Cinema> findFirst3BySponsoredNameContainingOrderBySponsoredName(String sponsoredName);

    List<Cinema> findTop3BySponsoredNameContainsOrderByName(String name);
    //Write a derived query to list all cinemas in a specific country
    List<Cinema> getAllCinemaByLocation_Country(String country);

    List<Cinema> findAllByLocationCountry(String country);

    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findByNameOrSponsoredName(String name, String sponsoredName);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query("SELECT c.name FROM Cinema c WHERE c.id=?1")
    String getNameOfCinemaById(Long id);

    @Query("SELECT c.name FROM Cinema c WHERE c.id = :id")
    String fetchById(@Param("id")Long id);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(value = "SELECT * FROM cinema c JOIN Location l ON c.location_id = l.id WHERE l.country = ?1",nativeQuery = true)
    List<Cinema> findAllCinemasByLocationCountry(String country);

    @Query(value = "SELECT * FROM cinema c JOIN Location l ON c.location_id = l.id WHERE l.country = :locationCountry",nativeQuery = true)
    List<Cinema> retrieveAllBasedOnLocationCountry(@Param("locationCountry") String locationCountry);
    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "SELECT * FROM cinema c WHERE c.name LIKE ?1 OR  c.sponsored_name LIKE ?1",nativeQuery = true )
    List<Cinema> findAllCinemasByNameOrSponsoredNameByPattern(String pattern);

    @Query(value = "SELECT * FROM cinema WHERE name ILIKE concat ('%',?1,'%') OR sponsored_name ILIKE concat ('%',?1,'%')",nativeQuery = true)
    List<Cinema> retrieveAllByNameOrSponsoredName(@Param("pattern") String pattern);

    @Query(value = "SELECT * FROM cinema WHERE LOWER(name) LIKE LOWER(concat ('%',?1,'%')) OR LOWER(sponsored_name) LIKE LOWER(concat ('%',?1,'%'))",nativeQuery = true)
    List<Cinema> retrieveAllByNameOrSponsoredName2(@Param("pattern") String pattern);
    //Write a native query to sort all cinemas by name
    @Query(value = "SELECT * FROM cinema c ORDER BY c.name",nativeQuery = true)
    List<Cinema> retrieveAllSortByName();

    //Write a native query to distinct all cinemas by sponsored name
    @Query(value = "SELECT * FROM cinema c WHERE sponsored_name=?1",nativeQuery = true)
    List<Cinema> retrieveAllDistinctBySponsorName(String sponsorName);

    @Query(value = "SELECT DISTINCT sponsored_name FROM cinema",nativeQuery = true)
    List<String> distinctBySponsoredName();


}
