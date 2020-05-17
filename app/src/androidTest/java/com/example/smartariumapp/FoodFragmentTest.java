package com.example.smartariumapp;

import android.content.Context;


import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.android21buttons.fragmenttestrule.FragmentTestRule;
import com.example.smartariumapp.ui.food.FoodFragment;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class FoodFragmentTest {
    @Rule
    public FragmentTestRule<?, FoodFragment> fragmentTestRule =
            FragmentTestRule.create(FoodFragment.class);

    @Test
    public void textDisplay(){
        fragmentTestRule.launchFragment(null);
        Espresso.onView(ViewMatchers.withId(R.id.text_food)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.smartariumapp", appContext.getPackageName());
    }
}