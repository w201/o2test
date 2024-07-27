package one.codium.o2testapp.repo.card

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import one.codium.o2testapp.ds.Storage
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CardModule {

    @Provides
    @Singleton
    fun provideCardRepo(storage: Storage): CardRepo {
        return CardRepoImpl(storage)
    }

}
