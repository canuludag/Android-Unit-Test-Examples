package com.uludag.can.plantplacespacktfortdd.ui;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.uludag.can.plantplacespacktfortdd.R;
import com.uludag.can.plantplacespacktfortdd.dto.PlantDTO;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class SearchPlantsActivityTest {

    @Rule
    public ActivityTestRule<SearchPlantsActivity> activityRule = new ActivityTestRule<>(SearchPlantsActivity.class);

    @Test
    public void searchForRedbudShouldReturnAtLeastOneResult() {

        Context context = InstrumentationRegistry.getContext();

        onView(withId(R.id.actPlantName)).perform(typeText("Redbud"));
        onView(withId(R.id.btnSearchPlants)).perform(click());

        List<PlantDTO> plants = activityRule.getActivity().getPlants();
        assertThat(plants, not(empty()));

    }
}