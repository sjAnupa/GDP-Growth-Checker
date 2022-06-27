package com.mitra.GDPRate.Service.Impl;

import com.mitra.GDPRate.Model.GDP;
import com.mitra.GDPRate.Repository.GDPRepository;
import com.mitra.GDPRate.Service.GDPService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GDPImpl implements GDPService {

    private final GDPRepository gdpRepository;

    public GDPImpl(GDPRepository gdpRepository) {
        this.gdpRepository = gdpRepository;
    }

    @Override
    public List<GDP> getGDPRange(String code, int year1, int year2) {
        List<GDP> gdps = gdpRepository.getGDPRange(code,year1,year2);
        return gdps;
    }

    @Override
    public GDP createGDP(GDP gdp) {
        return (GDP) gdpRepository.save(gdp);
    }
}
