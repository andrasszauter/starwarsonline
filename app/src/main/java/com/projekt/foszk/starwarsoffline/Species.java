package com.projekt.foszk.starwarsoffline;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Species {
    @SerializedName("results")
    private final List<Spec> species;

    public Species(List<Spec> species) {
        this.species = species;
    }

    public List<Spec> getSpecies() {
        return species;
    }
}

class Spec {
    private final String name;
    private final String classification;
    private final String designation ;
    private final String average_height;
    private final String average_lifespan;
    private final String eye_colors;
    private final String hair_colors;
    private final String skin_colors;
    private final String language;

    public Spec(String name, String classification, String designation, String average_height, String average_lifespan, String eye_colors, String hair_colors, String skin_colors, String language) {
        this.name = name;
        this.classification = classification;
        this.designation = designation;
        this.average_height = average_height;
        this.average_lifespan = average_lifespan;
        this.eye_colors = eye_colors;
        this.hair_colors = hair_colors;
        this.skin_colors = skin_colors;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public String getClassification() {
        return classification;
    }

    public String getDesignation() {
        return designation;
    }

    public String getAverage_height() {
        return average_height;
    }

    public String getAverage_lifespan() {
        return average_lifespan;
    }

    public String getEye_colors() {
        return eye_colors;
    }

    public String getHair_colors() {
        return hair_colors;
    }

    public String getSkin_colors() {
        return skin_colors;
    }

    public String getLanguage() {
        return language;
    }
}