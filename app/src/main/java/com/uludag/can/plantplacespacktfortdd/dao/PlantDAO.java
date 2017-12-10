package com.uludag.can.plantplacespacktfortdd.dao;

import com.uludag.can.plantplacespacktfortdd.dto.PlantDTO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlantDAO implements IPlantDAO {

    private NetworkDAO mNetworkDAO;

    public PlantDAO() {
        mNetworkDAO = new NetworkDAO();
    }

    @Override
    public List<PlantDTO> fetchPlants(String filter) throws IOException, JSONException {

        ArrayList<PlantDTO> allPlants = new ArrayList<>();

        String url = "http://plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=";
        String request = mNetworkDAO.fetch(url + filter);

        // The entire JSON string is in root
        JSONObject root = new JSONObject(request);

        // Get the first array
        JSONArray plants = root.getJSONArray("plants");

        for (int i = 0; i < plants.length(); i++) {
            //Individual plant object
            JSONObject plantObject = plants.getJSONObject(i);
            int id = plantObject.getInt("id");
            String genus = plantObject.getString("genus");
            String species = plantObject.getString("species");
            String cultivar = plantObject.getString("cultivar");
            String common = plantObject.getString("common");

            // Put them into PlantDTO
            PlantDTO plantDTO = new PlantDTO();
            plantDTO.setGuid(id);
            plantDTO.setGenus(genus);
            plantDTO.setSpecies(species);
            plantDTO.setCultivar(cultivar);
            plantDTO.setCommon(common);

            // Add to the collection
            allPlants.add(plantDTO);
        }

        System.out.println("Footbat");

        return allPlants;

    }
}
