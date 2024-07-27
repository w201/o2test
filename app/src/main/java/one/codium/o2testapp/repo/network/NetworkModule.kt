package one.codium.o2testapp.repo.network

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideNetworkRepo(api: O2API): NetworkRepo {
        return NetworkRepoImpl(api)
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(
        @ApplicationContext applicationContext: Context
    ): OkHttpClient {
        val builder = OkHttpClient.Builder().apply {
            readTimeout(20, TimeUnit.SECONDS)
            writeTimeout(20, TimeUnit.SECONDS)
            addInterceptor(ChuckerInterceptor.Builder(applicationContext).build())
        }
        return builder.build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(
        okHttpClient: OkHttpClient
    ) = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://api.o2.sk")
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .build()

    @Provides
    @Singleton
    internal fun provideO2API(retrofit: Retrofit): O2API = retrofit.create(O2API::class.java)

}
