package com.mitra.GDPRate.Controller;

import com.mitra.GDPRate.Model.Country;
import com.mitra.GDPRate.Model.GDP;
import com.mitra.GDPRate.Service.GDPService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gdprates")
public class GDPController {
    private GDPService gdpService;

    public GDPController(GDPService gdpService) {
        this.gdpService = gdpService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<GDP>> getGDPRange(@RequestParam("code") String code,@RequestParam("startyear") int year1,@RequestParam("endyear") int year2){
        return ResponseEntity.ok(gdpService.getGDPRange(code,year1,year2));
    }

    @PostMapping
    public GDP createGDP(@RequestBody GDP gdp){
        return gdpService.createGDP(gdp);
    }
}
