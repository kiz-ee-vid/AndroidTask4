package com.example.task_4

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.util.ArrayList

interface BankApi {
    @GET("https://belarusbank.by/api/atm?city=Гомель")
    suspend fun getListOfBanks(): Response<List<Bank>>
}

object BankApiImpl {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://belarusbank.by/api/atm/")
        .build()

    private val BankApiService = retrofit.create(BankApi::class.java)

    suspend fun getListOfBanks(): List<Bank>? {
        val list: MutableList<Bank> = ArrayList<Bank>().toMutableList()
        val response = BankApiService.getListOfBanks()
        return response.body()
    }
}