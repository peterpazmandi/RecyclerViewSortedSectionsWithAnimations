package com.inspirecoding.recyclerviewsortedsectionswithanimations

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.MediumTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.inspirecoding.recyclerviewsortedsectionswithanimations.databinding.ActivityMainBinding
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@MediumTest
@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {


    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_RV_click() {

        onView(withId(R.id.recycler_view))
            .perform(
                actionOnItemAtPosition<BaseViewHolder<ActivityMainBinding>>(
                    1, click()
                )
            )


    }

}