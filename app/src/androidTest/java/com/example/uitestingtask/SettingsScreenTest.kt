package com.example.uitestingtask

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.isChecked
import androidx.test.espresso.matcher.ViewMatchers.isNotChecked
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Rule
import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Test
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent

class SettingsScreenTest {
    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun testInitialSettings() {
        Intents.init()
        onView(withId(R.id.settingsButton)).perform(ViewActions.click())
        Intents.intended(hasComponent(SettingsActivity::class.java.name))
        onView(withId(R.id.clockSwitch)).check(matches(isNotChecked())) // Switch 1: Initially OFF
        onView(withId(R.id.ageSwitch)).check(matches(isNotChecked())) // Switch 2: Initially OFF
        onView(withId(R.id.profilePicSwitch)).check(matches(isChecked()))     // Switch 3: Initially ON
        onView(withId(R.id.reviewSwitch)).check(matches(isNotChecked()))   //Switch 2: Initially OFF
    }
}