package com.mitra.GDPRate.Service;

import com.mitra.GDPRate.Model.Country;

import java.util.List;

public interface CountryService {
    List<Country> searchCountry(String query);

    Country create(Country country);
}
