package com.uludag.can.plantplacespacktfortdd.dao;

import com.uludag.can.plantplacespacktfortdd.dto.FlowerDTO;
import com.uludag.can.plantplacespacktfortdd.dto.PlantDTO;
import com.uludag.can.plantplacespacktfortdd.dto.TreeDTO;

import java.util.ArrayList;
import java.util.List;

public class PlantDAOStub implements IPlantDAO {
    @Override
    public void setNetworkDAO(NetworkDAO networkDAO) {

    }

    @Override
    public List<PlantDTO> fetchPlants(String filter) {

        List<PlantDTO> allPlants = new ArrayList<>();

        TreeDTO plant = new TreeDTO();
        plant.setGenus("Cercis");
        plant.setSpecies("canadensis");
        plant.setCommon("Eastern Redbud");
        plant.setSize(30);
        plant.setType("tree");
        plant.setFallColor("Yellowish");
        allPlants.add(plant);

        PlantDTO flower = new FlowerDTO();
        flower.setGenus("Tropoleum");
        flower.setSpecies("spp");
        flower.setCommon("Nasturtium");
        flower.setType("flower");
        allPlants.add(flower);

        return allPlants;

    }
}
