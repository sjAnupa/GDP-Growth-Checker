package com.mitra.GDPRate.Repository;

import com.mitra.GDPRate.Model.GDP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GDPRepository extends JpaRepository<GDP, Integer> {
    @Query("Select g from GDP g where g.code = ?1 and g.year between ?2 and ?3")
    List<GDP> getGDPRange(String code, int year1, int year2);
}
