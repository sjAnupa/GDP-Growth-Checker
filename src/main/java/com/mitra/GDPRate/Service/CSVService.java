package com.mitra.GDPRate.Service;
import com.mitra.GDPRate.Model.GDP;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface CSVService{

    public void handleFile(MultipartFile file) throws IOException;

    public List<GDP> getGDPRange(String code, int year1, int year2);

    public GDP createGDP(GDP gdp);
}
