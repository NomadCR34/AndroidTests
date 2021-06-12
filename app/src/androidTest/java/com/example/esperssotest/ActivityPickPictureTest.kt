package com.example.esperssotest

import android.app.Activity.RESULT_OK
import android.app.Instrumentation
import android.app.Instrumentation.*
import android.content.ContentResolver
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.provider.MediaStore
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasData
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.Result
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ActivityPickPictureTest{

    @get:Rule
    val activityScenario = ActivityScenarioRule(ActivityPickPicture::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }


    @Test
    fun testValidateGalleryIntent(){

        val expectedIntent: Matcher<Intent> = allOf(
            hasAction(Intent.ACTION_PICK),
            hasData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        )
        val activityResult = createGalleryPickActivityResult()
        intending(expectedIntent).respondWith(activityResult)

        onView(withId(R.id.btnOpenGallery)).perform(click())
        intended(expectedIntent)
    }

    private fun createGalleryPickActivityResult(): ActivityResult{
        val resultIntent = Intent()
            activityScenario.scenario.onActivity {
                val resources = it.applicationContext.resources
                val imageUri = Uri.parse(
                    ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                            resources.getResourcePackageName(R.drawable.ic_launcher_background) + '/' +
                            resources.getResourceTypeName(R.drawable.ic_launcher_background) + '/' +
                            resources.getResourceEntryName(R.drawable.ic_launcher_background)
                )
                resultIntent.data = imageUri
            }

        return ActivityResult(RESULT_OK,resultIntent)
    }


}