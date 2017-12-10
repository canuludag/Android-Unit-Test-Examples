package com.uludag.can.plantplacespacktfortdd.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.uludag.can.plantplacespacktfortdd.R;
import com.uludag.can.plantplacespacktfortdd.dto.PlantDTO;
import com.uludag.can.plantplacespacktfortdd.service.IPlantService;
import com.uludag.can.plantplacespacktfortdd.service.PlantService;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class SearchPlantsActivity extends AppCompatActivity {

    private IPlantService mPlantService;
    private AutoCompleteTextView actPlantName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_plants);

        actPlantName = findViewById(R.id.actPlantName);

        mPlantService = new PlantService();
    }

    public void searchPlants(View view) throws IOException, JSONException {

        List<PlantDTO> plants = mPlantService.fetchPlants(actPlantName.getText().toString());

        for (PlantDTO plant : plants) {
            Toast.makeText(this, plant.toString(), Toast.LENGTH_LONG).show();
        }

    }
}
