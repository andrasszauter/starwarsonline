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

public class VehiclesFragment extends Fragment {
    private RecyclerView recyclerView;
    private VehiclesAdapter vehiclesAdapter;
    private List<Vehicle> vehiclesList = new ArrayList<Vehicle>();
    private EditText searchEditText;


    public VehiclesFragment() {
        // Required empty public constructor
    }

    final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    final ApiInterface service = retrofit.create(ApiInterface.class);

    public void fetchVehiclesData() {
        Call<Vehicles> call = service.getVehicles();

        call.enqueue(new Callback<Vehicles>() {
            @Override
            public void onResponse(Call<Vehicles> call, Response<Vehicles> response) {
                Log.d("VehiclesFragment", "onResponse called");
                if (response.isSuccessful() && response.body().getVehicles() != null) {
                    vehiclesList = response.body().getVehicles();
                    vehiclesAdapter = new VehiclesAdapter(vehiclesList);
                    recyclerView.setAdapter(vehiclesAdapter);
                    Log.d("VehiclesFragment", "vehiclesList size: " + vehiclesList.size());

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
            public void onFailure(Call<Vehicles> call, Throwable t) {
                Log.e("API Error", "Error fetching data from API" + t.getMessage());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("VehiclesFragment", "onCreateView called");
        View view = inflater.inflate(R.layout.fragment_vehicles, container, false);
        recyclerView = view.findViewById(R.id.recViewVehicles);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fetchVehiclesData();
        vehiclesAdapter = new VehiclesAdapter(vehiclesList);
        recyclerView.setAdapter(vehiclesAdapter);
        searchEditText = view.findViewById(R.id.vehiclesSearchEditText);
        Button searchButton = view.findViewById(R.id.button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchTerm = searchEditText.getText().toString().toLowerCase();
                List<Vehicle> filteredVehicles = new ArrayList<>();
                for (Vehicle person : vehiclesList) {
                    if (person.getName().toLowerCase().matches(".*" + searchTerm + ".*")) {
                        filteredVehicles.add(person);
                    }
                }
                vehiclesAdapter.setVehicles(filteredVehicles);
            }
        });
        Button clearButton = view.findViewById(R.id.clear_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchEditText.setText("");
                vehiclesAdapter.setVehicles(vehiclesList);
            }
        });
        return view;
    }

    public class VehiclesAdapter extends RecyclerView.Adapter<VehiclesAdapter.ViewHolder> {
        private List<Vehicle> vehicles;

        public void setVehicles(List<Vehicle> vehicles) {
            this.vehicles = vehicles;
            notifyDataSetChanged();
        }

        public VehiclesAdapter(List<Vehicle> vehicles) {
            this.vehicles = vehicles;
        }

        @NonNull
        @Override
        public VehiclesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull VehiclesAdapter.ViewHolder holder, int position) {
            Vehicle vehicle = vehicles.get(position);

            holder.vehicleName.setText(vehicle.getName());
            holder.vehicleModel.setText(vehicle.getModel());
            holder.vehicleVehicleClass.setText(vehicle.getVehicle_class());
            holder.vehicleManufacturer.setText(vehicle.getManufacturer());
            holder.vehicleCostInCredits.setText(vehicle.getCost_in_credits());
            holder.vehicleLength.setText(vehicle.getLength());
            holder.vehicleCrew.setText(vehicle.getCrew());
            holder.vehiclePassengers.setText(vehicle.getPassengers());
            holder.vehicleMaxAtmospheringSpeed.setText(vehicle.getMax_atmosphering_speed());
            holder.vehicleCargoCapacity.setText(vehicle.getCargo_capacity());
            holder.vehicleConsumables.setText(vehicle.getConsumables());
            holder.vehicleModelLabel.setVisibility(View.GONE);
            holder.vehicleModel.setVisibility(View.GONE);
            holder.vehicleVehicleClassLabel.setVisibility(View.GONE);
            holder.vehicleVehicleClass.setVisibility(View.GONE);
            holder.vehicleManufacturerLabel.setVisibility(View.GONE);
            holder.vehicleManufacturer.setVisibility(View.GONE);
            holder.vehicleCostInCreditsLabel.setVisibility(View.GONE);
            holder.vehicleCostInCredits.setVisibility(View.GONE);
            holder.vehicleLengthLabel.setVisibility(View.GONE);
            holder.vehicleLength.setVisibility(View.GONE);
            holder.vehicleCrewLabel.setVisibility(View.GONE);
            holder.vehicleCrew.setVisibility(View.GONE);
            holder.vehiclePassengersLabel.setVisibility(View.GONE);
            holder.vehiclePassengers.setVisibility(View.GONE);
            holder.vehicleMaxAtmospheringSpeedLabel.setVisibility(View.GONE);
            holder.vehicleMaxAtmospheringSpeed.setVisibility(View.GONE);
            holder.vehicleCargoCapacityLabel.setVisibility(View.GONE);
            holder.vehicleCargoCapacity.setVisibility(View.GONE);
            holder.vehicleConsumablesLabel.setVisibility(View.GONE);
            holder.vehicleConsumables.setVisibility(View.GONE);
        }

        @Override
        public int getItemCount() {
            return vehicles.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView vehicleName;
            private final TextView vehicleModelLabel;
            private final TextView vehicleModel;
            private final TextView vehicleVehicleClassLabel;
            private final TextView vehicleVehicleClass;
            private final TextView vehicleManufacturerLabel;
            private final TextView vehicleManufacturer;
            private final TextView vehicleCostInCreditsLabel;
            private final TextView vehicleCostInCredits;
            private final TextView vehicleLengthLabel;
            private final TextView vehicleLength;
            private final TextView vehicleCrewLabel;
            private final TextView vehicleCrew;
            private final TextView vehiclePassengersLabel;
            private final TextView vehiclePassengers;
            private final TextView vehicleMaxAtmospheringSpeedLabel;
            private final TextView vehicleMaxAtmospheringSpeed;
            private final TextView vehicleCargoCapacityLabel;
            private final TextView vehicleCargoCapacity;
            private final TextView vehicleConsumablesLabel;
            private final TextView vehicleConsumables;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                vehicleName = itemView.findViewById(R.id.textViewName);
                vehicleModelLabel = itemView.findViewById(R.id.textViewModelLabel);
                vehicleModel = itemView.findViewById(R.id.textViewModel);
                vehicleVehicleClassLabel = itemView.findViewById(R.id.textViewVehicleClassLabel);
                vehicleVehicleClass = itemView.findViewById(R.id.textViewVehicleClass);
                vehicleManufacturerLabel = itemView.findViewById(R.id.textViewManufacturerLabel);
                vehicleManufacturer = itemView.findViewById(R.id.textViewManufacturer);
                vehicleCostInCreditsLabel = itemView.findViewById(R.id.textViewCostInCreditsLabel);
                vehicleCostInCredits = itemView.findViewById(R.id.textViewCostInCredits);
                vehicleLengthLabel = itemView.findViewById(R.id.textViewLengthLabel);
                vehicleLength = itemView.findViewById(R.id.textViewLength);
                vehicleCrewLabel = itemView.findViewById(R.id.textViewCrewLabel);
                vehicleCrew = itemView.findViewById(R.id.textViewCrew);
                vehiclePassengersLabel = itemView.findViewById(R.id.textViewPassengersLabel);
                vehiclePassengers = itemView.findViewById(R.id.textViewPassengers);
                vehicleMaxAtmospheringSpeedLabel = itemView.findViewById(R.id.textViewMaxAtmospheringSpeedLabel);
                vehicleMaxAtmospheringSpeed = itemView.findViewById(R.id.textViewMaxAtmospheringSpeed);
                vehicleCargoCapacityLabel = itemView.findViewById(R.id.textViewCargoCapacityLabel);
                vehicleCargoCapacity = itemView.findViewById(R.id.textViewCargoCapacity);
                vehicleConsumablesLabel = itemView.findViewById(R.id.textViewConsumablesLabel);
                vehicleConsumables = itemView.findViewById(R.id.textViewConsumables);

                vehicleName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
// toggle visibility of the other TextViews here
                        if (vehicleModel.getVisibility() == View.VISIBLE) {
                            vehicleModelLabel.setVisibility(View.GONE);
                            vehicleModel.setVisibility(View.GONE);
                            vehicleVehicleClassLabel.setVisibility(View.GONE);
                            vehicleVehicleClass.setVisibility(View.GONE);
                            vehicleManufacturerLabel.setVisibility(View.GONE);
                            vehicleManufacturer.setVisibility(View.GONE);
                            vehicleCostInCreditsLabel.setVisibility(View.GONE);
                            vehicleCostInCredits.setVisibility(View.GONE);
                            vehicleLengthLabel.setVisibility(View.GONE);
                            vehicleLength.setVisibility(View.GONE);
                            vehicleCrewLabel.setVisibility(View.GONE);
                            vehicleCrew.setVisibility(View.GONE);
                            vehiclePassengersLabel.setVisibility(View.GONE);
                            vehiclePassengers.setVisibility(View.GONE);
                            vehicleMaxAtmospheringSpeedLabel.setVisibility(View.GONE);
                            vehicleMaxAtmospheringSpeed.setVisibility(View.GONE);
                            vehicleCargoCapacityLabel.setVisibility(View.GONE);
                            vehicleCargoCapacity.setVisibility(View.GONE);
                            vehicleConsumablesLabel.setVisibility(View.GONE);
                            vehicleConsumables.setVisibility(View.GONE);
                        } else {
                            vehicleModelLabel.setVisibility(View.VISIBLE);
                            vehicleModel.setVisibility(View.VISIBLE);
                            vehicleVehicleClassLabel.setVisibility(View.VISIBLE);
                            vehicleVehicleClass.setVisibility(View.VISIBLE);
                            vehicleManufacturerLabel.setVisibility(View.VISIBLE);
                            vehicleManufacturer.setVisibility(View.VISIBLE);
                            vehicleCostInCreditsLabel.setVisibility(View.VISIBLE);
                            vehicleCostInCredits.setVisibility(View.VISIBLE);
                            vehicleLengthLabel.setVisibility(View.VISIBLE);
                            vehicleLength.setVisibility(View.VISIBLE);
                            vehicleCrewLabel.setVisibility(View.VISIBLE);
                            vehicleCrew.setVisibility(View.VISIBLE);
                            vehiclePassengersLabel.setVisibility(View.VISIBLE);
                            vehiclePassengers.setVisibility(View.VISIBLE);
                            vehicleMaxAtmospheringSpeedLabel.setVisibility(View.VISIBLE);
                            vehicleMaxAtmospheringSpeed.setVisibility(View.VISIBLE);
                            vehicleCargoCapacityLabel.setVisibility(View.VISIBLE);
                            vehicleCargoCapacity.setVisibility(View.VISIBLE);
                            vehicleConsumablesLabel.setVisibility(View.VISIBLE);
                            vehicleConsumables.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        }
    }
}