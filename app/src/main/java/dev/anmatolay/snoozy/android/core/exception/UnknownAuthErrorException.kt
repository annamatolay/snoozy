package dev.anmatolay.snoozy.android.core.exception

class UnknownAuthErrorException(isSuccessful: Boolean, isCurrentUserNull: Boolean) :
    RuntimeException(
        "Unknown error occurred during authentication. " +
            "Auth Task successful: $isSuccessful. Is user null: $isCurrentUserNull.",
    )
