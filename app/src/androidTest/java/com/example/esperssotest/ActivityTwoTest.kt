package com.example.esperssotest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class ActivityTwoTest{

    @get:Rule
    val activityTwoScenario = ActivityScenarioRule(ActivityTwo::class.java)


    @Test
    fun isActivityTwoInView(){
        onView(withId(R.id.twoMain)).check(matches(isDisplayed()))
    }



}