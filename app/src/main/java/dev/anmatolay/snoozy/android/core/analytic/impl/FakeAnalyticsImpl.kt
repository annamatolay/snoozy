package dev.anmatolay.snoozy.android.core.analytic.impl

import android.os.Bundle
import dev.anmatolay.snoozy.android.core.analytic.AnalyticsWrapper

class FakeAnalyticsImpl() : AnalyticsWrapper {

    override fun setUserId(userId: String?) {
        // Do nothing
    }

    override fun setUserProperty(name: String, value: String) {
        // Do nothing
    }


    override fun logEven(name: String, bundle: Bundle) {
        // Do nothing
    }

}
