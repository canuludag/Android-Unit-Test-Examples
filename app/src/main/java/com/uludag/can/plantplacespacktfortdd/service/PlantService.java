package com.uludag.can.plantplacespacktfortdd.service;

import com.uludag.can.plantplacespacktfortdd.dao.IPlantDAO;
import com.uludag.can.plantplacespacktfortdd.dao.PlantDAOStub;
import com.uludag.can.plantplacespacktfortdd.dto.PlantDTO;

import java.util.List;

public class PlantService implements IPlantService {

    IPlantDAO mPlantDAO;

    public PlantService() {
        mPlantDAO = new PlantDAOStub();
    }

    @Override
    public List<PlantDTO> fetchPlants(String filter) {
        return mPlantDAO.fetchPlants(filter);
    }
}
