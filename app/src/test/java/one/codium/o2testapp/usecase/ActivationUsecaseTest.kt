package one.codium.o2testapp.usecase

import junit.framework.TestCase.assertEquals
import one.codium.o2testapp.usecase.version.ActivationUsecase
import one.codium.o2testapp.usecase.version.ActivationUsecaseImpl
import one.codium.o2testapp.usecase.version.activationLimitApproval
import org.junit.Test

class ActivationUsecaseTest {

    @Test
    fun testActivation() {
        val activationUsecase = ActivationUsecaseImpl()
        assertEquals(false, activationUsecase.isActivationApproved(null))
        assertEquals(true, activationUsecase.isActivationApproved(activationLimitApproval+1))
        assertEquals(false, activationUsecase.isActivationApproved(activationLimitApproval-1))
    }
}
