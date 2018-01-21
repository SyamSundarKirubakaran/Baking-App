package com.bugscript.bakingapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

/**
 * Created by syamsundark on 21/01/18.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityGridTest {
    public static final String HEAD_NAME = "Ingredients";
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    @Test
    public void clickGridViewItem() {
        onData(anything()).inAdapterView(withId(R.id.gridview)).atPosition(1).perform(click());
        onView(withId(R.id.ingred_textView)).check(matches(withText(HEAD_NAME)));
    }
}
