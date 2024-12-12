package dev.anmatolay.snoozy.android.core.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module

@Module
@ComponentScan("dev.anmatolay.snoozy.android.data")
class DataModule

@Module
@ComponentScan("dev.anmatolay.snoozy.android.domain")
class DomainModule

@Module
@ComponentScan("dev.anmatolay.snoozy.android.ui")
class UIModule

@Module
@ComponentScan("dev.anmatolay.snoozy.android.core.util")
class CoreUtilModule

// Only for prod.
@Module
@ComponentScan("dev.anmatolay.snoozy.android.core.firebase")
class FirebaseModule

// Only for testing
@Module
@ComponentScan("dev.anmatolay.snoozy.android.core.authentication.impl")
class FakeAuthenticationModule

// Only for testing
@Module
@ComponentScan("dev.anmatolay.snoozy.android.core.analytic.impl")
class FakeAnalyticsModule
