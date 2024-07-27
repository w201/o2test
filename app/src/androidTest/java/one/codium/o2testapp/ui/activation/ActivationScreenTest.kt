package one.codium.o2testapp.ui.activation

import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import one.codium.o2testapp.ds.InMemStorage
import one.codium.o2testapp.repo.card.CardRepoImpl
import one.codium.o2testapp.repo.entity.network.GetVersionResponse
import one.codium.o2testapp.repo.entity.network.NetworkResult
import one.codium.o2testapp.repo.network.NetworkRepo
import one.codium.o2testapp.ui.theme.O2TestAppTheme
import one.codium.o2testapp.usecase.version.ActivationUsecase
import org.junit.Rule
import org.junit.Test

class ActivationScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val networkRepo = object : NetworkRepo {
        override suspend fun getVersion(): NetworkResult<GetVersionResponse> {
            return NetworkResult.Success(GetVersionResponse(15))
        }
    }

    private val activationUsecase = ActivationUsecase { true }
    private val cardRepo = CardRepoImpl(InMemStorage())
    private val scope = TestScope()

    @Test
    fun scratchScreenTest() {

        val viewModel = ActivationScreenViewModel(networkRepo, activationUsecase, cardRepo, scope)

        composeTestRule.setContent {
            O2TestAppTheme {
                ActivationScreen(viewModel)
            }
        }
        scope.runTest {
            composeTestRule.onNodeWithTag("Activate").performClick()
            advanceUntilIdle()
            composeTestRule.onNodeWithTag("Activate").assertIsNotEnabled()
        }
    }
}
