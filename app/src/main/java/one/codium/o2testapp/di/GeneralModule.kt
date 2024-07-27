package one.codium.o2testapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GeneralModule {

    @Provides
    @Singleton
    @CoroutineScopeGlobal
    fun provideGlobalScope(): CoroutineScope = GlobalScope

}
