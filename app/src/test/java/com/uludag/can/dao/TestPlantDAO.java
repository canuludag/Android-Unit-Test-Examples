package com.uludag.can.dao;

import com.uludag.can.plantplacespacktfortdd.dao.IPlantDAO;
import com.uludag.can.plantplacespacktfortdd.dao.PlantDAOStub;
import com.uludag.can.plantplacespacktfortdd.dto.PlantDTO;

import org.json.JSONException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertTrue;

public class TestPlantDAO {

    // Define a variable for the DAO we are testing.
    IPlantDAO mPlantDAO;

    @BeforeClass
    public static void setupAllTests() {
        System.out.println("BeforeClass: running init for ALL tests.");
    }

    @Before
    public void setUp() throws Exception {
        mPlantDAO = new PlantDAOStub();
        System.out.println("Before: running init before EACH tests.");
    }

    @Test
    public void testPlantDAO_searchForRedbudShouldReturnAtLeastOneResult() throws IOException, JSONException {

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
        System.out.println("TEST: running redbud test.");

    }

    @Test
    public void testPlantDAO_searchForOakShouldReturnAtLeastOneWhiteOak() throws IOException, JSONException {

        // Assume we do not have a match at first
        boolean whiteOakFound = false;

        List<PlantDTO> plants = mPlantDAO.fetchPlants("Oak");

        for (PlantDTO plant : plants) {
            if (plant.getGenus().contains("Quercus") && plant.getSpecies().contains("alba")) {
                whiteOakFound = true;
            }
        }

        // Did we find a redbud?
        assertTrue(whiteOakFound);
        System.out.println("TEST: running white oak test.");

    }

    public void testPlantDAO_searchForEShouldReturnAtLeastTwoResults() throws IOException, JSONException {
        List<PlantDTO> plants = mPlantDAO.fetchPlants("e");
        int size = plants.size();
        boolean atLeastTwo = size > 2;
        assertTrue(atLeastTwo);
        System.out.println("TEST: this test should no run because it's not annotaded with @Test");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After: tearing down each test.");
    }

    @AfterClass
    public static void tearDownAllTests() {
        System.out.println("AfterClass: tearing down after all tests.");
    }
}
