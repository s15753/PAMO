package com.example.smartariumapp.ui.login;


import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

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
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

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
public class LoginActivityAndOtherParametersTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void loginActivityAndOtherParametersTest() {
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
                        4),
                        isDisplayed()));
        SystemClock.sleep(250);
        navigationMenuItemView.perform(click());

        ViewInteraction button = onView(
                allOf(withText("Filtr"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                1)));
        SystemClock.sleep(150);
        button.perform(scrollTo(), click());

        ViewInteraction button2 = onView(
                allOf(withText("Czyszcenie"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                1)));
        SystemClock.sleep(150);
        button2.perform(scrollTo(), click());

        ViewInteraction button3 = onView(
                allOf(withText("Gąbka"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                4)));
        SystemClock.sleep(150);
        button3.perform(scrollTo(), click());

        ViewInteraction button4 = onView(
                allOf(withText("Wymiana"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                2)));
        SystemClock.sleep(150);
        button4.perform(scrollTo(), click());

        ViewInteraction button5 = onView(
                allOf(withText("Wata"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                5)));
        SystemClock.sleep(150);
        button5.perform(scrollTo(), click());

        ViewInteraction button6 = onView(
                allOf(withText("Czyszcenie"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                1)));
        SystemClock.sleep(150);
        button6.perform(scrollTo(), click());

        ViewInteraction button7 = onView(
                allOf(withText("Żwir"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                6)));
        SystemClock.sleep(150);
        button7.perform(scrollTo(), click());

        ViewInteraction button8 = onView(
                allOf(withText("Wróć"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                3)));
        SystemClock.sleep(150);
        button8.perform(scrollTo(), click());

        ViewInteraction button9 = onView(
                allOf(withText("Waga"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                2)));
        SystemClock.sleep(150);
        button9.perform(scrollTo(), click());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.matilda_mass),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.linearLayout),
                                        1),
                                1)));
        SystemClock.sleep(150);
        appCompatEditText4.perform(scrollTo(), replaceText("1000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.stefanie_mass),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.linearLayout),
                                        2),
                                1)));
        SystemClock.sleep(150);
        appCompatEditText5.perform(scrollTo(), replaceText("1200"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.bt_send), withText("Wyślij"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                3)));
        SystemClock.sleep(150);
        appCompatButton2.perform(scrollTo(), click());

        ViewInteraction button10 = onView(
                allOf(withText("Woda"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                3)));
        SystemClock.sleep(150);
        button10.perform(scrollTo(), click());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.bt_refill), withText("Dolanie"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                2),
                        isDisplayed()));
        SystemClock.sleep(150);
        appCompatButton3.perform(click());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.amount),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                3),
                        isDisplayed()));
        SystemClock.sleep(150);
        appCompatEditText6.perform(replaceText("20"), closeSoftKeyboard());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.bt_send), withText("Wyślij"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                        0),
                                4),
                        isDisplayed()));
        SystemClock.sleep(150);
        appCompatButton4.perform(click());

        ViewInteraction button11 = onView(
                allOf(withText("Żarówka"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                4)));
        SystemClock.sleep(150);
        button11.perform(scrollTo(), click());

        ViewInteraction button12 = onView(
                allOf(withText("Wymiana"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                1)));
        SystemClock.sleep(150);
        button12.perform(scrollTo(), click());

        ViewInteraction button13 = onView(
                allOf(withText("Wróć"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                5)));
        SystemClock.sleep(150);
        button13.perform(scrollTo(), click());
        SystemClock.sleep(250);
        onView(allOf(withText(containsString("Matylda: 1000")))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        onView(allOf(withText(containsString("Stefania: 1200")))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        onView(allOf(withText(containsString("Woda: 20")))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        onView(allOf(withText(containsString("Żarówka: wymiana")))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        onView(allOf(withText(containsString("Żwir: czyszczenie")))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        onView(allOf(withText(containsString("Wata: wymiana")))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        onView(allOf(withText(containsString("Gąbka: czyszczenie")))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        onView(allOf(withText(containsString("Ceramika")))).check(ViewAssertions.doesNotExist());
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
