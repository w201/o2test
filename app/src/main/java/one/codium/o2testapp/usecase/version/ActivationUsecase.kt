package one.codium.o2testapp.usecase.version

fun interface ActivationUsecase {
    fun isActivationApproved(version: Int?): Boolean
}
