package com.uludag.can.plantplacespacktfortdd.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.uludag.can.plantplacespacktfortdd.R;
import com.uludag.can.plantplacespacktfortdd.dto.PlantDTO;
import com.uludag.can.plantplacespacktfortdd.service.IPlantService;
import com.uludag.can.plantplacespacktfortdd.service.PlantService;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class SearchPlantsActivity extends AppCompatActivity implements View.OnClickListener {

    private static IPlantService mPlantService;
    private AutoCompleteTextView actPlantName;
    private Button btnSearchPlants;
    private static RecyclerView mRecyclerView;
    private static SearchPlantsAdapter mAdapter;
    private static List<PlantDTO> mPlants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_plants);

        actPlantName = findViewById(R.id.actPlantName);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.requestFocus();
        btnSearchPlants = findViewById(R.id.btnSearchPlants);
        btnSearchPlants.setOnClickListener(this);

        mPlantService = new PlantService();
    }

    public List<PlantDTO> getPlants() {
        return mPlants;
    }

    public void fetchPlants(String keyword) {
        new FetchAsyncTask().execute(keyword);
    }

    @Override
    public void onClick(View v) {
        if (!actPlantName.getText().toString().isEmpty()) {
            fetchPlants(actPlantName.getText().toString());
        } else {
            Toast.makeText(this, "Please enter a plant name!", Toast.LENGTH_SHORT).show();
        }
    }

    private static class FetchAsyncTask extends AsyncTask<String, Integer, List<PlantDTO>> {

        @Override
        protected List<PlantDTO> doInBackground(String... strings) {
            try {

                mPlants = mPlantService.fetchPlants(strings[0]);

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            return mPlants;
        }

        @Override
        protected void onPostExecute(List<PlantDTO> plants) {
            Log.d("RESPONSE", plants.toString());
            mAdapter = new SearchPlantsAdapter(plants);
            mRecyclerView.setAdapter(mAdapter);
        }
    }
}
