package com.uludag.can.plantplacespacktfortdd.dao;

import com.uludag.can.plantplacespacktfortdd.dto.PlantDTO;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public interface IPlantDAO {

    /**
     * Accept filter text, and return a collection of plants that contain that filter
     *
     * @param filter the text we want to match in our returned list of plants
     * @return a list of plants that contaion the given filter text in either genus,
     */
    List<PlantDTO> fetchPlants(String filter) throws IOException, JSONException;

}
