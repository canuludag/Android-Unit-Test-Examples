package com.uludag.can.plantplacespacktfortdd;

import com.uludag.can.plantplacespacktfortdd.dao.IPlantDAO;
import com.uludag.can.plantplacespacktfortdd.dao.PlantDAO;
import com.uludag.can.plantplacespacktfortdd.dto.PlantDTO;

import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertTrue;

public class BDDTestPlantDAO {

    private IPlantDAO mPlantDAO;
    private List<PlantDTO> plants;

    @Test
    public void testPlantDAO_fetchShouldReturnResultsForRedbud() throws IOException, JSONException {

        givenPlantDAOIsInitialized();
        whenSearchForRedbud();
        thenVerifyAtLeastOneCercisCanadensis();

    }

    private void givenPlantDAOIsInitialized() {
        mPlantDAO = new PlantDAO();
    }

    private void whenSearchForRedbud() throws IOException, JSONException {
        plants = mPlantDAO.fetchPlants("Redbud");
    }

    private void thenVerifyAtLeastOneCercisCanadensis() throws IOException, JSONException {

        // Assume we do not have a match at first
        boolean redbudFound = false;

        for (PlantDTO plant : plants) {
            if (plant.getGenus().contains("Cercis") && plant.getSpecies().contains("canadensis")) {
                redbudFound = true;
            }
        }

        // Did we find a redbud?
        assertTrue(redbudFound);

    }
}
