package com.learning.ramovies.lifecycle

import android.app.Activity
import android.app.Application
import android.content.pm.ActivityInfo
import android.os.Bundle
import com.learning.ramovies.login.LoginActivity

class ActivityCallback : Application.ActivityLifecycleCallbacks {
    override fun onActivityPaused(p0: Activity?) {
    }

    override fun onActivityResumed(activity: Activity?) {
        if(activity != null && activity !is LoginActivity) {
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
        }
    }

    override fun onActivityStarted(p0: Activity?) {
    }

    override fun onActivityDestroyed(p0: Activity?) {
    }

    override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {
    }

    override fun onActivityStopped(p0: Activity?) {
    }

    override fun onActivityCreated(p0: Activity?, p1: Bundle?) {
    }

}