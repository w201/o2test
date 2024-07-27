package one.codium.o2testapp.ui.activation

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import one.codium.o2testapp.ds.InMemStorage
import one.codium.o2testapp.repo.card.CardRepo
import one.codium.o2testapp.repo.card.CardRepoImpl
import one.codium.o2testapp.repo.entity.network.GetVersionResponse
import one.codium.o2testapp.repo.entity.network.NetworkResult
import one.codium.o2testapp.repo.network.NetworkRepo
import one.codium.o2testapp.usecase.version.ActivationUsecase
import org.junit.Test

class ActivationScreenViewModelTest {

    private val networkRepo = object : NetworkRepo {
        override suspend fun getVersion(): NetworkResult<GetVersionResponse> {
            return NetworkResult.Success(GetVersionResponse(15))
        }

    }

    private val cardRepo = CardRepoImpl(InMemStorage())

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun activationViewModelTest() {
        val activationUsecase = ActivationUsecase { true }
        runTest {
            val viewModel = ActivationScreenViewModel(networkRepo, activationUsecase, cardRepo, this)
            viewModel.activate()
            assertEquals(true, viewModel.uiState.value.inProgress)
            advanceUntilIdle()
            assertEquals(true, viewModel.uiState.value.success)

        }
    }
}
