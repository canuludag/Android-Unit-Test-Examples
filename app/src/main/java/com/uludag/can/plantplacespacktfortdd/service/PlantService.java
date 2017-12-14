package com.uludag.can.plantplacespacktfortdd.service;

import com.uludag.can.plantplacespacktfortdd.dao.IPlantDAO;
import com.uludag.can.plantplacespacktfortdd.dao.PlantDAO;
import com.uludag.can.plantplacespacktfortdd.dto.PlantDTO;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class PlantService implements IPlantService {

    IPlantDAO mPlantDAO;

    public PlantService() {
        mPlantDAO = new PlantDAO();
    }

    @Override
    public List<PlantDTO> fetchPlants(String filter) throws IOException, JSONException {
        return mPlantDAO.fetchPlants(filter);
    }
}
