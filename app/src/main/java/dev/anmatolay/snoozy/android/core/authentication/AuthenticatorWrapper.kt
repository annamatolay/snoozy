package dev.anmatolay.snoozy.android.core.authentication

import kotlinx.coroutines.flow.Flow

interface AuthenticatorWrapper {
    fun signInAnonymously(): Flow<Result<String>>
}
