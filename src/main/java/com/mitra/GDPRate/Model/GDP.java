package com.mitra.GDPRate.Model;

import javax.persistence.*;

@Entity
@Table(name = "gdp")
public class GDP {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "year")
    private int year;

    @Column(name = "code")
    private String code;

    @Column(name = "gdp_rate")
    private double gdp_rate;

    public GDP(int year, String code, double gdp_rate) {
        this.year = year;
        this.code = code;
        this.gdp_rate = gdp_rate;
    }

    public GDP() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getGdp_rate() {
        return gdp_rate;
    }

    public void setGdp_rate(double gdp_rate) {
        this.gdp_rate = gdp_rate;
    }

    @Override
    public String toString() {
        return "GDP{" +
                "year=" + year +
                ", code='" + code + '\'' +
                ", gdp_rate=" + gdp_rate +
                '}';
    }
}
