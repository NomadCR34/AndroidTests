package com.example.esperssotest

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityOneTest{

    @get:Rule
    var activityOneScenario = ActivityScenarioRule(ActivityOne::class.java)

    @Test
    fun isActivityOneInView(){
        onView(withId(R.id.oneMain)).check(matches(isDisplayed()))
    }

    @Test
    fun isTextViewOneInView(){
        onView(withId(R.id.txtTextOne)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun checkTextViewOneText(){
        onView(withId(R.id.txtTextOne)).check(matches(withText("This is Test activity")))
    }

    @Test
    fun isActivityTwoInViewAfterClick(){
        onView(withId(R.id.testButton)).perform(click())
        onView(withId(R.id.twoMain)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.oneMain)).check(matches(isDisplayed()))
    }


}