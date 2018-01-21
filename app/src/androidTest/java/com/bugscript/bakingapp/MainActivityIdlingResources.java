package com.bugscript.bakingapp;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.anything;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingResource;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by syamsundark on 21/01/18.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityIdlingResources {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    private IdlingResource mIdlingResource;
    @Before
    public void registerIdlingResource() {
        mIdlingResource = mActivityTestRule.getActivity().getIdlingResource();
        Espresso.registerIdlingResources(mIdlingResource);
    }
    @Test
    public void idlingResourceTest() {
        onData(anything()).inAdapterView(withId(R.id.gridview)).atPosition(0).perform(click());
    }
    @After
    public void unregisterIdlingResource() {
        if (mIdlingResource != null) {
            Espresso.unregisterIdlingResources(mIdlingResource);
        }
    }
}
