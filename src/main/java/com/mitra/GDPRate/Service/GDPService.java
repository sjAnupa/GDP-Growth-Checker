package com.mitra.GDPRate.Service;

import com.mitra.GDPRate.Model.GDP;

import java.util.List;

public interface GDPService {
    List<GDP> getGDPRange(String code, int year1, int year2);

    GDP createGDP(GDP gdp);
}
