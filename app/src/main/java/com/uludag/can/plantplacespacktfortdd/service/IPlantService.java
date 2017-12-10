package com.uludag.can.plantplacespacktfortdd.service;

import com.uludag.can.plantplacespacktfortdd.dto.PlantDTO;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * Business logic for fetching and managing plants
 */
public interface IPlantService {

    /**
     * Return a series of plants that contain the specified filter text
     * @param filter text that should be contained in the returned plants
     * @return a list of plants that match the specified search criteria
     */
    List<PlantDTO> fetchPlants(String filter) throws IOException, JSONException;

}
