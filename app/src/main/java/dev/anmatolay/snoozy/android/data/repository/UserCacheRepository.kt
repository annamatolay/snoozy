package dev.anmatolay.snoozy.android.data.repository

import dev.anmatolay.snoozy.android.data.source.local.UserIdDataSource
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

// Keep it simple if need more type of datasources in the future for user
@Factory
class UserCacheRepository(private val dataSource: UserIdDataSource) {

    fun retrieveUserId() = dataSource.getUserId()

    fun cacheUserId(id: String): Flow<Unit> = dataSource.putUserId(id)
}
