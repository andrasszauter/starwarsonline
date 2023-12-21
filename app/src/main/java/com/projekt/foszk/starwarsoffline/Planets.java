package com.projekt.foszk.starwarsoffline;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Planets {
    @SerializedName("results")
    private List<Planet> planets;

    public Planets(List<Planet> planets) {
        this.planets = planets;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }
}
class Planet {
    private final String name;
    private final String diameter;
    private final String rotation_period ;
    private final String orbital_period;
    private final String gravity;
    private final String population;
    private final String climate;
    private final String terrain;
    private final String surface_water;

    public Planet(String name, String diameter, String rotation_period, String orbital_period, String gravity, String population, String climate, String terrain, String surface_water) {
        this.name = name;
        this.diameter = diameter;
        this.rotation_period = rotation_period;
        this.orbital_period = orbital_period;
        this.gravity = gravity;
        this.population = population;
        this.climate = climate;
        this.terrain = terrain;
        this.surface_water = surface_water;
    }

    public String getName() {
        return name;
    }

    public String getDiameter() {
        return diameter;
    }

    public String getRotation_period() {
        return rotation_period;
    }

    public String getOrbital_period() {
        return orbital_period;
    }

    public String getGravity() {
        return gravity;
    }

    public String getPopulation() {
        return population;
    }

    public String getClimate() {
        return climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getSurface_water() {
        return surface_water;
    }
}