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
public class LoginAndFoodTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void loginAndFoodTest() {
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
        SystemClock.sleep(150);
        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("com.google.android.material.appbar.AppBarLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        SystemClock.sleep(250);
        appCompatImageButton.perform(click());

        ViewInteraction navigationMenuItemView = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        3),
                        isDisplayed()));
        SystemClock.sleep(150);
        navigationMenuItemView.perform(click());

        ViewInteraction button = onView(
                allOf(withText("Suchy"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                1)));
        SystemClock.sleep(150);
        button.perform(scrollTo(), click());

        ViewInteraction button2 = onView(
                allOf(withText("Suszone krewetki"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                1)));
        SystemClock.sleep(150);
        button2.perform(scrollTo(), click());

        ViewInteraction button3 = onView(
                allOf(withText("Mrożony"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                2)));
        SystemClock.sleep(150);
        button3.perform(scrollTo(), click());

        ViewInteraction button4 = onView(
                allOf(withText("Mrożone krewetki"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                1)));
        SystemClock.sleep(150);
        button4.perform(scrollTo(), click());

        ViewInteraction button5 = onView(
                allOf(withText("Inny"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                3)));
        SystemClock.sleep(150);
        button5.perform(scrollTo(), click());

        ViewInteraction button6 = onView(
                allOf(withText("Żywe rybki"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                1)));
        SystemClock.sleep(150);
        button6.perform(scrollTo(), click());

        ViewInteraction button7 = onView(
                allOf(withText("Inny"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                3)));
        SystemClock.sleep(150);
        button7.perform(scrollTo(), click());

        ViewInteraction button8 = onView(
                allOf(withText("Moczarka"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                3)));
        SystemClock.sleep(150);
        button8.perform(scrollTo(), click());

        ViewInteraction button9 = onView(
                allOf(withText("Wróć"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                4)));
        SystemClock.sleep(150);
        button9.perform(scrollTo(), click());

        onView(allOf(withText(containsString("Moczarka")))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        onView(allOf(withText(containsString("Suszone krewetki")))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        onView(allOf(withText(containsString("Mrożone krewetki")))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        onView(allOf(withText(containsString("Żywe rybki")))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("com.google.android.material.appbar.AppBarLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        SystemClock.sleep(150);
        appCompatImageButton2.perform(click());

        ViewInteraction navigationMenuItemView2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        3),
                        isDisplayed()));
        SystemClock.sleep(150);
        navigationMenuItemView2.perform(click());

        ViewInteraction button10 = onView(
                allOf(withText("Inny"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                3)));
        SystemClock.sleep(150);
        button10.perform(scrollTo(), click());

        ViewInteraction button11 = onView(
                allOf(withText("Moczarka"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                3)));
        SystemClock.sleep(150);
        button11.perform(scrollTo(), click());

        ViewInteraction button12 = onView(
                allOf(withText("Inny"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                3)));
        SystemClock.sleep(150);
        button12.perform(scrollTo(), click());

        ViewInteraction button13 = onView(
                allOf(withText("Żywe rybki"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                1)));
        SystemClock.sleep(150);
        button13.perform(scrollTo(), click());

        ViewInteraction button14 = onView(
                allOf(withText("Suchy"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                1)));
        SystemClock.sleep(150);
        button14.perform(scrollTo(), click());

        ViewInteraction button15 = onView(
                allOf(withText("Suszone krewetki"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                1)));
        SystemClock.sleep(150);
        button15.perform(scrollTo(), click());

        ViewInteraction button16 = onView(
                allOf(withText("Mrożony"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                2)));
        SystemClock.sleep(150);
        button16.perform(scrollTo(), click());

        ViewInteraction button17 = onView(
                allOf(withText("Mrożone krewetki"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                1)));
        SystemClock.sleep(150);
        button17.perform(scrollTo(), click());

        ViewInteraction button18 = onView(
                allOf(withText("Suchy"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                1)));
        SystemClock.sleep(150);
        button18.perform(scrollTo(), click());

        ViewInteraction button19 = onView(
                allOf(withText("Gotowy pokarm suchy"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                3)));
        SystemClock.sleep(150);
        button19.perform(scrollTo(), click());

        ViewInteraction button20 = onView(
                allOf(withText("Mrożony"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                2)));
        SystemClock.sleep(150);
        button20.perform(scrollTo(), click());

        ViewInteraction button21 = onView(
                allOf(withText("Mrożone stynki"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                2)));
        SystemClock.sleep(150);
        button21.perform(scrollTo(), click());

        ViewInteraction button22 = onView(
                allOf(withText("Inny"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                3)));
        SystemClock.sleep(150);
        button22.perform(scrollTo(), click());

        ViewInteraction button23 = onView(
                allOf(withText("Martwe rybki"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                2)));
        SystemClock.sleep(150);
        button23.perform(scrollTo(), click());

        ViewInteraction button24 = onView(
                allOf(withText("Wróć"),
                        childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                4)));
        SystemClock.sleep(150);
        button24.perform(scrollTo(), click());
        SystemClock.sleep(250);
        onView(allOf(withText(containsString("Moczarka")))).check(ViewAssertions.doesNotExist());
        onView(allOf(withText(containsString("Suszone krewetki")))).check(ViewAssertions.doesNotExist());
        onView(allOf(withText(containsString("Mrożone krewetki")))).check(ViewAssertions.doesNotExist());
        onView(allOf(withText(containsString("Żywe rybki")))).check(ViewAssertions.doesNotExist());
        onView(allOf(withText(containsString("Mrożone stynki")))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        onView(allOf(withText(containsString("Gotowy pokarm suchy")))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        onView(allOf(withText(containsString("Martwe rybki")))).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
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
