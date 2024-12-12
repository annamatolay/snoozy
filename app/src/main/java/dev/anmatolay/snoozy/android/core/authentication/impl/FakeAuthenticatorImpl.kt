package dev.anmatolay.snoozy.android.core.authentication.impl

import dev.anmatolay.snoozy.android.core.authentication.AuthenticatorWrapper
import dev.anmatolay.snoozy.android.core.exception.UnknownAuthErrorException
import kotlinx.coroutines.flow.flow

class FakeAuthenticatorImpl : AuthenticatorWrapper {

    var isSuccessful: Boolean = false
    var userId = "null"

    override fun signInAnonymously() = flow {
        if (isSuccessful) {
            emit(Result.success(userId))
        } else {
            emit(
                Result.failure(
                    UnknownAuthErrorException(
                        isSuccessful = false,
                        isCurrentUserNull = true,
                    )
                )
            )
        }
    }
}
