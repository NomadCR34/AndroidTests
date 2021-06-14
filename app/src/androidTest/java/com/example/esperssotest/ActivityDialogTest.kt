package com.example.esperssotest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.esperssotest.ActivityDialog.Companion.buildToastMessage
import org.hamcrest.Matchers
import org.hamcrest.Matchers.not
import org.hamcrest.Matchers.`is`
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ActivityDialogTest{

    @get:Rule
    val activityScenario = ActivityScenarioRule(ActivityDialog::class.java)


    @Test
    fun testDialog(){
        val expectedName = "Android"
        onView(withId(R.id.btnDialog)).perform(click())
        onView(withText(R.string.enterName)).check(matches(isDisplayed()))
        onView(withId(R.id.edtDialogField)).perform(typeText(expectedName))
        onView(withText(R.string.enter)).perform(click())
        onView(withText(R.string.enterName)).check(doesNotExist())
        onView(withId(R.id.txtName)).check(matches(withText(expectedName)))
    }

    @Test
    fun testToast(){
        val expectedName = "Android"
        activityScenario.scenario.onActivity {
            onView(withText(buildToastMessage(expectedName))).inRoot(
                RootMatchers.withDecorView(not(`is`(it.window.decorView)))
            ).check(matches(isDisplayed()))
        }
    }


}