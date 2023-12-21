package com.projekt.foszk.starwarsoffline;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Vehicles {
    @SerializedName("results")
    private final List<Vehicle> vehicles;

    public Vehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
class Vehicle {
    private final String name;
    private final String model;
    private final String vehicle_class;
    private final String manufacturer;
    private final String cost_in_credits;
    private final String length;
    private final String crew;
    private final String passengers;
    private final String max_atmosphering_speed;
    private final String cargo_capacity;
    private final String consumables;

    public Vehicle(String name, String model, String vehicle_class, String manufacturer, String cost_in_credits, String length, String crew, String passengers, String max_atmosphering_speed, String cargo_capacity, String consumables) {
        this.name = name;
        this.model = model;
        this.vehicle_class = vehicle_class;
        this.manufacturer = manufacturer;
        this.cost_in_credits = cost_in_credits;
        this.length = length;
        this.crew = crew;
        this.passengers = passengers;
        this.max_atmosphering_speed = max_atmosphering_speed;
        this.cargo_capacity = cargo_capacity;
        this.consumables = consumables;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getVehicle_class() {
        return vehicle_class;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCost_in_credits() {
        return cost_in_credits;
    }

    public String getLength() {
        return length;
    }

    public String getCrew() {
        return crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public String getMax_atmosphering_speed() {
        return max_atmosphering_speed;
    }

    public String getCargo_capacity() {
        return cargo_capacity;
    }

    public String getConsumables() {
        return consumables;
    }
}