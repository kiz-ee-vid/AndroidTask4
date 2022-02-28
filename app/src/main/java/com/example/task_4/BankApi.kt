package com.example.task_4

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface BankApi {
    @GET("api/atm?city=Гомель")
    suspend fun getListOfBanks(): Response<List<Bank>>
}

object BankApiImpl {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://belarusbank.by/api/atm/")
        .build()

    private val BankApiService = retrofit.create(BankApi::class.java)

    suspend fun getListOfBanks(): List<Bank>? {
        val response = BankApiService.getListOfBanks()
        return if(response.isSuccessful) {
            response.body()
        } else null
    }
}