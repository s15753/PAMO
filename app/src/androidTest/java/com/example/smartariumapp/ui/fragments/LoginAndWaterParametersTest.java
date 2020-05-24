package com.example.smartariumapp.ui.fragments;


import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.smartariumapp.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginAndWaterParametersTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    ArrayList<String> NO3Values = new ArrayList<>();
    ArrayList<String> NO2Values = new ArrayList<>();
    ArrayList<String> KHValues = new ArrayList<>();
    ArrayList<String> PHValues = new ArrayList<>();
    ArrayList<String> CLValues = new ArrayList<>();

    @Before
    public void setWaterParametersValues(){
        NO3Values.add("0");
        NO3Values.add("10");
        NO3Values.add("25");
        NO3Values.add("50");
        NO3Values.add("100");
        NO3Values.add("250");
        NO3Values.add("500");
        NO2Values.add("0");
        NO2Values.add("0.5");
        NO2Values.add("2");
        NO2Values.add("5");
        NO2Values.add("10");
        KHValues.add("0");
        KHValues.add("3");
        KHValues.add("6");
        KHValues.add("10");
        KHValues.add("15");
        KHValues.add("20");
        PHValues.add("6.4");
        PHValues.add("6.8");
        PHValues.add("7.2");
        PHValues.add("7.6");
        PHValues.add("8");
        PHValues.add("8.4");
        PHValues.add("9");
        CLValues.add("0");
        CLValues.add("0.8");
        CLValues.add("1.5");
        CLValues.add("3.0");
    }

    @Test
    public void loginAndWaterParametersTest() {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.username),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("user_name"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.password),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("password"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.password), withText("password"),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        SystemClock.sleep(150);
        appCompatEditText3.perform(pressImeActionButton());

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.login), withText("Zaloguj się"),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        SystemClock.sleep(150);
        appCompatButton.perform(click());
        for(int i = 1; i <= 7; i++) {
            ViewInteraction appCompatImageButton = onView(
                    allOf(withContentDescription("Open navigation drawer"),
                            childAtPosition(
                                    allOf(withId(R.id.toolbar),
                                            childAtPosition(
                                                    withClassName(is("com.google.android.material.appbar.AppBarLayout")),
                                                    0)),
                                    1),
                            isDisplayed()));
            SystemClock.sleep(150);
            appCompatImageButton.perform(click());

            ViewInteraction navigationMenuItemView = onView(
                    allOf(childAtPosition(
                            allOf(withId(R.id.design_navigation_view),
                                    childAtPosition(
                                            withId(R.id.nav_view),
                                            0)),
                            2),
                            isDisplayed()));
            SystemClock.sleep(150);
            navigationMenuItemView.perform(click());

            ViewInteraction button = onView(
                    allOf(withText("NO3 - Azotany"),
                            childAtPosition(
                                    allOf(withId(R.id.linearLayout),
                                            childAtPosition(
                                                    withClassName(is("android.widget.ScrollView")),
                                                    0)),
                                    1)));
            SystemClock.sleep(150);
            button.perform(scrollTo(), click());

            ViewInteraction button2 = onView(
                    allOf(withText(NO3Values.get(i-1)),
                            childAtPosition(
                                    allOf(withId(R.id.linearLayout),
                                            childAtPosition(
                                                    withClassName(is("android.widget.ScrollView")),
                                                    0)),
                                    i)));
            SystemClock.sleep(150);
            button2.perform(scrollTo(), click());

            if(i > 5) {
                ViewInteraction button3 = onView(
                        allOf(withText("0"),
                                childAtPosition(
                                        allOf(withId(R.id.linearLayout),
                                                childAtPosition(
                                                        withClassName(is("android.widget.ScrollView")),
                                                        0)),
                                        1)));
                SystemClock.sleep(150);
                button3.perform(scrollTo(), click());
            }else{
                ViewInteraction button3 = onView(
                        allOf(withText(NO2Values.get(i-1)),
                                childAtPosition(
                                        allOf(withId(R.id.linearLayout),
                                                childAtPosition(
                                                        withClassName(is("android.widget.ScrollView")),
                                                        0)),
                                        i)));
                SystemClock.sleep(150);
                button3.perform(scrollTo(), click());
            }

            ViewInteraction appCompatButton2 = onView(
                    allOf(withId(R.id.bt_GH_3), withText("3 d"),
                            childAtPosition(
                                    allOf(withId(R.id.linearLayout),
                                            childAtPosition(
                                                    withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                    1)),
                                    0),
                            isDisplayed()));
            SystemClock.sleep(150);
            appCompatButton2.perform(click());
            if(i > 6) {
                ViewInteraction button4 = onView(
                        allOf(withText("0"),
                                childAtPosition(
                                        allOf(withId(R.id.linearLayout),
                                                childAtPosition(
                                                        withClassName(is("android.widget.ScrollView")),
                                                        0)),
                                        1)));
                SystemClock.sleep(150);
                button4.perform(scrollTo(), click());
            }else{
                ViewInteraction button4 = onView(
                        allOf(withText(KHValues.get(i-1)),
                                childAtPosition(
                                        allOf(withId(R.id.linearLayout),
                                                childAtPosition(
                                                        withClassName(is("android.widget.ScrollView")),
                                                        0)),
                                        i)));
                SystemClock.sleep(150);
                button4.perform(scrollTo(), click());
            }

            ViewInteraction button5 = onView(
                    allOf(withText(PHValues.get(i-1)),
                            childAtPosition(
                                    allOf(withId(R.id.linearLayout),
                                            childAtPosition(
                                                    withClassName(is("android.widget.ScrollView")),
                                                    0)),
                                    i)));
            SystemClock.sleep(150);
            button5.perform(scrollTo(), click());

            ViewInteraction button6 = onView(
                    allOf(withText(CLValues.get(i/2)),
                            childAtPosition(
                                    allOf(withId(R.id.linearLayout),
                                            childAtPosition(
                                                    withClassName(is("android.widget.ScrollView")),
                                                    0)),
                                    (i/2+1))));
            SystemClock.sleep(150);
            button6.perform(scrollTo(), click());

            ViewInteraction button7 = onView(
                    allOf(withText("Wróć"),
                            childAtPosition(
                                    allOf(withId(R.id.linearLayout),
                                            childAtPosition(
                                                    withClassName(is("android.widget.ScrollView")),
                                                    0)),
                                    7)));
            SystemClock.sleep(150);
            button7.perform(scrollTo(), click());
            onView(allOf(withText(containsString("NO3: " + NO3Values.get(i-1))))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
            onView(allOf(withText(containsString("pH: " + PHValues.get(i-1))))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
            onView(allOf(withText(containsString("Cl: " + CLValues.get(i/2))))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
            onView(allOf(withText(containsString("GH1: 3")))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
            if(i > 5){
                onView(allOf(withText(containsString("NO2: 0")))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

            }else{
                onView(allOf(withText(containsString("NO2: " + NO2Values.get(i-1))))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
            }
            if(i > 6){
                onView(allOf(withText(containsString("KH: 0")))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
            }else{
                onView(allOf(withText(containsString("KH: " + KHValues.get(i-1))))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
            }
            ViewInteraction appCompatButton3 = onView(
                    allOf(withId(R.id.bt_clean), withText("Wyczyść"),
                            childAtPosition(
                                    childAtPosition(
                                            withId(R.id.send_values_display),
                                            0),
                                    2)));
            SystemClock.sleep(150);
            appCompatButton3.perform(scrollTo(), click());
        }
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
