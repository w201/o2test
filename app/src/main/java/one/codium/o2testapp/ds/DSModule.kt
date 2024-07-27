package one.codium.o2testapp.ds

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DSModule {

    @Provides
    @Singleton
    fun provideStorage(): Storage {
        return InMemStorage()
    }

}
