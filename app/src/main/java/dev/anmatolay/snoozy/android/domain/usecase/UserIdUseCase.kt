package dev.anmatolay.snoozy.android.domain.usecase

import dev.anmatolay.snoozy.android.core.util.Constants.DEFAULT_USER_ID
import dev.anmatolay.snoozy.android.data.repository.UserCacheRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Factory

@Factory
class UserIdUseCase(private val repository: UserCacheRepository) {

    fun cache(id: String): Flow<Unit> = repository.cacheUserId(id)

    fun retrieve(): Flow<String> =
        repository.retrieveUserId()
            .map { it ?: DEFAULT_USER_ID }
}
