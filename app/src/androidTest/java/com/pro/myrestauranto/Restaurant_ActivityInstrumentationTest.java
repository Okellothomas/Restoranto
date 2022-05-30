package com.pro.myrestauranto;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.not;

import android.view.View;
import android.widget.ListView;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class Restaurant_ActivityInstrumentationTest {
    private ListView listView;
    @Rule
    public ActivityScenarioRule<Restaurant_Activity> activityScenarioRule = new ActivityScenarioRule<Restaurant_Activity>(Restaurant_Activity.class);

    private View activityDecorView;
    @Before
    public void setUp(){
        activityScenarioRule.getScenario().onActivity(new ActivityScenario.ActivityAction<Restaurant_Activity>() {
            @Override
            public void perform(Restaurant_Activity activity) {
                activityDecorView = activity.getWindow().getDecorView();
            }
        });
    }

    @Test
    public void listItemClickDisplaysToastWithCorrectRestaurant() {
        String restuarantName = "Mi More Mole";
        onData(anything())
                .inAdapterView(withId(R.id.locationTextView))
                .atPosition(0)
                .perform(click());
        onView(withText(restuarantName)).inRoot(withDecorView(not(activityDecorView)))
                .check(matches(withText(restuarantName)));
    }
}
