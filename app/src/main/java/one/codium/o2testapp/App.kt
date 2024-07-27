package one.codium.o2testapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import one.codium.o2testapp.repo.card.CardRepo
import javax.inject.Inject

@HiltAndroidApp
class App: Application() {
    @Inject
    lateinit var cardRepo: CardRepo

    override fun onCreate() {
        super.onCreate()
        cardRepo.initCard()
    }
}
