package com.mahendra.licius.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mahendra.licius.BuildConfig
import com.mahendra.licius.base.Constants
import com.mahendra.licius.network.RestApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

class RetrofitProvider {
    private var restApi : RestApi? = null
    companion object{
        private var retrofitProvider : RetrofitProvider? = null
        fun getInstance() : RetrofitProvider{
            if(retrofitProvider == null){
                retrofitProvider = RetrofitProvider()
            }
            return retrofitProvider!!;
        }

    }


    private fun getUnsafeOkHttpClient(builder: OkHttpClient.Builder): OkHttpClient.Builder{
        return try { // Create a trust manager that does not validate certificate chains
            val trustAllCerts =
                arrayOf<TrustManager>(
                    object : X509TrustManager {
                        override fun checkClientTrusted(
                            chain: Array<X509Certificate>,
                            authType: String
                        ) {
                        }

                        override fun checkServerTrusted(
                            chain: Array<X509Certificate>,
                            authType: String
                        ) {
                        }

                        override fun getAcceptedIssuers(): Array<X509Certificate> {
                            return arrayOf()
                        }
                    }
                )
            // Install the all-trusting trust manager
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())
            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory = sslContext.socketFactory
            builder.sslSocketFactory(
                sslSocketFactory,
                trustAllCerts[0] as X509TrustManager
            )
//            builder.hostnameVerifier { hostname, session -> true }
//            builder
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    constructor(){
        buildRestApi()
    }

    private fun buildRestApi() {
        val okHttpClient = OkHttpClient.Builder()
            .build()
        val gson : Gson = GsonBuilder()
            .setLenient()
            .create()

        var builder : Retrofit.Builder = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(getUnsafeOkHttpClient(getOkHttpBuilder()).build())
        restApi = builder.build().create(RestApi::class.java)
    }


    private fun getOkHttpBuilder(): OkHttpClient.Builder {
        val okHttpClient = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            okHttpClient.addInterceptor(logging)
        }
        return okHttpClient
    }

    fun provideApi(): RestApi {
        if(restApi == null){
            buildRestApi()
        }

        return restApi!!
    }
}