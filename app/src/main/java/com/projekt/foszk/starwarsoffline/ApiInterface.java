package com.projekt.foszk.starwarsoffline;

import retrofit2.Call;
import retrofit2.http.GET;

interface ApiInterface {
    @GET("films/")
    Call <Films> getFilms();

    @GET("people/")
    Call <People> getPeople();

    @GET("planets/")
    Call <Planets> getPlanets();

    @GET("species/")
    Call <Species> getSpecies();

    @GET("starships/")
    Call <Starships> getStarships();

    @GET("vehicles/")
    Call <Vehicles> getVehicles();

}

