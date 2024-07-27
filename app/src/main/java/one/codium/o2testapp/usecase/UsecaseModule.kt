package one.codium.o2testapp.usecase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import one.codium.o2testapp.repo.scratch.ScratchRepo
import one.codium.o2testapp.repo.scratch.ScratchRepoImpl
import one.codium.o2testapp.usecase.version.ActivationUsecase
import one.codium.o2testapp.usecase.version.ActivationUsecaseImpl
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {

    @Provides
    @Singleton
    fun provideActivationUsecase(): ActivationUsecase {
        return ActivationUsecaseImpl()
    }

}
