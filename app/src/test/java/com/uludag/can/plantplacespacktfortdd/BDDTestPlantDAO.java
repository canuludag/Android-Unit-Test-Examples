package com.uludag.can.plantplacespacktfortdd;

import com.uludag.can.plantplacespacktfortdd.dao.IPlantDAO;
import com.uludag.can.plantplacespacktfortdd.dao.NetworkDAO;
import com.uludag.can.plantplacespacktfortdd.dao.PlantDAO;
import com.uludag.can.plantplacespacktfortdd.dto.PlantDTO;
import com.uludag.can.plantplacespacktfortdd.utils.FakeRequestResponses;

import org.json.JSONException;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.mockito.Mockito.*;

public class BDDTestPlantDAO {

    private IPlantDAO mPlantDAO;
    private List<PlantDTO> plants;

    private String redbudJsonResponse = FakeRequestResponses.redbudJsonResponse;
    private String quercusJsonResponse = FakeRequestResponses.quercusJsonResponse;
    private String gibberishJsonResponse = FakeRequestResponses.gibberishJsonResponse;

    @Test
    public void testPlantDAO_fetchShouldReturnResultsForRedbud() throws IOException, JSONException {

        givenPlantDAOIsInitialized();
        whenSearchForRedbud();
        thenVerifyAtLeastOneCercisCanadensis();

    }

    private void givenPlantDAOIsInitialized() throws IOException {
        mPlantDAO = new PlantDAO();

        // Here is where we mock our NetworkDAO
        NetworkDAO networkDAO = mock(NetworkDAO.class);

        String baseUrl = "http://plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=";
        when(networkDAO.fetch(baseUrl + "skfksdjfnkdsjfksdjfnksd")).thenReturn(gibberishJsonResponse);
        when(networkDAO.fetch(baseUrl + "Quercus")).thenReturn(quercusJsonResponse);
        when(networkDAO.fetch(baseUrl + "Redbud")).thenReturn(redbudJsonResponse);

        mPlantDAO.setNetworkDAO(networkDAO);
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
                break;
            }
        }

        // Did we find a redbud?
        assertTrue(redbudFound);

    }

    @Test
    public void testPlantDAO_fetchShouldReturnAtLeastTwoOaksForQuercus() throws IOException, JSONException {
        givenPlantDAOIsInitialized();
        whenSearchForQuercus();
        thenVerifyTwoOaks();
    }

    private void whenSearchForQuercus() throws IOException, JSONException {

        plants = mPlantDAO.fetchPlants("Quercus");

    }

    private void thenVerifyTwoOaks() {

        // Assume we do not have a match at first
        boolean quercusRoburFound = false;

        for (PlantDTO plant : plants) {
            if (plant.getGenus().contains("Quercus")
                    && plant.getSpecies().contains("robur")
                    && plant.getCommon().contains("Oak")) {
                quercusRoburFound = true;
            }
        }

        // Did we find a Quercus Robur?
        assertTrue(quercusRoburFound);

        // Assume we do not have a match at first
        boolean quercusAlbaFound = false;

        for (PlantDTO plant : plants) {
            if (plant.getGenus().contains("Quercus")
                    && plant.getSpecies().contains("alba")
                    && plant.getCommon().contains("Oak")) {
                quercusAlbaFound = true;
            }
        }

        // Did we find a Quercus Alba?
        assertTrue(quercusAlbaFound);

    }

    @Test
    public void testPlantDAO_fetchShouldReturnNothingForGibberish() throws IOException, JSONException {

        givenPlantDAOIsInitialized();
        whenSearchForGibberish();
        thenVerifyNoResults();

    }

    private void whenSearchForGibberish() throws IOException, JSONException {

        plants = mPlantDAO.fetchPlants("skfksdjfnkdsjfksdjfnksd");

    }

    private void thenVerifyNoResults() {

        /*int size = plants.size();
        assertEquals(0, size);*/
        // We can use Hamcrest with one line instead of two lines at above
        assertThat(plants, empty());

    }

    @Test
    public void testPlantDAO_fetchShouldReturnGenusQuercusForQuercus() throws IOException, JSONException {

        givenPlantDAOIsInitialized();
        whenSearchForQuercus();
        thenVerifyAllGenusAreQuercus();

    }

    private void thenVerifyAllGenusAreQuercus() {

        for (PlantDTO plant : plants) {
            //assertEquals("Quercus", plant.getGenus());
            // We can eliminate that use Hamcrest instead
            assertThat(plant, hasProperty("genus", containsString("Quercus")));
        }

    }

}
