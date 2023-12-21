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

public class SpeciesFragment extends Fragment {
    private RecyclerView recyclerView;
    private SpeciesAdapter speciesAdapter;
    private List<Spec> speciesList = new ArrayList<Spec>();
    private EditText searchEditText;

    public SpeciesFragment() {
        // Required empty public constructor
    }

    final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    final ApiInterface service = retrofit.create(ApiInterface.class);

    public void fetchSpeciesData() {
        Call<Species> call = service.getSpecies();

        call.enqueue(new Callback<Species>() {
            @Override
            public void onResponse(Call<Species> call, Response<Species> response) {
                Log.d("SpeciesFragment", "onResponse called");
                if (response.isSuccessful() && response.body().getSpecies() != null) {
                    speciesList = response.body().getSpecies();
                    speciesAdapter = new SpeciesAdapter(speciesList);
                    recyclerView.setAdapter(speciesAdapter);
                    Log.d("SpeciesFragment", "speciesList size: " + speciesList.size());

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
            public void onFailure(Call<Species> call, Throwable t) {
                Log.e("API Error", "Error fetching data from API" + t.getMessage());
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("SpeciesFragment", "onCreateView called");
        View view = inflater.inflate(R.layout.fragment_species, container, false);
        recyclerView = view.findViewById(R.id.recViewSpecies);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        fetchSpeciesData();
        speciesAdapter = new SpeciesAdapter(speciesList);
        recyclerView.setAdapter(speciesAdapter);
        searchEditText = view.findViewById(R.id.speciesSearchEditText);
        Button searchButton = view.findViewById(R.id.button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchTerm = searchEditText.getText().toString().toLowerCase();
                List<Spec> filteredSpecies = new ArrayList<>();
                for (Spec person : speciesList) {
                    if (person.getName().toLowerCase().matches(".*" + searchTerm + ".*")) {
                        filteredSpecies.add(person);
                    }
                }
                speciesAdapter.setSpecies(filteredSpecies);
            }
        });
        Button clearButton = view.findViewById(R.id.clear_button);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchEditText.setText("");
                speciesAdapter.setSpecies(speciesList);
            }
        });
        return view;
    }

    public class SpeciesAdapter extends RecyclerView.Adapter<SpeciesAdapter.ViewHolder> {
        private List<Spec> species;

        public void setSpecies(List<Spec> species) {
            this.species = species;
            notifyDataSetChanged();
        }

        public SpeciesAdapter(List<Spec> species) {
            this.species = species;
        }

        @NonNull
        @Override
        public SpeciesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.spec_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull SpeciesAdapter.ViewHolder holder, int position) {
            Spec spec = species.get(position);

            holder.specName.setText(spec.getName());
            holder.specClassification.setText(spec.getClassification());
            holder.specDesignation.setText(spec.getDesignation());
            holder.specAverageHeight.setText(spec.getAverage_height());
            holder.specAverageLifespan.setText(spec.getAverage_lifespan());
            holder.specEyeColors.setText(spec.getEye_colors());
            holder.specHairColors.setText(spec.getHair_colors());
            holder.specSkinColors.setText(spec.getSkin_colors());
            holder.specLanguage.setText(spec.getLanguage());
            holder.specClassificationLabel.setVisibility(View.GONE);
            holder.specClassification.setVisibility(View.GONE);
            holder.specDesignationLabel.setVisibility(View.GONE);
            holder.specDesignation.setVisibility(View.GONE);
            holder.specAverageHeightLabel.setVisibility(View.GONE);
            holder.specAverageHeight.setVisibility(View.GONE);
            holder.specAverageLifespanLabel.setVisibility(View.GONE);
            holder.specAverageLifespan.setVisibility(View.GONE);
            holder.specEyeColorsLabel.setVisibility(View.GONE);
            holder.specEyeColors.setVisibility(View.GONE);
            holder.specHairColorsLabel.setVisibility(View.GONE);
            holder.specHairColors.setVisibility(View.GONE);
            holder.specSkinColorsLabel.setVisibility(View.GONE);
            holder.specSkinColors.setVisibility(View.GONE);
            holder.specLanguageLabel.setVisibility(View.GONE);
            holder.specLanguage.setVisibility(View.GONE);
        }

        @Override
        public int getItemCount() {
            return species.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView specName;
            private final TextView specClassificationLabel;
            private final TextView specClassification;
            private final TextView specDesignationLabel;
            private final TextView specDesignation;
            private final TextView specAverageHeightLabel;
            private final TextView specAverageHeight;
            private final TextView specAverageLifespanLabel;
            private final TextView specAverageLifespan;
            private final TextView specEyeColorsLabel;
            private final TextView specEyeColors;
            private final TextView specHairColorsLabel;
            private final TextView specHairColors;
            private final TextView specSkinColorsLabel;
            private final TextView specSkinColors;
            private final TextView specLanguageLabel;
            private final TextView specLanguage;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                specName = itemView.findViewById(R.id.textViewName);
                specClassificationLabel = itemView.findViewById(R.id.textViewClassificationLabel);
                specClassification = itemView.findViewById(R.id.textViewClassification);
                specDesignationLabel = itemView.findViewById(R.id.textViewDesignationLabel);
                specDesignation = itemView.findViewById(R.id.textViewDesignation);
                specAverageHeightLabel = itemView.findViewById(R.id.textViewAverageHeightLabel);
                specAverageHeight = itemView.findViewById(R.id.textViewAverageHeight);
                specAverageLifespanLabel = itemView.findViewById(R.id.textViewAverageLifespanLabel);
                specAverageLifespan = itemView.findViewById(R.id.textViewAverageLifespan);
                specEyeColorsLabel = itemView.findViewById(R.id.textViewEyeColorsLabel);
                specEyeColors = itemView.findViewById(R.id.textViewEyeColors);
                specHairColorsLabel = itemView.findViewById(R.id.textViewHairColorsLabel);
                specHairColors = itemView.findViewById(R.id.textViewHairColors);
                specSkinColorsLabel = itemView.findViewById(R.id.textViewSkinColorsLabel);
                specSkinColors = itemView.findViewById(R.id.textViewSkinColors);
                specLanguageLabel = itemView.findViewById(R.id.textViewLanguageLabel);
                specLanguage = itemView.findViewById(R.id.textViewLanguage);


                specName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
// toggle visibility of the other TextViews here
                        if (specClassification.getVisibility() == View.VISIBLE) {
                            specClassificationLabel.setVisibility(View.GONE);
                            specClassification.setVisibility(View.GONE);
                            specDesignationLabel.setVisibility(View.GONE);
                            specDesignation.setVisibility(View.GONE);
                            specAverageHeightLabel.setVisibility(View.GONE);
                            specAverageHeight.setVisibility(View.GONE);
                            specAverageLifespanLabel.setVisibility(View.GONE);
                            specAverageLifespan.setVisibility(View.GONE);
                            specEyeColorsLabel.setVisibility(View.GONE);
                            specEyeColors.setVisibility(View.GONE);
                            specHairColorsLabel.setVisibility(View.GONE);
                            specHairColors.setVisibility(View.GONE);
                            specSkinColorsLabel.setVisibility(View.GONE);
                            specSkinColors.setVisibility(View.GONE);
                            specLanguageLabel.setVisibility(View.GONE);
                            specLanguage.setVisibility(View.GONE);
                        } else {
                            specClassificationLabel.setVisibility(View.VISIBLE);
                            specClassification.setVisibility(View.VISIBLE);
                            specDesignationLabel.setVisibility(View.VISIBLE);
                            specDesignation.setVisibility(View.VISIBLE);
                            specAverageHeightLabel.setVisibility(View.VISIBLE);
                            specAverageHeight.setVisibility(View.VISIBLE);
                            specAverageLifespanLabel.setVisibility(View.VISIBLE);
                            specAverageLifespan.setVisibility(View.VISIBLE);
                            specEyeColorsLabel.setVisibility(View.VISIBLE);
                            specEyeColors.setVisibility(View.VISIBLE);
                            specHairColorsLabel.setVisibility(View.VISIBLE);
                            specHairColors.setVisibility(View.VISIBLE);
                            specSkinColorsLabel.setVisibility(View.VISIBLE);
                            specSkinColors.setVisibility(View.VISIBLE);
                            specLanguageLabel.setVisibility(View.VISIBLE);
                            specLanguage.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        }
    }
}