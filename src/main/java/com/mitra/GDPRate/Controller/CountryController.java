package com.mitra.GDPRate.Controller;

import com.mitra.GDPRate.Model.Country;
import com.mitra.GDPRate.Model.GDP;
import com.mitra.GDPRate.Service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    private CountryService countryService;

    public CountryController(CountryService countryService){
        this.countryService=countryService;
    }
    @GetMapping("/search")
    public ResponseEntity<List<Country>> searchCountry(@RequestParam("query") String query){
        return ResponseEntity.ok(countryService.searchCountry(query));
    }
    @PostMapping
    public Country createGDP(@RequestBody Country country){
        return countryService.create(country);
    }

}
