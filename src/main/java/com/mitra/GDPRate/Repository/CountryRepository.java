package com.mitra.GDPRate.Repository;

import com.mitra.GDPRate.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query("Select c from Country c where c.name = ?1")
    List<Country> searchCountry(String query);
}
