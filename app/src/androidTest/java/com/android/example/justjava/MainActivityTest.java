package com.android.example.justjava;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity>
            mActivityRule = new ActivityTestRule<>(MainActivity.class, false, true);

    @Test
    public void checkIfAllTheViewsAreDisplayed() {
        onView(withId(R.id.label_price_text_view)).check(matches(isDisplayed()));
        onView(withId(R.id.label_text_view)).check(matches(isDisplayed()));
        onView(withId(R.id.quantity_text_view)).check(matches(isDisplayed()));
        onView(withId(R.id.price_text_view)).check(matches(isDisplayed()));
    }

    @Test
    public void checkInitialValues() {
        onView(allOf(withId(R.id.quantity_text_view), withText("0"))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.price_text_view), withText("R$0,00"))).check(matches(isDisplayed()));
    }

    @Test
    public void whenOnClickIncrementButton_checkIfTheQuantityAndThePriceAreChanged() {
        onView(withId(R.id.increment_quantity_button)).perform(click());
        onView(allOf(withId(R.id.quantity_text_view), withText("1"))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.price_text_view), withText("R$15,00"))).check(matches(isDisplayed()));
    }

    @Test
    public void whenOnClickDecrementButton_checkIfTheQuantityAndThePriceAreChanged() {
        onView(withId(R.id.decrement_quantity_button)).perform(click());
        onView(allOf(withId(R.id.quantity_text_view), withText("0"))).check(matches(isDisplayed()));
    }

    @Test
    public void whenOnClickIncrementAndDecrementButton_checkIfTheQuantityAndThePriceAreChanged() {
        onView(withId(R.id.increment_quantity_button)).perform(click());
        onView(withId(R.id.increment_quantity_button)).perform(click());
        onView(allOf(withId(R.id.quantity_text_view), withText("2"))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.price_text_view), withText("R$30,00"))).check(matches(isDisplayed()));

        onView(withId(R.id.decrement_quantity_button)).perform(click());
        onView(allOf(withId(R.id.quantity_text_view), withText("1"))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.price_text_view), withText("R$15,00"))).check(matches(isDisplayed()));

        onView(withId(R.id.decrement_quantity_button)).perform(click());
        onView(allOf(withId(R.id.quantity_text_view), withText("0"))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.price_text_view), withText("R$0,00"))).check(matches(isDisplayed()));
    }

}
