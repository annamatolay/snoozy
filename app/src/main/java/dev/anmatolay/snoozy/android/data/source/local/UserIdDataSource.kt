package dev.anmatolay.snoozy.android.data.source.local

import dev.anmatolay.snoozy.android.core.util.Constants.KEY_USER_ID
import dev.anmatolay.snoozy.android.core.util.SharedPrefHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.annotation.Factory

@Factory
class UserIdDataSource(private val sharedPrefHandler: SharedPrefHandler) {

    fun getUserId(): Flow<String?> = flow {
        val userId = sharedPrefHandler.getString(KEY_USER_ID)
        emit(userId)
    }

    fun putUserId(id: String): Flow<Unit> = flow {
        sharedPrefHandler.putString(KEY_USER_ID, id)
        emit(Unit)
    }
}
