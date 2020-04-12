package com.test.mockserverespresso

import android.content.Intent
import android.os.SystemClock
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches


/**
 * Created by Vikas Rao on 29,March,2020
 *
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTets {
    @JvmField
    @Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java,false,false)


    private var webServer: MockWebServer? = null

    @Before
    @Throws(Exception::class)
    fun setup() {
        webServer = MockWebServer()
        webServer!!.start(8080)

    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        webServer!!.shutdown()
    }
    @Test
    fun test_Login_HasPasswordOfMoreThan6Letters() {
       // assertEquals("TestApplication", mActivityRule.getActivity().getApplication().getClass().getSimpleName());

        webServer!!.dispatcher = MockServerDispatcher()
        mActivityRule.launchActivity(Intent())
        onView(withId(R.id.button))
                .perform(click())
        SystemClock.sleep(3000)
        onView(withId(R.id.text_result)).check(matches(withText("Success: delectus aut autem")))
        SystemClock.sleep(3000)


    }


}