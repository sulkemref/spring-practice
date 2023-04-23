package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Integer> {

    List<Region> findByCountry(String country);
    List<Region> getByCountry(String country); // the same is the find
    List<Region> findByCountryContaining(String country);

    List<Region> findByCountryContainingOrderByRegionDesc(String country);

    List<Region> findTopByCountry(String country);
    List<Region> findTop2ByCountry(String country);

}
