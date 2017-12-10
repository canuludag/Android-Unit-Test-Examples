package com.uludag.can.plantplacespacktfortdd;

import com.uludag.can.plantplacespacktfortdd.dao.IPlantDAO;
import com.uludag.can.plantplacespacktfortdd.dao.PlantDAOStub;
import com.uludag.can.plantplacespacktfortdd.dto.PlantDTO;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertTrue;

public class TestPlantDAO {

    // Define a variable for the DAO we are testing.
    IPlantDAO mPlantDAO;

    @Before
    public void setUp() throws Exception {
        mPlantDAO = new PlantDAOStub();
    }

    @Test
    public void testPlantDAO_searchForRedbudShouldReturnAtLeastOneResult() {

        // Assume we do not have a match at first
        boolean redbudFound = false;

        List<PlantDTO> plants = mPlantDAO.fetchPlants("Redbud");

        for (PlantDTO plant : plants) {
            if (plant.getCommon().contains("Redbud")) {
                redbudFound = true;
            }
        }

        // Did we find a redbud?
        assertTrue(redbudFound);

    }

}
