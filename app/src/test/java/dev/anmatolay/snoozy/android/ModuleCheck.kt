package dev.anmatolay.snoozy.android

import com.google.firebase.crashlytics.FirebaseCrashlytics
import dev.anmatolay.snoozy.android.core.analytic.AnalyticsWrapper
import dev.anmatolay.snoozy.android.core.authentication.AuthenticatorWrapper
import dev.anmatolay.snoozy.android.core.di.*
import dev.anmatolay.snoozy.android.core.util.SharedPrefHandler
import dev.anmatolay.snoozy.android.core.util.UserProperty
import dev.anmatolay.snoozy.android.data.repository.UserCacheRepository
import dev.anmatolay.snoozy.android.data.source.local.UserIdDataSource
import dev.anmatolay.snoozy.android.domain.usecase.AuthenticationUseCase
import dev.anmatolay.snoozy.android.domain.usecase.MonitoringUseCase
import dev.anmatolay.snoozy.android.domain.usecase.UserIdUseCase
import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.ksp.generated.module
import org.koin.test.verify.definition
import org.koin.test.verify.injectedParameters
import org.koin.test.verify.verify

class ModuleCheck: BaseTest() {

    @KoinExperimentalAPI
    @Test
    fun checkKoinModule() {
        CoreUtilModule().module.verify(
            injections = injectedParameters(
                definition<SharedPrefHandler>(android.content.Context::class)
            )
        )
        DataModule().module.verify(
            injections = injectedParameters(
                definition<UserIdDataSource>(SharedPrefHandler::class)
            )
        )
        DomainModule().module.verify(
            injections = injectedParameters(
                definition<AuthenticationUseCase>(AuthenticatorWrapper::class),
                definition<MonitoringUseCase>(AnalyticsWrapper::class, UserProperty::class, FirebaseCrashlytics::class),
                definition<UserIdUseCase>(UserCacheRepository::class),
            )
        )
        UIModule().module.verify()
    }
}
