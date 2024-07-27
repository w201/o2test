package one.codium.o2testapp.usecase.version

const val activationLimitApproval = 277028

class ActivationUsecaseImpl : ActivationUsecase {

    override fun isActivationApproved(version: Int?) =
        (version ?: 0) > activationLimitApproval

}
