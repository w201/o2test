package one.codium.o2testapp.repo.entity

import androidx.annotation.StringRes
import one.codium.o2testapp.R

enum class CardStatus(@StringRes val titleId: Int) {
    UNSCRATCHED(R.string.status_unscratched),
    SCRATCHED(R.string.status_scratched),
    ACTIVATED(R.string.status_activated)
}
