package com.example.smartariumapp.ui.login;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.android21buttons.fragmenttestrule.FragmentTestRule;
import com.example.smartariumapp.R;
import com.example.smartariumapp.ui.other.FilterFragment;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class FilterFragmentTest {
    @Rule
    public FragmentTestRule<?, FilterFragment> fragmentTestRule =
            FragmentTestRule.create(FilterFragment.class);
    @Test
    public void linearLayoutDisplayed(){
        Espresso.onView(ViewMatchers.withId(R.id.linearLayout)).check(matches(isDisplayed()));
    }
    @Test
    public void textTitleDisplayed(){
        Espresso.onView(ViewMatchers.withId(R.id.text_filter)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
