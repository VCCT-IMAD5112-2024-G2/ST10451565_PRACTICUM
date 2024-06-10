package com.example.weather

package com.example.weather

import android.widget.Button
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UnitTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainScreen::class.java)

    @Test
    fun testAddButton() {
        onView(withId(R.id.dateEditText)).perform(replaceText("2024-06-10"))
        onView(withId(R.id.minTempEditText)).perform(replaceText("10"), closeSoftKeyboard())
        onView(withId(R.id.maxTempEditText)).perform(replaceText("20"), closeSoftKeyboard())
        onView(withId(R.id.weatherConditionEditText)).perform(replaceText("Sunny"), closeSoftKeyboard())
        onView(withId(R.id.addButton)).perform(click())

        // Check if data added successfully
        onView(withText("Data added successfully")).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }

    @Test
    fun testClearButton() {
        // Add some data first
        onView(withId(R.id.dateEditText)).perform(replaceText("2024-06-10"))
        onView(withId(R.id.minTempEditText)).perform(replaceText("10"), closeSoftKeyboard())
        onView(withId(R.id.maxTempEditText)).perform(replaceText("20"), closeSoftKeyboard())
        onView(withId(R.id.weatherConditionEditText)).perform(replaceText("Sunny"), closeSoftKeyboard())
        onView(withId(R.id.addButton)).perform(click())

        // Now clear data
        onView(withId(R.id.clearButton)).perform(click())

        // Check if data cleared successfully
        onView(withText("Data cleared")).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }

    @Test
    fun testDetailedViewButton() {
        // Add some data first
        onView(withId(R.id.dateEditText)).perform(replaceText("2024-06-10"))
        onView(withId(R.id.minTempEditText)).perform(replaceText("10"), closeSoftKeyboard())
        onView(withId(R.id.maxTempEditText)).perform(replaceText("20"), closeSoftKeyboard())
        onView(withId(R.id.weatherConditionEditText)).perform(replaceText("Sunny"), closeSoftKeyboard())
        onView(withId(R.id.addButton)).perform(click())

        // Click on detailed view button
        onView(withId(R.id.detailedViewButton)).perform(click())

        // Check if DetailedViewScreenActivity launched
        onView(withId(R.id.detailedViewLayout)).check(matches(isDisplayed()))
    }
}
