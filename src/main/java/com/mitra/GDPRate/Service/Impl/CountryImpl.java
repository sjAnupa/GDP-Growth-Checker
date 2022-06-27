package com.mitra.GDPRate.Service.Impl;

import com.mitra.GDPRate.Model.Country;
import com.mitra.GDPRate.Repository.CountryRepository;
import com.mitra.GDPRate.Service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryImpl implements CountryService{
    private CountryRepository countryRepository;

    public CountryImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> searchCountry(String query) {
        List<Country> countries = countryRepository.searchCountry(query);
        return countries;
    }

    @Override
    public Country create(Country country) {
        return countryRepository.save(country);
    }
}
