package one.codium.o2testapp.repo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import one.codium.o2testapp.repo.scratch.ScratchRepo
import one.codium.o2testapp.repo.scratch.ScratchRepoImpl
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideScratchRepo(): ScratchRepo {
        return ScratchRepoImpl()
    }

}
