package com.mitra.GDPRate.Service.Impl;

import com.mitra.GDPRate.CSVHelper;
import com.mitra.GDPRate.Model.GDP;
import com.mitra.GDPRate.Repository.CountryRepository;
import com.mitra.GDPRate.Repository.GDPRepository;
import com.mitra.GDPRate.Service.CSVService;
import com.mitra.GDPRate.Service.GDPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public class CSVImpl implements CSVService {

    @Autowired
    private GDPRepository gdpRepository;
    @Autowired
    private  CountryRepository countryRepository;

    public void handleFile(MultipartFile file) throws IOException {
        CSVHelper.csvToCountries(file.getInputStream(), countryRepository, gdpRepository);
    }


    public List<GDP> getGDPRange(String code, int year1, int year2) {
        List<GDP> gdps = gdpRepository.getGDPRange(code,year1,year2);
        return gdps;
    }


    public GDP createGDP(GDP gdp) {
        return (GDP) gdpRepository.save(gdp);
    }
}
