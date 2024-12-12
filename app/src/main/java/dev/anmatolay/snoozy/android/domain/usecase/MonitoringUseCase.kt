package dev.anmatolay.snoozy.android.domain.usecase

import com.google.firebase.crashlytics.FirebaseCrashlytics
import dev.anmatolay.snoozy.android.BuildConfig
import dev.anmatolay.snoozy.android.core.analytic.AnalyticsWrapper
import dev.anmatolay.snoozy.android.core.logging.CrashlyticsLogTree
import dev.anmatolay.snoozy.android.core.logging.DiamondDebugTree
import dev.anmatolay.snoozy.android.core.util.UserProperty
import dev.anmatolay.snoozy.android.core.util.UserProperty.Companion.KEY_ANDROID_VERSION
import dev.anmatolay.snoozy.android.core.util.UserProperty.Companion.KEY_API_LEVEL
import dev.anmatolay.snoozy.android.core.util.UserProperty.Companion.KEY_APP_VERSION
import org.koin.core.annotation.Single
import timber.log.Timber

@Single
class MonitoringUseCase(
    private val analyticsWrapper: AnalyticsWrapper,
    private val userProperty: UserProperty,
    private val crashlytics: FirebaseCrashlytics = FirebaseCrashlytics.getInstance(),
) {

    fun setUserProperties() {
        analyticsWrapper.setUserProperty(KEY_APP_VERSION, userProperty.version)
        analyticsWrapper.setUserProperty(KEY_ANDROID_VERSION, userProperty.osVersion)
        analyticsWrapper.setUserProperty(KEY_API_LEVEL, userProperty.sdkVersion.toString())
        Timber.i("User properties set!")
        Timber.d(userProperty.toString())
    }

    fun setUpAnalyticsAndLogging(userId: String?) {
        analyticsWrapper.setUserId(userId)
        Timber.plant(
            if (BuildConfig.DEBUG)
                DiamondDebugTree()
            else
                CrashlyticsLogTree(crashlytics, userId)
        )
    }

    fun isCrashlyticsCollectionEnabled(isEnabled: Boolean) {
        crashlytics.isCrashlyticsCollectionEnabled = isEnabled

    }
}
