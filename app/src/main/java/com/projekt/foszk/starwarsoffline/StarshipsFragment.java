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

public class StarshipsFragment extends Fragment {
    private RecyclerView recyclerView;
    private StarshipsAdapter starshipsAdapter;
    private List<Starship> starshipsList = new ArrayList<Starship>();
    private EditText searchEditText;


    public StarshipsFragment() {
        // Required empty public constructor
    }

    final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    final ApiInterface service = retrofit.create(ApiInterface.class);

    public void fetchStarshipsData() {
        Call<Starships> call = service.getStarships();

        call.enqueue(new Callback<Starships>() {
            @Override
            public void onResponse(Call<Starships> call, Response<Starships> response) {
                Log.d("StarshipsFragment", "onResponse called");
                if (response.isSuccessful() && response.body().getStarships() != null) {
                    starshipsList = response.body().getStarships();
                    starshipsAdapter = new StarshipsAdapter(starshipsList);
                    recyclerView.setAdapter(starshipsAdapter);
                    Log.d("StarshipsFragment", "starshipsList size: " + starshipsList.size());

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
            public void onFailure(Call<Starships> call, Throwable t) {
                Log.e("API Error", "Error fetching data from API" + t.getMessage());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("StarshipsFragment", "onCreateView called");
        View view = inflater.inflate(R.layout.fragment_starships, container, false);
        recyclerView = view.findViewById(R.id.recViewStarships);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fetchStarshipsData();
        starshipsAdapter = new StarshipsAdapter(starshipsList);
        recyclerView.setAdapter(starshipsAdapter);
        searchEditText = view.findViewById(R.id.starshipsSearchEditText);
        Button searchButton = view.findViewById(R.id.button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchTerm = searchEditText.getText().toString().toLowerCase();
                List<Starship> filteredStarships = new ArrayList<>();
                for (Starship person : starshipsList) {
                    if (person.getName().toLowerCase().matches(".*" + searchTerm + ".*")) {
                        filteredStarships.add(person);
                    }
                }
                starshipsAdapter.setStarships(filteredStarships);
            }
        });
        Button clearButton = view.findViewById(R.id.clear_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchEditText.setText("");
                starshipsAdapter.setStarships(starshipsList);
            }
        });
        return view;
    }

    public class StarshipsAdapter extends RecyclerView.Adapter<StarshipsAdapter.ViewHolder> {
        private List<Starship> starships;

        public void setStarships(List<Starship> starships) {
            this.starships = starships;
            notifyDataSetChanged();
        }

        public StarshipsAdapter(List<Starship> starships) {
            this.starships = starships;
        }

        @NonNull
        @Override
        public StarshipsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.starship_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull StarshipsAdapter.ViewHolder holder, int position) {
            Starship starship = starships.get(position);

            holder.starshipName.setText(starship.getName());
            holder.starshipModel.setText(starship.getModel());
            holder.starshipStarshipClass.setText(starship.getStarship_class());
            holder.starshipManufacturer.setText(starship.getManufacturer());
            holder.starshipCostInCredits.setText(starship.getCost_in_credits());
            holder.starshipLength.setText(starship.getLength());
            holder.starshipCrew.setText(starship.getCrew());
            holder.starshipPassengers.setText(starship.getPassengers());
            holder.starshipMaxAtmospheringSpeed.setText(starship.getMax_atmosphering_speed());
            holder.starshipHyperdriveRating.setText(starship.getHyperdrive_rating());
            holder.starshipMGLT.setText(starship.getMGLT());
            holder.starshipCargoCapacity.setText(starship.getCargo_capacity());
            holder.starshipConsumables.setText(starship.getConsumables());
            holder.starshipModelLabel.setVisibility(View.GONE);
            holder.starshipModel.setVisibility(View.GONE);
            holder.starshipStarshipClassLabel.setVisibility(View.GONE);
            holder.starshipStarshipClass.setVisibility(View.GONE);
            holder.starshipManufacturerLabel.setVisibility(View.GONE);
            holder.starshipManufacturer.setVisibility(View.GONE);
            holder.starshipCostInCreditsLabel.setVisibility(View.GONE);
            holder.starshipCostInCredits.setVisibility(View.GONE);
            holder.starshipLengthLabel.setVisibility(View.GONE);
            holder.starshipLength.setVisibility(View.GONE);
            holder.starshipCrewLabel.setVisibility(View.GONE);
            holder.starshipCrew.setVisibility(View.GONE);
            holder.starshipPassengersLabel.setVisibility(View.GONE);
            holder.starshipPassengers.setVisibility(View.GONE);
            holder.starshipMaxAtmospheringSpeedLabel.setVisibility(View.GONE);
            holder.starshipMaxAtmospheringSpeed.setVisibility(View.GONE);
            holder.starshipHyperdriveRatingLabel.setVisibility(View.GONE);
            holder.starshipHyperdriveRating.setVisibility(View.GONE);
            holder.starshipMGLTLabel.setVisibility(View.GONE);
            holder.starshipMGLT.setVisibility(View.GONE);
            holder.starshipCargoCapacityLabel.setVisibility(View.GONE);
            holder.starshipCargoCapacity.setVisibility(View.GONE);
            holder.starshipConsumablesLabel.setVisibility(View.GONE);
            holder.starshipConsumables.setVisibility(View.GONE);
        }

        @Override
        public int getItemCount() {
            return starships.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView starshipName;
            private final TextView starshipModelLabel;
            private final TextView starshipModel;
            private final TextView starshipStarshipClassLabel;
            private final TextView starshipStarshipClass;
            private final TextView starshipManufacturerLabel;
            private final TextView starshipManufacturer;
            private final TextView starshipCostInCreditsLabel;
            private final TextView starshipCostInCredits;
            private final TextView starshipLengthLabel;
            private final TextView starshipLength;
            private final TextView starshipCrewLabel;
            private final TextView starshipCrew;
            private final TextView starshipPassengersLabel;
            private final TextView starshipPassengers;
            private final TextView starshipMaxAtmospheringSpeedLabel;
            private final TextView starshipMaxAtmospheringSpeed;
            private final TextView starshipHyperdriveRatingLabel;
            private final TextView starshipHyperdriveRating;
            private final TextView starshipMGLTLabel;
            private final TextView starshipMGLT;
            private final TextView starshipCargoCapacityLabel;
            private final TextView starshipCargoCapacity;
            private final TextView starshipConsumablesLabel;
            private final TextView starshipConsumables;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                starshipName = itemView.findViewById(R.id.textViewName);
                starshipModelLabel = itemView.findViewById(R.id.textViewModelLabel);
                starshipModel = itemView.findViewById(R.id.textViewModel);
                starshipStarshipClassLabel = itemView.findViewById(R.id.textViewStarshipClassLabel);
                starshipStarshipClass = itemView.findViewById(R.id.textViewStarshipClass);
                starshipManufacturerLabel = itemView.findViewById(R.id.textViewManufacturerLabel);
                starshipManufacturer = itemView.findViewById(R.id.textViewManufacturer);
                starshipCostInCreditsLabel = itemView.findViewById(R.id.textViewCostInCreditsLabel);
                starshipCostInCredits = itemView.findViewById(R.id.textViewCostInCredits);
                starshipLengthLabel = itemView.findViewById(R.id.textViewLengthLabel);
                starshipLength = itemView.findViewById(R.id.textViewLength);
                starshipCrewLabel = itemView.findViewById(R.id.textViewCrewLabel);
                starshipCrew = itemView.findViewById(R.id.textViewCrew);
                starshipPassengersLabel = itemView.findViewById(R.id.textViewPassengersLabel);
                starshipPassengers = itemView.findViewById(R.id.textViewPassengers);
                starshipMaxAtmospheringSpeedLabel = itemView.findViewById(R.id.textViewMaxAtmospheringSpeedLabel);
                starshipMaxAtmospheringSpeed = itemView.findViewById(R.id.textViewMaxAtmospheringSpeed);
                starshipHyperdriveRatingLabel = itemView.findViewById(R.id.textViewHyperdriveRatingLabel);
                starshipHyperdriveRating = itemView.findViewById(R.id.textViewHyperdriveRating);
                starshipMGLTLabel = itemView.findViewById(R.id.textViewMGLTLabel);
                starshipMGLT = itemView.findViewById(R.id.textViewMGLT);
                starshipCargoCapacityLabel = itemView.findViewById(R.id.textViewCargoCapacityLabel);
                starshipCargoCapacity = itemView.findViewById(R.id.textViewCargoCapacity);
                starshipConsumablesLabel = itemView.findViewById(R.id.textViewConsumablesLabel);
                starshipConsumables = itemView.findViewById(R.id.textViewConsumables);

                starshipName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
// toggle visibility of the other TextViews here
                        if (starshipModel.getVisibility() == View.VISIBLE) {
                            starshipModelLabel.setVisibility(View.GONE);
                            starshipModel.setVisibility(View.GONE);
                            starshipStarshipClassLabel.setVisibility(View.GONE);
                            starshipStarshipClass.setVisibility(View.GONE);
                            starshipManufacturerLabel.setVisibility(View.GONE);
                            starshipManufacturer.setVisibility(View.GONE);
                            starshipCostInCreditsLabel.setVisibility(View.GONE);
                            starshipCostInCredits.setVisibility(View.GONE);
                            starshipLengthLabel.setVisibility(View.GONE);
                            starshipLength.setVisibility(View.GONE);
                            starshipCrewLabel.setVisibility(View.GONE);
                            starshipCrew.setVisibility(View.GONE);
                            starshipPassengersLabel.setVisibility(View.GONE);
                            starshipPassengers.setVisibility(View.GONE);
                            starshipMaxAtmospheringSpeedLabel.setVisibility(View.GONE);
                            starshipMaxAtmospheringSpeed.setVisibility(View.GONE);
                            starshipHyperdriveRatingLabel.setVisibility(View.GONE);
                            starshipHyperdriveRating.setVisibility(View.GONE);
                            starshipMGLTLabel.setVisibility(View.GONE);
                            starshipMGLT.setVisibility(View.GONE);
                            starshipCargoCapacityLabel.setVisibility(View.GONE);
                            starshipCargoCapacity.setVisibility(View.GONE);
                            starshipConsumablesLabel.setVisibility(View.GONE);
                            starshipConsumables.setVisibility(View.GONE);
                        } else {
                            starshipModelLabel.setVisibility(View.VISIBLE);
                            starshipModel.setVisibility(View.VISIBLE);
                            starshipStarshipClassLabel.setVisibility(View.VISIBLE);
                            starshipStarshipClass.setVisibility(View.VISIBLE);
                            starshipManufacturerLabel.setVisibility(View.VISIBLE);
                            starshipManufacturer.setVisibility(View.VISIBLE);
                            starshipCostInCreditsLabel.setVisibility(View.VISIBLE);
                            starshipCostInCredits.setVisibility(View.VISIBLE);
                            starshipLengthLabel.setVisibility(View.VISIBLE);
                            starshipLength.setVisibility(View.VISIBLE);
                            starshipCrewLabel.setVisibility(View.VISIBLE);
                            starshipCrew.setVisibility(View.VISIBLE);
                            starshipPassengersLabel.setVisibility(View.VISIBLE);
                            starshipPassengers.setVisibility(View.VISIBLE);
                            starshipMaxAtmospheringSpeedLabel.setVisibility(View.VISIBLE);
                            starshipMaxAtmospheringSpeed.setVisibility(View.VISIBLE);
                            starshipHyperdriveRatingLabel.setVisibility(View.VISIBLE);
                            starshipHyperdriveRating.setVisibility(View.VISIBLE);
                            starshipMGLTLabel.setVisibility(View.VISIBLE);
                            starshipMGLT.setVisibility(View.VISIBLE);
                            starshipCargoCapacityLabel.setVisibility(View.VISIBLE);
                            starshipCargoCapacity.setVisibility(View.VISIBLE);
                            starshipConsumablesLabel.setVisibility(View.VISIBLE);
                            starshipConsumables.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        }
    }
}