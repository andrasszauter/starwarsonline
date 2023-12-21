package com.projekt.foszk.starwarsoffline;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.widget.TextView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Callback;
import retrofit2.Response;
import android.util.Log;
import java.io.IOException;
import android.widget.EditText;
import android.widget.Button;

public class PlanetsFragment extends Fragment {
    private RecyclerView recyclerView;
    private PlanetsAdapter planetsAdapter;
    private List<Planet> planetsList = new ArrayList<Planet>();
    private EditText searchEditText;

    public PlanetsFragment() {
        // Required empty public constructor
    }

    final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    final ApiInterface service = retrofit.create(ApiInterface.class);

    public void fetchPlanetsData() {
        Call<Planets> call = service.getPlanets();

        call.enqueue(new Callback<Planets>() {
            @Override
            public void onResponse(Call<Planets> call, Response<Planets> response) {
                Log.d("PlanetsFragment", "onResponse called");
                if (response.isSuccessful() && response.body().getPlanets() != null) {
                    planetsList = response.body().getPlanets();
                    planetsAdapter = new PlanetsAdapter(planetsList);
                    recyclerView.setAdapter(planetsAdapter);
                    Log.d("PlanetsFragment", "planetsList size: " + planetsList.size());

                } else {
                    try {
                        Log.e("API Error", "Error fetching data from API. Code: " + response.code() + " Message: " + response.errorBody().string());
                    } catch (IOException e) {
                        Log.e("API Error", "Error fetching data from API. Failed to read error body.");
                    }
                    Log.e("API Error", "Error fetching data from API. Headers: " + response.headers());
                }
            }

            @Override
            public void onFailure(Call<Planets> call, Throwable t) {
                Log.e("API Error", "Error fetching data from API" + t.getMessage());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("PlanetsFragment", "onCreateView called");
        View view = inflater.inflate(R.layout.fragment_planets, container, false);
        recyclerView = view.findViewById(R.id.recViewPlanets);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fetchPlanetsData();
        planetsAdapter = new PlanetsAdapter(planetsList);
        recyclerView.setAdapter(planetsAdapter);
        searchEditText = view.findViewById(R.id.planetsSearchEditText);
        Button searchButton = view.findViewById(R.id.button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchTerm = searchEditText.getText().toString().toLowerCase();
                List<Planet> filteredPlanets = new ArrayList<>();
                for (Planet person : planetsList) {
                    if (person.getName().toLowerCase().matches(".*" + searchTerm + ".*")) {
                        filteredPlanets.add(person);
                    }
                }
                planetsAdapter.setPlanets(filteredPlanets);
            }
        });
        Button clearButton = view.findViewById(R.id.clear_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchEditText.setText("");
                planetsAdapter.setPlanets(planetsList);
            }
        });
        return view;
    }

    public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsAdapter.ViewHolder> {
        private List<Planet> planets;

        public void setPlanets(List<Planet> planets) {
            this.planets = planets;
            notifyDataSetChanged();
        }

        public PlanetsAdapter(List<Planet> planets) {
            this.planets = planets;
        }

        @NonNull
        @Override
        public PlanetsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PlanetsAdapter.ViewHolder holder, int position) {
            Planet planet = planets.get(position);

            holder.planetName.setText(planet.getName());
            holder.planetDiameter.setText(planet.getDiameter());
            holder.planetRotationPeriod.setText(planet.getRotation_period());
            holder.planetOrbitalPeriod.setText(planet.getOrbital_period());
            holder.planetGravity.setText(planet.getGravity());
            holder.planetPopulation.setText(planet.getPopulation());
            holder.planetClimate.setText(planet.getClimate());
            holder.planetTerrain.setText(planet.getTerrain());
            holder.planetSurfaceWater.setText(planet.getSurface_water());
            holder.planetDiameterLabel.setVisibility(View.GONE);
            holder.planetDiameter.setVisibility(View.GONE);
            holder.planetRotationPeriodLabel.setVisibility(View.GONE);
            holder.planetRotationPeriod.setVisibility(View.GONE);
            holder.planetOrbitalPeriodLabel.setVisibility(View.GONE);
            holder.planetOrbitalPeriod.setVisibility(View.GONE);
            holder.planetGravityLabel.setVisibility(View.GONE);
            holder.planetGravity.setVisibility(View.GONE);
            holder.planetPopulationLabel.setVisibility(View.GONE);
            holder.planetPopulation.setVisibility(View.GONE);
            holder.planetClimateLabel.setVisibility(View.GONE);
            holder.planetClimate.setVisibility(View.GONE);
            holder.planetTerrainLabel.setVisibility(View.GONE);
            holder.planetTerrain.setVisibility(View.GONE);
            holder.planetSurfaceWaterLabel.setVisibility(View.GONE);
            holder.planetSurfaceWater.setVisibility(View.GONE);
        }

        @Override
        public int getItemCount() {
            return planets.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView planetName;
            private final TextView planetDiameterLabel;
            private final TextView planetDiameter;
            private final TextView planetRotationPeriodLabel;
            private final TextView planetRotationPeriod;
            private final TextView planetOrbitalPeriodLabel;
            private final TextView planetOrbitalPeriod;
            private final TextView planetGravityLabel;
            private final TextView planetGravity;
            private final TextView planetPopulationLabel;
            private final TextView planetPopulation;
            private final TextView planetClimateLabel;
            private final TextView planetClimate;
            private final TextView planetTerrainLabel;
            private final TextView planetTerrain;
            private final TextView planetSurfaceWaterLabel;
            private final TextView planetSurfaceWater;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                planetName = itemView.findViewById(R.id.textViewName);
                planetDiameterLabel = itemView.findViewById(R.id.textViewDiameterLabel);
                planetDiameter = itemView.findViewById(R.id.textViewDiameter);
                planetRotationPeriodLabel = itemView.findViewById(R.id.textViewRotationPeriodLabel);
                planetRotationPeriod = itemView.findViewById(R.id.textViewRotationPeriod);
                planetOrbitalPeriodLabel = itemView.findViewById(R.id.textViewOrbitalPeriodLabel);
                planetOrbitalPeriod = itemView.findViewById(R.id.textViewOrbitalPeriod);
                planetGravityLabel = itemView.findViewById(R.id.textViewGravityLabel);
                planetGravity = itemView.findViewById(R.id.textViewGravity);
                planetPopulationLabel = itemView.findViewById(R.id.textViewPopulationLabel);
                planetPopulation = itemView.findViewById(R.id.textViewPopulation);
                planetClimateLabel = itemView.findViewById(R.id.textViewClimateLabel);
                planetClimate = itemView.findViewById(R.id.textViewClimate);
                planetTerrainLabel = itemView.findViewById(R.id.textViewTerrainLabel);
                planetTerrain = itemView.findViewById(R.id.textViewTerrain);
                planetSurfaceWaterLabel = itemView.findViewById(R.id.textViewSurfaceWaterLabel);
                planetSurfaceWater = itemView.findViewById(R.id.textViewSurfaceWater);


                planetName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
// toggle visibility of the other TextViews here
                        if (planetDiameter.getVisibility() == View.VISIBLE) {
                            planetDiameterLabel.setVisibility(View.GONE);
                            planetDiameter.setVisibility(View.GONE);
                            planetRotationPeriodLabel.setVisibility(View.GONE);
                            planetRotationPeriod.setVisibility(View.GONE);
                            planetOrbitalPeriodLabel.setVisibility(View.GONE);
                            planetOrbitalPeriod.setVisibility(View.GONE);
                            planetGravityLabel.setVisibility(View.GONE);
                            planetGravity.setVisibility(View.GONE);
                            planetPopulationLabel.setVisibility(View.GONE);
                            planetPopulation.setVisibility(View.GONE);
                            planetClimateLabel.setVisibility(View.GONE);
                            planetClimate.setVisibility(View.GONE);
                            planetTerrainLabel.setVisibility(View.GONE);
                            planetTerrain.setVisibility(View.GONE);
                            planetSurfaceWaterLabel.setVisibility(View.GONE);
                            planetSurfaceWater.setVisibility(View.GONE);
                        } else {
                            planetDiameterLabel.setVisibility(View.VISIBLE);
                            planetDiameter.setVisibility(View.VISIBLE);
                            planetRotationPeriodLabel.setVisibility(View.VISIBLE);
                            planetRotationPeriod.setVisibility(View.VISIBLE);
                            planetOrbitalPeriodLabel.setVisibility(View.VISIBLE);
                            planetOrbitalPeriod.setVisibility(View.VISIBLE);
                            planetGravityLabel.setVisibility(View.VISIBLE);
                            planetGravity.setVisibility(View.VISIBLE);
                            planetPopulationLabel.setVisibility(View.VISIBLE);
                            planetPopulation.setVisibility(View.VISIBLE);
                            planetClimateLabel.setVisibility(View.VISIBLE);
                            planetClimate.setVisibility(View.VISIBLE);
                            planetTerrainLabel.setVisibility(View.VISIBLE);
                            planetTerrain.setVisibility(View.VISIBLE);
                            planetSurfaceWaterLabel.setVisibility(View.VISIBLE);
                            planetSurfaceWater.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        }
    }
}