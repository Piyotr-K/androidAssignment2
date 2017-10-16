package ca.bcit.ass2.kao_zhang;

/**
 * Created by Lel on 2017-10-10.
 */

import java.util.List;

public class Country {
    private String name;

    private String capital;

    private String region;

    private int population;

    private Double area;

    private List<String> borders;

    private String flag;

    public Country(){

    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return this.name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCapital() {
        return this.capital;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return this.region;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getArea() {
        return this.area;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public List<String> getBorders() {
        return this.borders;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return this.flag;
    }
}
